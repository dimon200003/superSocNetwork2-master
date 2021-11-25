package app.servlet.user;

import app.dao.UserJdbcDao;
import app.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/useradd")
public class UserAddServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/User/userAddPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdInput = req.getParameter("userIdInput");
        String userAgeInput = req.getParameter("userAgeInput");
        String userPhoneNumberInput = req.getParameter("userPhoneNumberInput");
        String userAddressInput = req.getParameter("userAddressInput");
        String userNameInput = req.getParameter("userNameInput");
        String userPasswordInput = req.getParameter("userPasswordInput");


        int age = Integer.parseInt(userAgeInput);
        int phoneNumber = Integer.parseInt(userPhoneNumberInput);

        User user = new User(age, phoneNumber, userAddressInput, userNameInput, userPasswordInput);

        UserJdbcDao userJdbcDao = new UserJdbcDao();
        userJdbcDao.createUser(user);

        resp.sendRedirect("userlist");
    }
}

