package edu.gatech.donationapp_77;

public class Item {
    private String name;
    private double value;
    private int quantity;
    private String description;
    private String comments;
    private Category category;
    private Location location;

    public Item(String name, double value, int quantity, String description, String comments, Category category) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.description = description;
        this.comments = comments;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
