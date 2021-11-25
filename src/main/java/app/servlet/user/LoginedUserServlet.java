package app.servlet.user;

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
@WebServlet("/userpage")
public class LoginedUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        User loginedUser = MyUtils.getLoginedUser(session);

        if (loginedUser == null) {

            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setAttribute("user", loginedUser);


        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/Login/loginedUser.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
