package edu.gatech.donationapp_77;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class LocationManager implements Serializable {

    private final Collection<Location> locations = new ArrayList<>();

    public void addLocation(Location location) {
        locations.add(location);
    }

    /*
    /**
     * this is package vis because only model should be asking for this data
     *
     * @return
     */
//    List<Student> getStudents() {
//        return students;
//    }
//
//    Student getStudentByName(String name) {
//        return studentMap.get(name);
//    }

}
