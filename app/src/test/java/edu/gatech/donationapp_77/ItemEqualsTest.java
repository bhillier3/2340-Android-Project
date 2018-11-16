package edu.gatech.donationapp_77;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertFalse(Item1.equals(null));
        assertFalse(Item2.equals(null));
    }

    /**
     * Check if they don't equal a different type
     */
    @Test
    public void checkDifferentType() {
        assertFalse("Shirt".equals(Item1));
        assertFalse("Hat".equals(Item3));
    }

    /**
     * Checks if they equal themselves
     */
    @Test
    public void checkSameReference() {
        assertTrue(Item1.equals(Item1));
        assertTrue(Item4.equals(Item4));
    }

    /**
     * Checks if they equal a different instance, same data object
     */
    @Test
    public void checkSameLocationDiffRef() {
        assertTrue(Item1.equals(Item2));
    }

    /**
     * Checks if they don't equal a different object
     */
    @Test
    public void checkDiffLocations() {
        assertFalse(Item1.equals(Item3));
    }
}
