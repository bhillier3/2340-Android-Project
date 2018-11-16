package edu.gatech.donationapp_77;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class - POJO representing a user
 */
@SuppressWarnings({"EqualsAndHashcode", "unchecked", "AssignmentOrReturnOfFieldWithMutableType"})
public class User {

    private static ArrayList<User> userList = new ArrayList<>();
    private static User loggedInUser;
    private String name;
    private final String email;
    private final String password;
    private UserType type;
    private Location location;

    /**
     * Simplest constructor - only takes in a email and password
     * @param email the email of the user
     * @param password the password of the user
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
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
        this(email, password);
        this.name = name;
        this.type = type;
        this.location = location;
    }

    /**
     * Returns an instance of the static userlist
     * @return the instance
     */
    @SuppressWarnings("TypeMayBeWeakened")
    public static ArrayList<User> getInstance() {
        return userList;
    }

    /**
     * Pulls data from the json file for loading data
     * @param lm the arraylist returned from the json file
     */
    public static void updateFromJson(ArrayList lm) {
        if (lm == null) {
            return;
        }
        userList = lm;
    }

    /**
     * Getter for email
     * @return the string of the email
     */
    private String getEmail() {
        return email;
    }

    /**
     * The getter for the password
     * @return string password
     */
    private String getPassword() {
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

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    /**
//     * Setter for the password
//     * @param newPassword new password
//     */
//    public void setPassword(String newPassword) {
//        password = newPassword;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    /**
//     * Setter for the email
//     * @param newEmail new email
//     */
//    public void setEmail(String newEmail) {
//        email = newEmail;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    /**
//     * Setter for the type
//     * @param newType new type
//     */
//    public void setType(UserType newType) {
//        this.type = newType;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    /**
//     * Setter for the name
//     * @param name new name
//     */
//    public void setName(String name) { this.name = name; }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    /**
     * Getter for the location
     * @return the location
     */
    public Location getLocation() { return location; }

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    /**
//     * Setter for the location
//     * @param location new location
//     */
//    public void setLocation(Location location) { this.location = location; }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

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
        String thisEmail = this.getEmail();
        String thisPassword = this.getPassword();
        return (thisEmail.equals(that.getEmail())
                && thisPassword.equals(that.password));
    }
}
