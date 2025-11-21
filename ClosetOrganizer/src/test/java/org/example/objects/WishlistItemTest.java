package org.example.objects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WishlistItemTest {

    //Test 10: Create a fake wishlist item with all details
    @Test
    public void testWishlistItemCreation() {
        WishlistItem item = new WishlistItem(1, "Beige Long Sleeve Shirt", "Target", 25.00, "https://www.target.com/p/women-s-long-sleeve-ruched-blouse-a-new-day-beige/-/A-94960322?preselect=94960370#lnk=sametab");

        assertEquals(1, item.getId());
        assertEquals("", item.getItemName());
        assertEquals("Target", item.getStoreName());
        assertEquals(25.00, item.getPrice());
        assertEquals("https://www.target.com/p/women-s-long-sleeve-ruched-blouse-a-new-day-beige/-/A-94960322?preselect=94960370#lnk=sametab", item.getLink());
    }
}