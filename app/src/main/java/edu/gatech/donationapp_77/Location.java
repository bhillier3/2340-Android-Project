package edu.gatech.donationapp_77;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("EqualsAndHashcode")
public class Location implements Serializable {

    private final List<Item> inventory;
    private final LocationType type;
    private final String name;
    private final String latitude;
    private final String longitude;
    private final String address;
    private final String phoneNumber;

    private static ArrayList<Location> locationSet = new ArrayList<>();
    private static Location selectedLoc;

    public Location(LocationType type, String name, String latitude, String longitude,
                    String address, String phoneNumber) {
        this.type = type;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public static ArrayList<Location> getInstance() {
        return locationSet;
    }

    public static void updateFromJson(ArrayList lm) {
        if (lm == null) {
            return;
        }
        locationSet = lm;
    }

// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public ArrayList<Location> getLocationSet() {
//        if (locationSet == null) {
//            return null;
//        }
//        return locationSet;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    /*
    // For Parcelable
    protected Location(Parcel in) {
        name = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        type = LocationType.valueOf(in.readString());
        inventory = in.createTypedArrayList(Item.CREATOR);
    }
    */

    public static void addToLocationList(Location l) {
        if (!locationSet.contains(l)) {
            locationSet.add(l);
        }
    }

    public static ArrayList<Location> getLocationList() {
        return locationSet;
    }

    public static void setSelectedLoc(Location newLoc) {
        selectedLoc = newLoc;
    }

    public static Location getSelectedLoc() {
        return selectedLoc;
    }

    public Collection<Item> getInventory() { return inventory; }

    public LocationType getType() {
        return type;
    }
// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setType(LocationType type) {
//        this.type = type;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public String getName() {
        return name;
    }
// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public String getLatitude() {
        return latitude;
    }
// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public String getLongitude() {
        return longitude;
    }
// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public String getAddress() {
        return address;
    }
// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setAddress(String address) {
//        this.address = address;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    public String getPhoneNumber() {
        return phoneNumber;
    }
// --Commented out by Inspection START (11/15/18, 8:51 PM):
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
// --Commented out by Inspection STOP (11/15/18, 8:51 PM)

    @Override
    public String toString() {
        return this.getName();
    }

    // Override the equals method to prevent duplicates
    // Note: we should probably override the hashCode method as well if we plan
    // on using Location in something like a HashMap/HashSet later down the road
    @Override
    public boolean equals(Object other) {
        // Basic equality checks
        if (other == null) { return false; }
        if (this == other) { return true; }
        if (!(other instanceof Location)) { return false; }

        // Cast other to Location
        Location that = (Location) other;
        // Check for equal address, name and phone number
        return this.address.equals(that.getAddress())
                && this.name.equals(that.getName())
                && this.phoneNumber.equals(that.getPhoneNumber());
    }

    /*
    ////////////////////
    // For parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(phoneNumber);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(type.toString());
        dest.writeTypedList(inventory);
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    ////////////////////
    */
}