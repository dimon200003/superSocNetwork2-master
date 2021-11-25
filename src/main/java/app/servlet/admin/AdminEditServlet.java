package app.servlet.admin;

import app.dao.AdminJdbcDao;
import app.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminedit")
public class AdminEditServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminIdParam = req.getParameter("AdminIdParam");
        req.setAttribute("adminOldId", adminIdParam);

        String adminLoginParam = req.getParameter("AdminLoginParam");
        req.setAttribute("adminOldLogin", adminLoginParam);

        String adminPasswordParam = req.getParameter("AdminPasswordParam");
        req.setAttribute("adminOldPassword", adminPasswordParam);


        req.getRequestDispatcher("/Admin/adminEditPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminUpdatedIdString = req.getParameter("adminUpdatedId");
        String adminUpdatedLogin = req.getParameter("adminUpdatedLogin");
        String adminUpdatedPassword = req.getParameter("adminUpdatedPassword");
        int messageUpdatedId = Integer.parseInt(adminUpdatedIdString);


        Admin admin = new Admin(messageUpdatedId, adminUpdatedLogin, adminUpdatedPassword);

        AdminJdbcDao adminJdbcDao = new AdminJdbcDao();
        adminJdbcDao.updateAdmin(admin);


        resp.sendRedirect("adminlist");
    }

}
