package app.services;

import app.Connection.ConnectionPool;
import app.entity.Admin;
import app.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService{
    @Override
    public void createAdmin(Admin admin) {

        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `network_db`.`admin` (`admin_login`, `admin_password`) VALUES" +
                    " ('" + admin.getAdminLogin() + "', '" + admin.getAdminPassword() + "');";
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
    public void updateAdmin(Admin updatedAdmin) {


        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();


            int id = updatedAdmin.getId();
            String updatedAdminLogin = updatedAdmin.getAdminLogin();
            String updatedAdminPassword = updatedAdmin.getAdminPassword();


            String sql = "UPDATE `network_db`.`admin` SET `admin_login` = '" + updatedAdminLogin + "', `admin_password` =  '" + updatedAdminPassword + "'  WHERE (`admin_id` = '" + id + "');";
            statement.execute(sql);

            System.out.println("5435");
        } catch (SQLException e) {
            e.printStackTrace();
        }


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
    public List<Admin> readAllAdmins() {
        List<Admin> adminList = new ArrayList<>();


        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.admin;";

            ResultSet resultSet = statement.executeQuery(sql);
            while ( resultSet.next() ) {
                int id1 = resultSet.getInt("admin_id");
                String adminLogin = resultSet.getString(2);
                String adminPassword = resultSet.getString(3);

                Admin admin = new Admin(id1, adminLogin, adminPassword);
                adminList.add(admin);


            }
            return adminList;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }




    @Override
    public void deleteAdminById(int id) {

        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM `network_db`.`admin` WHERE (`admin_id` = '" + id + "');";
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

    public Admin readAdminByAdminLoginAndPass(String adminLogin, String password) {


        try {
            Connection connection = ConnectionPool.getConnection();

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM network_db.admin " +
                    "where admin_login = '" + adminLogin + "' and admin_password = '" + password + "'";

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int id1 = resultSet.getInt("admin_id");
                String adminLog = resultSet.getString(2);
                String password1 = resultSet.getString(3);


                Admin admin = new Admin(id1, adminLog, password1);
                return admin;

            }

            System.out.println("5");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

