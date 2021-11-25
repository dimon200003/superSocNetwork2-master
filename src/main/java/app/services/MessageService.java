package app.services;

import app.entity.Message;

import java.util.List;

public interface MessageService {

    void createMessage(Message message);

    Message readMessageById(int id);

    void updateMessage(Message updatedMessage);

    void deleteMessageById(int id);



    List<Message> readMessageByToId(int toId);
}
