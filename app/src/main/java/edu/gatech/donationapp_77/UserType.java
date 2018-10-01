package edu.gatech.donationapp_77;

public enum UserType {
    GENERAL("Public User"),
    ADMIN("Adminstrator"),
    MANAGER("Manager"),
    EMPLOYEE("Location Employee");

    private String stringRep;

    UserType(String desc) {
        stringRep = desc;
    }

    @Override
    public String toString() {
        return stringRep;
    }
}
