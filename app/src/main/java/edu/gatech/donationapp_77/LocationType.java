package edu.gatech.donationapp_77;

public enum LocationType {
    DROP_OFF("Drop Off"), WAREHOUSE("Warehouse"), STORE("Store");

    private String stringRep;

    private LocationType(String stringRep) {
        this.stringRep = stringRep;
    }

    public String getStringRep() {
        return this.stringRep;
    }
}
