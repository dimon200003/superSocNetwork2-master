package app.servlet.user;

import app.dao.UserJdbcDao;
import app.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/useredit")
public class UserEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdParam = req.getParameter("UserIdParam");
        req.setAttribute("userOldId", userIdParam);

        String userNameParam = req.getParameter("UserNameParam");
        req.setAttribute("userOldName", userNameParam);

        String userAgeParam = req.getParameter("UserAgeParam");
        req.setAttribute("userOldAge", userAgeParam);

        String userPhoneNumberParam = req.getParameter("UserPhoneNumberParam");
        req.setAttribute("userOldPhoneNumber", userPhoneNumberParam);

        String userPasswordParam = req.getParameter("UserPasswordParam");
        req.setAttribute("userOldPassword", userPasswordParam);

        String userAddressParam = req.getParameter("UserAddressParam");
        req.setAttribute("userOldAddress", userAddressParam);



        req.getRequestDispatcher("/User/userEditPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userUpdatedIdString = req.getParameter("userUpdatedId");
        String userUpdatedName = req.getParameter("userUpdatedName");
        String userUpdatedAgeString = req.getParameter("userUpdatedAge");
        String userUpdatedPhoneNumberString = req.getParameter("userUpdatedPhoneNumber");
        String userUpdatedPassword = req.getParameter("userUpdatedPassword");
        String userUpdatedAddress = req.getParameter("userUpdatedAddress");
        int userUpdatedId = Integer.parseInt(userUpdatedIdString);
        int userUpdatedAge = Integer.parseInt(userUpdatedAgeString);
        int userUpdatedPhoneNumber = Integer.parseInt(userUpdatedPhoneNumberString);


        User user = new User(userUpdatedId, userUpdatedAge, userUpdatedPhoneNumber, userUpdatedAddress, userUpdatedName, userUpdatedPassword);

        UserJdbcDao userJdbcDao = new UserJdbcDao();
        userJdbcDao.updateUser(user);


        resp.sendRedirect("userlist");
    }
}
