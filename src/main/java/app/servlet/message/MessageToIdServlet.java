package app.servlet.message;

import app.dao.MessageJdbcDao;
import app.entity.Message;
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
import java.util.List;

@WebServlet("/readmessages")
public class MessageToIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String toIdInput = request.getParameter("toIdInput");

        int toId = Integer.parseInt(toIdInput);
        MessageJdbcDao messageJdbcDao = new MessageJdbcDao();
        List<Message> messageList = messageJdbcDao.readMessageByToId(toId);

        request.setAttribute("messageList", messageList);


        request.getRequestDispatcher("/Message/messageListPage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
