package app.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;


    @Column(name = "age")
    private int age;


    @Column(name = "phone_number")
    private int phoneNumber;


    @Column(name = "adress")
    private String address;


    @Column(name = "user_name")
    private String name;


    @Column(name = "user_password")
    private String password;

    public User(int age, int phoneNumber, String address, String name, String password) {
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public User(int id, int age, int phoneNumber, String address, String name, String password) {
        this.id = id;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && phoneNumber == user.phoneNumber && address.equals(user.address) && name.equals(user.name) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, phoneNumber, address, name, password);
    }
}
