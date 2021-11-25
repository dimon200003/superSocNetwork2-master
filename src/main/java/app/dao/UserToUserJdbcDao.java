package app.dao;


import app.entity.UserToUser;
import app.services.UserToUserService;
import app.services.UserToUserServiceImpl;

public class UserToUserJdbcDao implements UserToUserDao {

    @Override
    public void createUserToUser(UserToUser userToUser) {

        UserToUserService userToUserService = new UserToUserServiceImpl();
        userToUserService.createUserToUser(userToUser);

    }

    @Override
    public UserToUser readUserToUser(int userId) {

        UserToUserService userToUserService = new UserToUserServiceImpl();
        userToUserService.readUserToUser(userId);

        return null;
    }

    @Override
    public void updateUserToUser(UserToUser updatedUserToUser) {

        UserToUserService userToUserService = new UserToUserServiceImpl();
        userToUserService.updateUserToUser(updatedUserToUser);

    }

    @Override
    public void deleteUserToUser(int userId) {

        UserToUserService userToUserService = new UserToUserServiceImpl();
        userToUserService.deleteUserToUser(userId);

    }
}