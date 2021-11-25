package app.servlet.admin;

import app.dao.AdminJdbcDao;
import app.dao.UserJdbcDao;
import app.entity.Admin;
import app.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/adminlist")
public class AdminListServlet extends HttpServlet {


    private int counter;
    static ArrayList<Admin> admins = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        counter++;
        req.setAttribute("some Text", counter);
        AdminJdbcDao adminJdbcDao = new AdminJdbcDao();
        List<Admin> adminList = adminJdbcDao.readAllAdmins();

        req.setAttribute("adminList", adminList);

        UserJdbcDao userJdbcDao = new UserJdbcDao();
        List<User> userList = userJdbcDao.readAllUsers();

        req.setAttribute("userList", userList);


        req.getRequestDispatcher("/Admin/adminListPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
