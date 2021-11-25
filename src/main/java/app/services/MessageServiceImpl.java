package app.services;

import app.Connection.ConnectionPool;
import app.entity.Message;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceImpl implements MessageService{


    public static void main(String[] args) {
        int toId = 50;
        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.readMessageByToId(toId);
    }
    @Override
    public void createMessage(Message message) {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `network_db`.`message` (`from_id`, `to_id`,`message_content`) VALUES ('" + message.getFromId() + "', '" + message.getToId() + "', '" + message.getContent() + "');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message readMessageById(int messageId) {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.message where message_id =" + messageId;

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int id1 = resultSet.getInt("message_id");
                int formId = resultSet.getInt(2);
                int toId = resultSet.getInt(3);
                String content = resultSet.getString(4);


                Message message = new Message(id1, formId, content, toId);
                return message;

            }

            System.out.println("5");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateMessage(Message updatedMessage) {


        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();


            int messageId = updatedMessage.getMessageId();
            int updatedFromId = updatedMessage.getFromId();
            int updatedToId = updatedMessage.getToId();
            String updatedContent = updatedMessage.getContent();


            String sql = "UPDATE `network_db`.`message` SET `from_id` = '" + updatedFromId + "', `to_id` =  '" + updatedToId + "' ," +
                    " `message_content` = '" + updatedContent + "' WHERE (`message_id` = '" + messageId + "');";
            statement.execute(sql);

            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteMessageById(int messageId) {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM `network_db`.`message` WHERE (`message_id` = '" + messageId + "');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public List<Message> readAllMessages() {
        List<Message> messageList = new ArrayList<>();



        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.message ;";

            ResultSet resultSet = statement.executeQuery(sql);
            while ( resultSet.next() ) {
                int id1 = resultSet.getInt("message_id");
                int fromId = resultSet.getInt(2);
                int toId = resultSet.getInt(3);
                String content = resultSet.getString(4);


                Message message = new Message(id1, fromId, content, toId);
                messageList.add(message);


            }
            return messageList;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }




    @Override
    public List<Message> readMessageByToId(int toId) {
        List<Message> messageList = new ArrayList<>();

        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.message where to_id =" + toId;

            ResultSet resultSet = statement.executeQuery(sql);

            while ( resultSet.next() ) {
                int id = resultSet.getInt(1);
                int fromId = resultSet.getInt(2);
                int toId1 = resultSet.getInt("to_id");
                String content = resultSet.getString(4);


                Message message = new Message(id, fromId, content, toId1);
                messageList.add(message);


            }
            return messageList;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }


}
