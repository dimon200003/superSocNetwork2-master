package app.dao;

import app.entity.UserToUser;

public interface UserToUserDao {

    void createUserToUser(UserToUser userToUser);

    UserToUser readUserToUser(int userId);

    void updateUserToUser(UserToUser updatedUserToUser);

    void deleteUserToUser(int userId);




}
