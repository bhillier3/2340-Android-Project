package edu.gatech.donationapp_77;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemEqualsTest {
    private Item Item1;
    private Item Item2;
    private Item Item3;
    private Item Item4;

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

    @Test
    public void checkNull() {
        assertEquals(Item1.equals(null), false);
        assertEquals(Item2.equals(null), false);
    }

    @Test
    public void checkDifferentType() {
        assertEquals(Item1.equals("Shirt"), false);
        assertEquals(Item3.equals("Hat"), false);
    }

    @Test
    public void checkSameReference() {
        assertEquals(Item1.equals(Item1), true);
        assertEquals(Item4.equals(Item4), true);
    }

    @Test
    public void checkSameLocationDiffRef() {
        assertEquals(Item1.equals(Item2), true);
    }

    @Test
    public void checkDiffLocations() {
        assertEquals(Item1.equals(Item3), false);
    }
}
