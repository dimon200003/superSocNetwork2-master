package app.entity;

import java.util.Objects;

public class Admin {
    private int id;
    private String adminLogin;
    private String adminPassword;



    public Admin(int id, String adminLogin, String adminPassword) {
        this.id = id;
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    public Admin(String adminLogin, String adminPassword) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id && adminLogin.equals(admin.adminLogin) && adminPassword.equals(admin.adminPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adminLogin, adminPassword);
    }
}
