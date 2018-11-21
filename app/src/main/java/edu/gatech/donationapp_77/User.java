package edu.gatech.donationapp_77;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class - POJO representing a user
 */
public class User {

    public static final User GUEST = new User(null, null);
    private static ArrayList<User> userList = new ArrayList<>();
    private static User loggedInUser;
    private String name;
    private String email;
    private String password;
    private UserType type;
    private Location location;
    private int failedLogins = 0;
    private boolean locked = false;

    /**
     * Simplest constructor - only takes in a email and password
     * @param email the email of the user
     * @param password the password of the user
     */
    public User(String email, String password) {
        this(null, email, password, null, null);
    }

    /**
     * More complex constructor - sets all fields
     * @param name the name
     * @param email the email
     * @param password the password
     * @param type the type
     * @param location the location assigned to a location employee
     */
    public User(String name, String email, String password, UserType type, Location location) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.type = type;
        this.location = location;
    }

    /**
     * Returns an instance of the static userlist
     * @return the instance
     */
    public static ArrayList<User> getInstance() {
        return userList;
    }

    /**
     * Pulls data from the json file for loading data
     * @param lm the arraylist returned from the json file
     */
    public static void updateFromJson(ArrayList lm) {
        if (lm == null)
            return;
        userList = lm;
    }

    /**
     * Getter for email
     * @return the string of the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * The getter for the password
     * @return string password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for the type
     * @return the type
     */
    public UserType getType() {
        return type;
    }

    /**
     * Getter for the name
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Setter for the password
     * @param newPassword new password
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    /**
     * Setter for the email
     * @param newEmail new email
     */
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    /**
     * Setter for the type
     * @param newType new type
     */
    public void setType(UserType newType) {
        this.type = newType;
    }

    /**
     * Setter for the name
     * @param name new name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Getter for the location
     * @return the location
     */
    public Location getLocation() { return location; }

    /**
     * Setter for the location
     * @param location new location
     */
    public void setLocation(Location location) { this.location = location; }

    /**
     * Static method to add a user to the data structure
     * @param newUser new user
     */
    public static void addUser(User newUser) {
        userList.add(newUser);
    }

    /**
     * Static method to get the data structure
     * @return the data structure
     */
    public static List<User> getUserList() {
        return userList;
    }

    /**
     * Static method to get the currently logged in user
     * @return the currently logged in user
     */
    public static User getLoggedInUser() {
        return User.loggedInUser;
    }

    /**
     * Set the logged in user (static)
     * @param newUser the new user
     */
    public static void setLoggedInUser(User newUser) {
        User.loggedInUser = newUser;
        newUser.resetFailedLogins();
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
        return (this.getEmail().equals(that.getEmail())
                && this.getPassword().equals(that.password));
    }

    public boolean isLocked() {
        return locked;
    }

    public int incrementLock() {
        failedLogins++;
        if (failedLogins > 2) {
            locked = true;
        }
        return failedLogins;
    }

    public void resetFailedLogins() {
        failedLogins = 0;
    }

    // should really switch to Map for User's to make this method better
    public static void failedLogin(String email) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getEmail().equals(email)) {
                user.incrementLock();
                return;
            }
        }
    }
}
