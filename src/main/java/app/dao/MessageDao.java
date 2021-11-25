package app.dao;

import app.entity.Message;


public interface MessageDao {

    void createMessage(Message message);

    Message readMessageById(int id);

    void updateMessage(Message updatedMessage);

    void deleteMessageById(int id);


}
