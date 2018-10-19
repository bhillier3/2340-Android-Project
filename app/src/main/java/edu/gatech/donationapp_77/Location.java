package edu.gatech.donationapp_77;

import java.util.ArrayList;
import java.util.HashSet;

public class Location {

    private LocationType type;
    private String name;
    private String latitude;
    private String longitude;
    private String address;
    private String phoneNumber;

    private static ArrayList<Location> locationSet = new ArrayList<>();

    public Location(LocationType type, String name, String latitude, String longitude,
                    String address, String phoneNumber) {
        this.type = type;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public static void addToLocationList(Location l) {

        if (!locationSet.contains(l)) {
            locationSet.add(l);
        }

    }

    public static ArrayList<Location> getLocationList() {
        return locationSet;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Location: " + this.getName();
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
}
