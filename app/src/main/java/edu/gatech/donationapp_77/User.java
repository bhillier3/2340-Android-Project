package edu.gatech.donationapp_77;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static ArrayList<User> userList = new ArrayList<User>();
    private static User loggedInUser;
    private String name;
    private String email;
    private String password;
    private UserType type;

    public User(String name, String email, String password, UserType type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public String getName() { return name; }

    public void setEmail(String newPassword) {
        password = newPassword;
    }

    public void setPassword(String newEmail) {
        email = newEmail;
    }

    public void setType(UserType newType) {
        this.type = newType;
    }

    public void setName(String name) { this.name = name; }

    public static void addUser(User newUser) {
        userList.add(newUser);
    }

    public static List<User> getUserList() {
        return userList;
    }

    public static User getLoggedInUser() {
        return User.loggedInUser;
    }

    public static void setLoggedInUser(User newUser) {
        User.loggedInUser = newUser;
    }


    @Override
    public String toString() {
        return this.getEmail() + ": " + this.getType();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof User)) { return false; }
        User that = (User) other;
        return (this.getEmail().equals(that.getEmail()));
    }
}
