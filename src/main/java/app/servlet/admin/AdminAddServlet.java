package app.servlet.admin;

import app.dao.AdminJdbcDao;
import app.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminadd")
public class AdminAddServlet extends HttpServlet {


   @Override    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/Admin/adminAddPage.jsp");
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminIdinput = req.getParameter("adminIdInput");
    String adminLoginInput = req.getParameter("adminLoginInput");
     String AdminPasswordInput = req.getParameter("adminPasswordInput");

      Admin admin = new Admin(adminLoginInput, AdminPasswordInput);

       AdminJdbcDao adminJdbcDao = new AdminJdbcDao();
       adminJdbcDao.createAdmin(admin);
      resp.sendRedirect("adminlist");
    }
}
