package app.dao;

import app.entity.User;
import app.services.UserServiceImpl;

import java.util.List;

public class UserJdbcDao implements UserDao {

    @Override
    public void createUser(User user) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUser(user);
    }

    @Override
    public User readUserById(int id) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.readUserById(id);

        return null;
    }

    @Override
    public void updateUser(User updatedUser) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.updateUser(updatedUser);


    }

    @Override
    public void deleteUserById(int id) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.deleteUserById(id);

    }


    public List<User> readAllUsers() {


        UserServiceImpl userService = new UserServiceImpl();
        userService.readAllUsers();


        return userService.readAllUsers();
    }

    public User readUserByNameAndPass(String name, String password) {

        User user = new User();

        UserServiceImpl userService = new UserServiceImpl();
        userService.readUserByNameAndPass(name, password);
        return userService.readUserByNameAndPass(name, password);


    }
}


