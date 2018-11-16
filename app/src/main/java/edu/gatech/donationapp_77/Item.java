package edu.gatech.donationapp_77;

class Item { //implements Parcelable {
    private final String name;
    private final double value;
    private final int quantity;
    private final String description;
    private final String comments;
    private final Category category;

    public Item(String name, double value, int quantity, String description, String comments, Category category) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.description = description;
        this.comments = comments;
        this.category = category;
    }

    /*
    // For Parcelable
    protected Item(Parcel in) {
        name = in.readString();
        value = in.readDouble();
        quantity = in.readInt();
        description = in.readString();
        comments = in.readString();
        category = Category.valueOf(in.readString());
    }
    */

    public String getName() {
        return this.name;
    }

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public double getValue() {
        return this.value;
    }

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setValue(int value) {
//        this.value = value;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public int getQuantity() {
        return this.quantity;
    }

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public String getDescription() {
        return this.description;
    }

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setDescription(String description) {
//        this.description = description;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public String getComments() {
        return this.comments;
    }

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public Category getCategory() {
        return this.category;
    }

    /*
    ////////////////////
    // For Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(value);
        dest.writeInt(quantity);
        dest.writeString(description);
        dest.writeString(comments);
        dest.writeString(category.toString());
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
    ////////////////////

    */

}
