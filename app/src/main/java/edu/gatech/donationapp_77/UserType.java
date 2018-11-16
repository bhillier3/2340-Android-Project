package edu.gatech.donationapp_77;

/**
 * Enum for types of users
 */
public enum UserType {
    GENERAL("Public User"),
    ADMIN("Administrator"),
    MANAGER("Manager"),
    EMPLOYEE("Location Employee");

    private final String stringRep;

    UserType(String desc) {
        stringRep = desc;
    }

    @Override
    public String toString() {
        return stringRep;
    }
}
