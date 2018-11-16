package edu.gatech.donationapp_77;

/**
 * Enum for types of locations
 */
public enum LocationType {
    DROP_OFF("Drop Off"), WAREHOUSE("Warehouse"), STORE("Store");

    private final String stringRep;

    LocationType(String stringRep) {
        this.stringRep = stringRep;
    }

    /**
     * Returns the string rep of the enum
     * @return the string representation
     */
    public String getStringRep() {
        return this.stringRep;
    }
}
