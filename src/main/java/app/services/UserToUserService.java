package app.services;

import app.entity.UserToUser;

public interface UserToUserService {

    void createUserToUser(UserToUser userToUser);

    UserToUser readUserToUser(int userId);

    void updateUserToUser(UserToUser updatedUserToUser);

    void deleteUserToUser(int userId);


}
