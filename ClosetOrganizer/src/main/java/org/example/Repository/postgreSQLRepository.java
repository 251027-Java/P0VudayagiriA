package org.example.Repository;

public class postgreSQLRepository implements IRepository{
    //Declare DB URL, username, password
    //Declare a Connection field

    //Constructor should:
    //Connect to PostgreSQL database
    //Create schema if not exists
    //Create tables for: clothing_items, categories, clothing_category (many-to-many join), wishlist_items

    //Clothing Methods: Implement createClothingItem(), getClothingItem(), getAllClothingItems(), deleteClothingItem()

    // Category Methods: Implement createCategory(), getCategory(), getAllCategories(), assignCategoryToClothing(), removeCategoryFromClothing()

    // Wishlist Methods: Implement createWishlistItem(), getWishlistItem(), getAllWishlistItems(), deleteWishlistItem()

    //Add helper methods to build model objects from ResultSet
}
