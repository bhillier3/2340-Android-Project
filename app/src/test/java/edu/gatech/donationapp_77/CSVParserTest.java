package edu.gatech.donationapp_77;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class CSVParserTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorException1() {
        CSVParser test1 = new CSVParser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorException2() {
        CSVParser test1 = new CSVParser("this string does not contain a comma");
    }

    @Test
    public void createsLocations() {
        ArrayList<Location> comparer = new ArrayList<>();
        comparer.add(new Location(LocationType.DROP_OFF, "Test Name", "100",
                "100", "111 Test Rd", "111"));

        comparer.add(new Location(LocationType.STORE, "Test Two", "105",
                "100", "111 Testing St", "555"));
        comparer.add(new Location(LocationType.WAREHOUSE, "Test Warehouse", "10000",
                "12000", "No address this time...", "100"));

        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone,Website\n" +
                "1,Test Name,100,100,111 Test Rd,Sydney,AU,11111,Drop Off,111,google.com\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk\n" +
                "3,Test Warehouse,10000,12000,No address this time...,Atlanta,GA,30332,Warehouse,100,ha";

        CSVParser testParser = new CSVParser(testString);
        testParser.createLocations();

        assertEquals(comparer, Location.getLocationList());

    }

    @Test
    public void doesntCreateLocations() {
        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone,Website\n" +
                "1,Test Name,100,100,111 Test Rd,Sydney,AU,11111,Drop Off,111,google.com\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk";

        CSVParser betterNotCreate = new CSVParser(testString);

        assertEquals(Location.getLocationList(), new ArrayList<Location>());
    }

    @Test
    public void testErrorTrue() {
        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone,Website\n" +
                "1,Test Name,100,100\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk";

        CSVParser testError = new CSVParser(testString);

        testError.createLocations();

        assertEquals(testError.getError(), true);
    }

    @Test
    public void testErrorFalse() {
        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone,Website\n" +
                "1,Test Name,100,100,111 Test Rd,Sydney,AU,11111,Drop Off,111,google.com\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk";

        CSVParser testError = new CSVParser(testString);

        testError.createLocations();

        assertEquals(testError.getError(), false);

    }

}
