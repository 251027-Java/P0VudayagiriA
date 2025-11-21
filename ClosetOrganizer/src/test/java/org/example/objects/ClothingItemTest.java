package org.example.objects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClothingItemTest {

//Test 8: Creating a clothing item should set fields correctly
  @Test
    public void createClothingItemTest() {
        ClothingItem item = new ClothingItem(1, "Blue Jeans");
        assertEquals(1, item.getId());
        assertEquals("Blue Jeans", item.getName());
    }

//Test 9: The toString should contain the name of the clothing item
 @Test
    public void testToString() {
        ClothingItem item = new ClothingItem(5, "Brown Jacket");
        String output = item.toString();
        assertTrue(output.contains("Brown Jacket"));
    }
}