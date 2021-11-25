package app.services;

import app.entity.Admin;
import app.entity.User;

import java.util.List;

public interface AdminService {
    void createAdmin(Admin admin);

    User readUserById(int id);

    void updateAdmin(Admin updatedAdmin);

    void updateUser(User updatedUser);

    void deleteAdminById(int id);

    void deleteUserById(int id);

    List<Admin> readAllAdmins();
}
