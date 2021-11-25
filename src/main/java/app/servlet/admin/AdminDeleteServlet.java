package app.servlet.admin;

import app.dao.AdminJdbcDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admindelete")
public class AdminDeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminIdString = req.getParameter("AdminIdParam");
        int adminId = Integer.parseInt(adminIdString);
        AdminJdbcDao adminJdbcDao = new AdminJdbcDao();
        adminJdbcDao.deleteAdminById(adminId);
        resp.sendRedirect("adminlist");
    }
}
