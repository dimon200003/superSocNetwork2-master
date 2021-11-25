package app.servlet.message;

import app.dao.MessageJdbcDao;
import app.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/messageedit")
public class MessageEditServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageIdParam = req.getParameter("MessageIdParam");
        req.setAttribute("messageOldId", messageIdParam);

        String messageFromIdParam = req.getParameter("MessageFromIdParam");
        req.setAttribute("messageOldFromIdParam", messageFromIdParam);

        String messageContentParam = req.getParameter("MessageContentParam");
        req.setAttribute("messageOldContentParam", messageContentParam);

        String messageToIdParam = req.getParameter("MessageToIdParam");
        req.setAttribute("messageOldToId", messageToIdParam);





        req.getRequestDispatcher("/Message/messageEditPage.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageUpdatedIdString = req.getParameter("messageUpdatedId");
        String messageUpdatedContent = req.getParameter("messageUpdatedContent");
        String messageUpdatedFromIdString = req.getParameter("messageUpdatedFromId");
        String messageUpdatedToIdString = req.getParameter("messageUpdatedToId");
        int messageUpdatedId = Integer.parseInt(messageUpdatedIdString);
        int messageUpdatedFromId = Integer.parseInt(messageUpdatedFromIdString);
        int messageUpdatedToId = Integer.parseInt(messageUpdatedToIdString);


        Message message = new Message(messageUpdatedId, messageUpdatedFromId, messageUpdatedContent, messageUpdatedToId);

        MessageJdbcDao messageJdbcDao = new MessageJdbcDao();
        messageJdbcDao.updateMessage(message);


        resp.sendRedirect("messagelist");
    }
}
