package app.servlet.user;

import app.dao.UserJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/userdelete")
public class UserDeleteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdString = req.getParameter("UserIdParam");
        int userId = Integer.parseInt(userIdString);
        UserJdbcDao userJdbcDao = new UserJdbcDao();
        userJdbcDao.deleteUserById(userId);
        resp.sendRedirect("userlist");
    }
}
