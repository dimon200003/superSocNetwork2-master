package app.servlet.message;



import app.dao.MessageJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/messagedelete")
public class MessageDeleteServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageIdString = req.getParameter("MessageIdParam");
        int messageId = Integer.parseInt(messageIdString);
        MessageJdbcDao messageJdbcDao = new MessageJdbcDao();
        messageJdbcDao.deleteMessageById(messageId);
        resp.sendRedirect("messagelist");
    }
}
