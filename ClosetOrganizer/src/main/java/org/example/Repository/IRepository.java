package org.example.Repository;

import java.util.List;

import org.example.objects.Category;
import org.example.objects.ClothingItem;
import org.example.objects.WishlistItem;

public interface IRepository {
    //For Clothing Items:
    //Method for creating a clothing item
    ClothingItem createClothingItem(ClothingItem item);
    //Method for retrieving a clothing item by id
    ClothingItem getClothingItem(int id);
    //Method for retrieving all clothing items
    List<ClothingItem> getAllClothingItems();
    //Method for deleting a clothing item
    boolean deleteClothingItem(int id);


    //For Categories:
    //Method for creating a category
    Category createCategory(Category category);
    //Method for retrieving a category by id
    Category getCategory(int id);
    //Method for retrieving all categories
    List<Category> getAllCategories();
    List<Category> getCategoriesForClothing(int clothingId);
    //Method for assigning a category to a clothing item
    boolean assignCategoryToClothing(int clothingId, int categoryId);
    //Method for removing a category from a clothing item
    boolean removeCategoryFromClothing(int clothingId, int categoryId);

    //For the Wishlist:
    //Method for creating a wishlist item
    WishlistItem createWishlistItem(WishlistItem item);
    //Method for retrieving a wishlist item by id
    WishlistItem getWishlistItem(int id);
    //Method for retrieving all wishlist items
    List<WishlistItem> getAllWishlistItems();
    //Method for deleting a wishlist item
    boolean deleteWishlistItem(int id);
}
