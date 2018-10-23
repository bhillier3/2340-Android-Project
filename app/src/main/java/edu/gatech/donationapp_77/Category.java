package edu.gatech.donationapp_77;

public enum Category {
    CLOTHES("clothes"),
    ELECTRONICS("electronics"),
    DECORATION("decoration"),
    TOOLS("tools"),
    KITCHEN("kitchen"),
    BOOKS("books"),
    OFFICE("office"),
    TOYS("toys"),
    MISC("miscellaneous");

    private String stringRep;

    Category(String category) {
        stringRep = category;
    }

    @Override
    public String toString() { return stringRep; }
}
