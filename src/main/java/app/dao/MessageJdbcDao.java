package app.dao;

import app.entity.Message;
import app.services.MessageServiceImpl;

import java.util.List;

public class MessageJdbcDao implements MessageDao {


    @Override
    public void createMessage(Message message) {

        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.createMessage(message);


    }


    @Override
    public Message readMessageById(int messageId) {

        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.readMessageById(messageId);

        return null;
    }


    @Override
    public void updateMessage(Message updatedMessage) {

        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.updateMessage(updatedMessage);

    }

    @Override
    public void deleteMessageById(int messageId) {

        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.deleteMessageById(messageId);

    }


    public List<Message> readAllMessages() {


        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.readAllMessages();


        return messageService.readAllMessages();
    }
    public List<Message> readMessageByToId(int toId) {


        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.readMessageByToId(toId);



        return messageService.readMessageByToId(toId);
    }
}
