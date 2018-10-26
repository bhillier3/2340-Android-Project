package edu.gatech.donationapp_77;



public class CSVParser {

    String csv;

    public CSVParser(String csvRep) {
        this.csv = csvRep;
    }

    public void createLocations() {
        String[] lines = csv.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] elements = lines[i].split(",");
            // default locationtype, to be overwritten later if needed
            LocationType tempLocType = LocationType.STORE;


            if (elements[8].equals("Drop Off")) {
                tempLocType = LocationType.DROP_OFF;
            } else if (elements[8].equals("Warehouse")) {
                tempLocType = LocationType.WAREHOUSE;
            }

            Location tempLoc = new Location(tempLocType, elements[1], elements[2], elements[3],
                                                elements[4], elements[9]);

            Location.addToLocationList(tempLoc);
        }
    }

}
