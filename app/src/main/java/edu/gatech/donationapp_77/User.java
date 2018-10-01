package edu.gatech.donationapp_77;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static ArrayList<User> userList = new ArrayList<User>();
    private String email;
    private String password;
    private UserType type;

    public User(String email, String password, UserType type) {
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

    public void setEmail(String newPassword) {
        password = newPassword;
    }

    public void setPassword(String newEmail) {
        email = newEmail;
    }

    public void setType(UserType newType) {
        this.type = newType;
    }

    public static void addUser(User newUser) {
        userList.add(newUser);
    }

    public static List<User> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return this.getEmail();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;

        return (this.getEmail().equals(that.getEmail()));
    }
}
