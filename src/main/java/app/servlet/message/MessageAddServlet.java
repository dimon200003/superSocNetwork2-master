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


@WebServlet("/messageadd")
public class MessageAddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/Message/messageAddPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User loginedUser = MyUtils.getLoginedUser(session);
        req.setAttribute("user", loginedUser);
        String messageIdInput = req.getParameter("messageIdInput");
        String messageContentInput = req.getParameter("messageContentInput");
        String messageToIdInput = req.getParameter("messageToIdInput");


        int fromId = loginedUser.getId();

        int toId = Integer.parseInt(messageToIdInput);

        Message message = new Message(fromId, messageContentInput, toId);

        MessageJdbcDao messageJdbcDao = new MessageJdbcDao();
        messageJdbcDao.createMessage(message);

        resp.sendRedirect("userpage");
    }



}
