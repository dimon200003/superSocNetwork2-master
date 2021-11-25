package app.servlet.login.user;


import app.Connection.ConnectionPool;
import app.dao.UserJdbcDao;
import app.entity.User;
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


@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Login/userLoginPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);

        System.out.println(name);
        System.out.println(password);

        User user = null;
        boolean hasError = false;
        String errorString = null;

        if (name == null || password == null || name.length() == 0 || password.length() == 0
        ) {
            hasError = true;
            errorString = "Required username and password!";
            System.out.println("error");
        } else {

            try {
                Connection conn = ConnectionPool.getConnection();
                UserJdbcDao userJdbcDao = new UserJdbcDao();
                userJdbcDao.readUserByNameAndPass(name, password);

                user = userJdbcDao.readUserByNameAndPass(name, password);

                if (user == null) {
                    hasError = true;
                    errorString = "User Name or password invalid";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            if (hasError) {
                user = new User();
                user.setName(name);
                user.setPassword(password);


                request.setAttribute("errorString", errorString);
                request.setAttribute("user", user);


                RequestDispatcher dispatcher //
                        = this.getServletContext().getRequestDispatcher("/Login/userLoginPage.jsp");

                dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                MyUtils.storeLoginedUser(session, user);


                if (remember) {
                    MyUtils.storeUserCookie(response, user);
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
