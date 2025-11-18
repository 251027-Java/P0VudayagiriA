package org.example.Repository;

import org.example.objects.clothingItem;
import org.example.objects.category;
import org.example.objects.wishlistItem;

import java.util.List;

public interface IRepository {
    //For Clothing Items:
    //Method for creating a clothing item
    clothingItem createclothingItem(clothingItem item);
    //Method for retrieving a clothing item by id
    clothingItem getClothingItem(int id);
    //Method for retrieving all clothing items
    List<clothingItem> getallclothingItems();
    //Method for deleting a clothing item
    boolean deleteclothingItem(int id);


    //For Categories:
    //Method for creating a category
    category createcategory(category category);
    //Method for retrieving a category by id
    category getcategory(int id);
    //Method for retrieving all categories
    List<category> getallcategories();
    List<category> getcategoriesforClothing(int clothingId);
    //Method for assigning a category to a clothing item
    boolean assigncategorytoClothing(int clothingId, int categoryId);
    //Method for removing a category from a clothing item
    boolean removecategoryfromClothing(int clothingId, int categoryId);

    //For the Wishlist:
    //Method for creating a wishlist item
    wishlistItem createwishlistItem(wishlistItem item);
    //Method for retrieving a wishlist item by id
    wishlistItem getwishlistItem(int id);
    //Method for retrieving all wishlist items
    List<wishlistItem> getallwishlistItems();
    //Method for deleting a wishlist item
    boolean deletewishlistItem(int id);
}
