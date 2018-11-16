package edu.gatech.donationapp_77;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests if two items are equal
 */
public class ItemEqualsTest {
    private Item Item1;
    private Item Item2;
    private Item Item3;
    private Item Item4;

    /**
     * Sets up POJOs, etc
     */
    @Before
    public void setUp() {
        // Item1 and Item2 have identical fields
        // loc3 and loc 4 have different addresses from loc 1
        Item1 = new Item("Shirt", 5.00, 1, null, null,
                Category.CLOTHES);
        Item2 = new Item("Shirt", 5.00, 1, null, null,
                Category.CLOTHES);
        Item3 = new Item("Pants", 6.00, 1, null, null,
                Category.CLOTHES);
        Item4 = new Item("Hat", 3.00, 1, null, null,
                Category.CLOTHES);
    }

    /**
     * Checks if items don't equal null
     */
    @Test
    public void checkNull() {
        assertEquals(Item1.equals(null), false);
        assertEquals(Item2.equals(null), false);
    }

    /**
     * Check if they don't equal a different type
     */
    @Test
    public void checkDifferentType() {
        assertEquals(Item1.equals("Shirt"), false);
        assertEquals(Item3.equals("Hat"), false);
    }

    /**
     * Checks if they equal themselves
     */
    @Test
    public void checkSameReference() {
        assertEquals(Item1.equals(Item1), true);
        assertEquals(Item4.equals(Item4), true);
    }

    /**
     * Checks if they equal a different instance, same data object
     */
    @Test
    public void checkSameLocationDiffRef() {
        assertEquals(Item1.equals(Item2), true);
    }

    /**
     * Checks if they don't equal a different object
     */
    @Test
    public void checkDiffLocations() {
        assertEquals(Item1.equals(Item3), false);
    }
}
