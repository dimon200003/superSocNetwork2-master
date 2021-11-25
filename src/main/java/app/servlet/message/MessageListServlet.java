package app.servlet.message;

import app.dao.MessageJdbcDao;
import app.entity.Message;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/messagelist")
public class MessageListServlet extends HttpServlet {

    private int counter;
    static ArrayList<Message> messages = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        counter++;
        req.setAttribute("some Text", counter);
        MessageJdbcDao messageJdbcDao = new MessageJdbcDao();
        List<Message> messageList = messageJdbcDao.readAllMessages();

        req.setAttribute("messageList", messageList);


        req.getRequestDispatcher("/Message/messageListPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
