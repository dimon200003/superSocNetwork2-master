package app.servlet.message;

import app.dao.MessageJdbcDao;
import app.entity.Message;
import app.entity.User;
import app.util.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/messageresponse")
public class MessageResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String MessageToIdParam = req.getParameter("MessageToIdParam");
        req.setAttribute("MessageToIdParam", MessageToIdParam);

        String MessageFromIdParam = req.getParameter("MessageFromIdParam");
        req.setAttribute("MessageFromIdParam", MessageFromIdParam);

        req.getRequestDispatcher("/Message/messageResponsePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        User loginedUser = MyUtils.getLoginedUser(session);
        req.setAttribute("user", loginedUser);

        String messageIdInput = req.getParameter("messageIdInput");
        String messageContentInput = req.getParameter("messageContentInput");
        String messageToIdInput = req.getParameter("MessageToIdParam");



        int fromId = loginedUser.getId();

        int toId = Integer.parseInt(messageToIdInput);

        Message message = new Message(fromId, messageContentInput, toId);

        MessageJdbcDao messageJdbcDao = new MessageJdbcDao();
        messageJdbcDao.createMessage(message);

        resp.sendRedirect("userpage");
    }
}
