package edu.gatech.donationapp_77;

import java.util.ArrayList;

public class Location {

    private LocationType type;
    private String name;
    private String latitude;
    private String longitude;
    private String address;
    private String phoneNumber;

    private static ArrayList<Location> locationList = new ArrayList<>();

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
        locationList.add(l);
    }

    public static ArrayList<Location> getLocationList() {
        return locationList;
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

}
