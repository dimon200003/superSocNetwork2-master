package app.services;

import app.Connection.ConnectionPool;
import app.entity.UserToUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserToUserServiceImpl implements UserToUserService{
    @Override
    public void createUserToUser(UserToUser userToUser) {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `network_db`.`user_to_user` (`user_id`, `user_message_target_id`) VALUES" +
                    " ('" + userToUser.getUserId() + "', '" + userToUser.getUserMessageTargetId() + "');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserToUser readUserToUser(int userId) {


        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.user_to_user where user_id =" + userId;

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int userId1 = resultSet.getInt("user_id");
                int userMessageTargetId = resultSet.getInt(2);




                UserToUser userToUser = new UserToUser(userId1, userMessageTargetId);
                return userToUser;

            }

            System.out.println("5");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }



        return null;
    }

    @Override
    public void updateUserToUser(UserToUser updatedUserToUser) {


        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();


            int userId = updatedUserToUser.getUserId();
            int userMessageTargetid = updatedUserToUser.getUserMessageTargetId();



            String sql = "UPDATE `network_db`.`user_to_user` SET `user_message_target_id` = '" + userMessageTargetid + "' WHERE (`user_id` = '" + userId + "');";
            statement.execute(sql);

            System.out.println("54321");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void deleteUserToUser(int userId) {


        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM `network_db`.`user_to_user` WHERE (`user_id` = '" + userId + "');";
            statement.execute(sql);
            System.out.println("54321");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

