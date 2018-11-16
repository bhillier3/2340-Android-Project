package edu.gatech.donationapp_77;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * JUnit test for the CSVParser
 */
public class CSVParserTest {

    /**
     * Testing throwing an IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorException1() {
        CSVParser test1 = new CSVParser(null);
        System.out.println(test1.getError());

    }

    /**
     * Testing throwing a different IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorException2() {
        CSVParser test1 = new CSVParser("this string does not contain a comma");
        System.out.println(test1.getError());
    }

    /**
     * Testing making locations
     */
    @Test
    public void createsLocations() {
        Collection<Location> comparer = new ArrayList<>();
        comparer.add(new Location(LocationType.DROP_OFF, "Test Name", "100",
                "100", "111 Test Rd", "111"));

        comparer.add(new Location(LocationType.STORE, "Test Two", "105",
                "100", "111 Testing St", "555"));
        comparer.add(new Location(LocationType.WAREHOUSE, "Test Warehouse", "10000",
                "12000", "No address this time...", "100"));

        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone,"
                + "Website\n" +
                "1,Test Name,100,100,111 Test Rd,Sydney,AU,11111,Drop Off,111,google.com\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk\n" +
                "3,Test Warehouse,10000,12000,No address this time...,Atlanta,GA,30332,Warehouse," +
                "100,ha";

        CSVParser testParser = new CSVParser(testString);
        testParser.createLocations();

        assertEquals(comparer, Location.getLocationList());

    }

    /**
     * Testing not creating locations
     */
    @Test
    public void doesntCreateLocations() {
        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone,"+
                "Website\n" +
                "1,Test Name,100,100,111 Test Rd,Sydney,AU,11111,Drop Off,111,google.com\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk";

        CSVParser betterNotCreate = new CSVParser(testString);

        assertEquals(Location.getLocationList(), new ArrayList<Location>());

        System.out.println(betterNotCreate.getError());
    }

    /**
     * Testing setting the error bool
     */
    @Test
    public void testErrorTrue() {
        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone,"+
                "Website\n" +
                "1,Test Name,100,100\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk";

        CSVParser testError = new CSVParser(testString);

        testError.createLocations();

        assertEquals(testError.getError(), true);
    }

    /**
     * Testing the error bool
     */
    @Test
    public void testErrorFalse() {
        String testString = "Key,Name,Latitude,Longitude,Street Address,City,State,Zip,Type,Phone," +
                "Website\n" +
                "1,Test Name,100,100,111 Test Rd,Sydney,AU,11111,Drop Off,111,google.com\n" +
                "2,Test Two,105,100,111 Testing St,Atlanta,GA,30332,Store,555,nope.co.uk";

        CSVParser testError = new CSVParser(testString);

        testError.createLocations();

        assertEquals(testError.getError(), false);

    }

}
