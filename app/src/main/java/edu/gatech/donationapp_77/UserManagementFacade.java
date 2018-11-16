package edu.gatech.donationapp_77;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class UserManagementFacade {
    public static final String DEFAULT_JSON_FILE_NAME = "users.json";

    /**
     * the facade maintains references to any required model classes
     */
    private List lm;

    /**
     * Singleton pattern
     */
    private static final UserManagementFacade instance = new UserManagementFacade();

    /**
     * private constructor for facade pattern
     */
    private UserManagementFacade() {
        lm = User.getInstance();
    }

    /**
     * Singleton pattern accessor for instance
     *
     *
     * @return the one and only one instance of this facade
     */
    public static UserManagementFacade getInstance() { return instance; }

//    public List<Location> getLocationsAsList() {
//        return lm.getLocationList();
//    }

//    public Location getLocationByName(final String name) {
//        return lm.getLocationByName(name);
//    }

//    public void addNewLocation(Location location) {
//        lm.addToLocationList(location);
//    }

//    void addLocation(Location location) {
//        lm.addLocation(location);
//    }

//    void removeLocation(Location location) {
//        lm.removeLocation(location);
//    }

    public void loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automatically
            //noinspection EmptyClass
            Type listType = new TypeToken<ArrayList<User>>(){}.getType();
            Gson gson = new Gson();

            lm = gson.fromJson(inString, listType);
            User.updateFromJson((ArrayList) lm);

            input.close();
        } catch (IOException e) {
            Log.e("LocationManageFacad", "Failed to open/read the buffered reader for json");
//            return false;
        }
//        return true;
    }

    public void saveJson(File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            /*
                We are using the Google Gson library to make things easy.  You will need to add the
                following line to your gradle file so the proper dependencies are set up:
                compile 'com.google.code.gson:gson:2.3'

                Gson, like object serialization will take a single object and save all the objects
                it refers to.  You can save everything by one reference, as long as it is the
                top-level reference.
             */
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(User.getInstance());
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("LocationManagementFacad", "Failed to open json file for output");
//            return false;
        }
//        return true;
    }
}
