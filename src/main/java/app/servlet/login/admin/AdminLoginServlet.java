package app.servlet.login.admin;

import app.Connection.ConnectionPool;
import app.dao.AdminJdbcDao;
import app.dao.UserJdbcDao;
import app.entity.Admin;
import app.entity.User;
import app.util.MyAdminUtils;
import app.util.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdminLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Login/adminLoginPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminlogin = request.getParameter("adminLogin");
        String password = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);

        System.out.println(adminlogin);
        System.out.println(password);

        Admin admin = null;
        boolean hasError = false;
        String errorString = null;

        if (adminlogin == null || password == null || adminlogin.length() == 0 || password.length() == 0
        ) {
            hasError = true;
            errorString = "Required username and password!";
            System.out.println("error");
        } else {

            try {
                Connection conn = ConnectionPool.getConnection();
                AdminJdbcDao adminJdbcDao = new AdminJdbcDao();
                adminJdbcDao.readAdminByAdminLoginAndPass(adminlogin, password);

                admin = adminJdbcDao.readAdminByAdminLoginAndPass(adminlogin, password);

                if (admin == null) {
                    hasError = true;
                    errorString = "Admin login or password invalid";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            if (hasError) {
                admin = new Admin();
                admin.setAdminLogin(adminlogin);
                admin.setAdminPassword(password);


                request.setAttribute("errorString", errorString);
                request.setAttribute("admin", admin);


                RequestDispatcher dispatcher //
                        = this.getServletContext().getRequestDispatcher("/Login/adminLoginPage.jsp");

                dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                MyAdminUtils.storeLoginedAdmin(session, admin);


                if (remember) {
                    MyAdminUtils.storeAdminCookie(response, admin);
                    System.out.println("remember");
                } else {
                    MyUtils.deleteUserCookie(response);
                    System.out.println("don't remember");
                }

                response.sendRedirect("http://localhost:8080/");

            }
        }
    }
}
