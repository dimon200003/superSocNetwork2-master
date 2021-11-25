package app.dao;

import app.entity.Admin;
import app.entity.User;
import app.services.AdminServiceImpl;

import java.util.List;

public class AdminJdbcDao implements AdminDao {


    @Override
    public List<Admin> readAllAdmins() {

        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.readAllAdmins();

        return adminService.readAllAdmins();
    }

    @Override
    public void createAdmin(Admin admin) {

        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.createAdmin(admin);

    }

    @Override
    public User readUserById(int id) {

        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.readUserById(id);

        return null;
    }

    @Override
    public void updateAdmin(Admin updatedAdmin) {

        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.updateAdmin(updatedAdmin);

    }

    @Override
    public void updateUser(User updatedUser) {

        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.updateUser(updatedUser);


    }

    @Override
    public void deleteAdminById(int id) {

        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.deleteAdminById(id);

    }


    @Override
    public void deleteUserById(int id) {
// Тут специально стоит удаление юзера

        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.deleteUserById(id);

    }

    public Admin readAdminByAdminLoginAndPass(String adminLogin, String password) {


        AdminServiceImpl adminService = new AdminServiceImpl();
        adminService.readAdminByAdminLoginAndPass(adminLogin, password);
        return adminService.readAdminByAdminLoginAndPass(adminLogin, password);
    }
}
