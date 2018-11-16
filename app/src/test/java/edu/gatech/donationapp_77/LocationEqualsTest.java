package edu.gatech.donationapp_77;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the overridden equals() method for Location that is used to
 * prevent the duplication of Locations within our list of Locations
 */
public class LocationEqualsTest {
    private Location loc1;
    private Location loc2;
    private Location loc3;
    private Location loc4;

    /**
     * Sets up POJOs, etc
     */
    @Before
    public void setUp() {
        // loc1 and loc2 have identical fields
        // loc3 and loc 4 have different addresses from loc 1
        loc1 = new Location(LocationType.DROP_OFF, "Location1",
                "-30", "-50", "123 Fake St", "123-456-7890");
        loc2 = new Location(LocationType.DROP_OFF, "Location1",
                "-30", "-50", "123 Fake St", "123-456-7890");
        loc3 = new Location(LocationType.DROP_OFF, "Location3",
                "-30", "-50", "999 Fake St", "123-456-7890");
        loc4 = new Location(LocationType.DROP_OFF, "Location4",
                "-30", "-50", "888 Fake St", "123-456-7890");
    }

    /**
     * Checks if a location is null
     */
    @Test
    public void checkNull() {
        assertEquals(loc1.equals(null), false);
        assertEquals(loc2.equals(null), false);
    }

    /**
     * Checks if a location does not match
     */
    @Test
    public void checkDifferentType() {
        assertEquals("potato".equals(loc1.getAddress()), false);
        assertEquals("chicken".equals(loc3.getAddress()), false);
    }

    /**
     * Checks if a location equals itself
     */
    @Test
    public void checkSameReference() {
        assertEquals(loc1.equals(loc1), true);
        assertEquals(loc4.equals(loc4), true);
    }

    /**
     * Checks if two locations are equal
     */
    @Test
    public void checkSameLocationDiffRef() {
        assertEquals(loc1.equals(loc2), true);
    }

    /**
     * Checks if two locations differ
     */
    @Test
    public void checkDiffLocations() {
        assertEquals(loc1.equals(loc3), false);
    }
}