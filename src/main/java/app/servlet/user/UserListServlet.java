package app.servlet.user;

import app.dao.UserJdbcDao;
import app.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
    
    private int counter;
    static ArrayList<User> users = new ArrayList<>();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        counter++;
        req.setAttribute("some Text", counter);
        UserJdbcDao userJdbcDao = new UserJdbcDao();
        List<User> userList = userJdbcDao.readAllUsers();

        req.setAttribute("userList", userList);



        req.getRequestDispatcher("/User/userListPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }



}
