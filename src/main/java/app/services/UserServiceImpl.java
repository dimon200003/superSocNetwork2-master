package app.services;

import app.Connection.ConnectionPool;
import app.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {

    @Override
    public void createUser(User user) {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `network_db`.`user` ( `user_name`, `user_password`, `age`,`phone_number`, `adress`) VALUES ( '" + user.getName() + "', '" + user.getPassword() + "', '" + user.getAge() + "', '" + user.getPhoneNumber() + "','" + user.getAddress() + "');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User readUserById(int id) {

        try {
            Connection connection = ConnectionPool.getConnection();

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.user where user_id =" + id;

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int id1 = resultSet.getInt("user_id");
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                int age = resultSet.getInt(4);
                int phoneNumber = resultSet.getInt(5);
                String address = resultSet.getString(6);


                User user = new User(id1, age, phoneNumber, address, name, password);
                return user;

            }

            System.out.println("5");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User updatedUser) {

        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();


            int id = updatedUser.getId();
            int updatedAge = updatedUser.getAge();
            int updatedPhoneNumber = updatedUser.getPhoneNumber();
            String updatedAddress = updatedUser.getAddress();
            String updatedName = updatedUser.getName();
            String updatedPassword = updatedUser.getPassword();


            String sql = "UPDATE `network_db`.`user` SET `user_name` = '" + updatedName + "', `user_password` =  '" + updatedPassword + "' ," +
                    " `age` = '" + updatedAge + "', `phone_number` = '" + updatedPhoneNumber + "', `adress` = '" + updatedAddress + "' WHERE (`user_id` = '" + id + "');";
            statement.execute(sql);

            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteUserById(int id) {

        try {

            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM `network_db`.`user` WHERE (`user_id` = '" + id + "');";
            statement.execute(sql);
            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> readAllUsers() {
        List<User> userList = new ArrayList<>();


        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.user ;";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id1 = resultSet.getInt("user_id");
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                int age = resultSet.getInt(4);
                int phoneNumber = resultSet.getInt(5);
                String address = resultSet.getString(6);

                User user = new User(id1, age, phoneNumber, address, name, password);
                userList.add(user);


            }
            return userList;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public User readUserByNameAndPass(String name, String password) {


        try {
            Connection connection = ConnectionPool.getConnection();

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.user " +
                    "where user_name = '" + name + "' and user_password = '" + password + "'";

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int id1 = resultSet.getInt("user_id");
                String name1 = resultSet.getString(2);
                String password1 = resultSet.getString(3);
                int age = resultSet.getInt(4);
                int phoneNumber = resultSet.getInt(5);
                String address = resultSet.getString(6);


                User user = new User(id1, age, phoneNumber, address, name1, password1);
                return user;

            }

            System.out.println("5");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}




