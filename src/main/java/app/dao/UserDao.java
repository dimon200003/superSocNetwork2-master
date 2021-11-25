package app.dao;


import app.entity.User;

import java.util.List;

public interface UserDao {


    void createUser(User user);

    User readUserById(int id);

    void updateUser(User updatedUser);

    void deleteUserById(int id);

    List<User> readAllUsers();


}
