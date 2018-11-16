package edu.gatech.donationapp_77;


import android.util.Log;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
class CSVParser {

    private final String csv;
    private boolean error;

    public CSVParser(String csvRep) {
        if (csvRep == null) {
            throw new IllegalArgumentException("Can't parse null string");
        } else if (!csvRep.contains(",")) {
            throw new IllegalArgumentException("It appears this is not a csv");
        }

        this.csv = csvRep;
    }

    public void createLocations() {
        String[] lines = csv.split("\n");
        for (int i = 1; i < lines.length; i++) {
            try {
                String[] elements = lines[i].split(",");

                // default location type, to be overwritten later if needed
                LocationType tempLocType = LocationType.STORE;


                if ("Drop Off".equals(elements[8])) {
                    tempLocType = LocationType.DROP_OFF;
                } else if ("Warehouse".equals(elements[8])) {
                    tempLocType = LocationType.WAREHOUSE;
                }

                Location tempLoc = new Location(tempLocType, elements[1], elements[2], elements[3],
                        elements[4], elements[9]);

                Location.addToLocationList(tempLoc);
            } catch (RuntimeException e) {
                error = true;
                Log.e("CSV","Error in line " + i);
            }
        }
    }

    public boolean getError() {
        return error;
    }

}
