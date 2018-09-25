package edu.gatech.donationapp_77;

public enum UserType {
    ADMIN("Adminstrator"), MANAGER("Manager"), EMPLOYEE("Location Employee");

    private String stringRep;

    UserType(String desc) {
        this.stringRep = desc;
    }

    @Override
    public String toString() {
        return stringRep;
    }
}
