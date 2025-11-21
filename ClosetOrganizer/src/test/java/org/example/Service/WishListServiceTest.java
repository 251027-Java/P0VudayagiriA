package org.example.Service;

import org.example.models.WishlistItem;
import org.example.Repository.IRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {

    @Mock
    IRepository mockRepo;

    @InjectMocks
    private WishListService service;

    //Test 5: Test if Adding item to wishlist works correctly
    @Test
    public void addWishlistItemTest() {
        //Create expected wishlist item
        WishlistItem item = new WishlistItem(1, "Beige Long Sleeve Shirt", "Target", 25.00, "https://www.target.com/p/women-s-long-sleeve-ruched-blouse-a-new-day-beige/-/A-94960322?preselect=94960370#lnk=sametab");
        
        //Mock the repository to return our item
        when(mockRepo.createWishlistItem(any(WishlistItem.class))).thenReturn(item);

        //Call the service method
        WishlistItem result = service.addWishlistItem("Beige Long Sleeve Shirt", "Target", 25.00, "https://www.target.com/p/women-s-long-sleeve-ruched-blouse-a-new-day-beige/-/A-94960322?preselect=94960370#lnk=sametab");

        //Check if it worked
        assertEquals("Beige Long Sleeve Shirt", result.getItemName()); //Check if the item name is correct, if it is not, the test will fails", result.getItemName());
        assertEquals(25.00, result.getPrice());
    }

    //Test 6: Test if the wishlist returns the correct number of items
    @Test
    public void testGetWishlist() {
        List<WishlistItem> fakeWishlist = new ArrayList<>();
        fakeWishlist.add(new WishlistItem(1, "Beige Long Sleeve Shirt", "Target", 25.00, "https://www.target.com/p/women-s-long-sleeve-ruched-blouse-a-new-day-beige/-/A-94960322?preselect=94960370#lnk=sametab"));
        fakeWishlist.add(new WishlistItem(2, "Gray Mock Neck Sweater", "Target", 35.00, "https://www.target.com/p/women-s-mock-neck-cable-knit-sweater-joylab/-/A-94747513?preselect=94748067#lnk=sametab"));
        
        when(mockRepo.getAllWishlistItems()).thenReturn(fakeWishlist);

        List<WishlistItem> result = service.getWishlist();

        assertEquals(2, result.size());
    }

    //Test 7: Test if the wishlist deletes an item
    @Test
    public void deleteWishlistItemShouldReturnTrue() {
        when(mockRepo.deleteWishlistItem(1)).thenReturn(true);

        boolean deleted = service.deleteWishlistItem(1);

        assertTrue(deleted);
    }
}