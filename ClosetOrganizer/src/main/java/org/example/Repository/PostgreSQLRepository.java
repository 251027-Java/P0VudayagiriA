package org.example.Repository;

import org.example.objects.WishlistItem;
import org.example.objects.Category;
import org.example.objects.ClothingItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLRepository implements IRepository{
    //Declare DB URL, username, password
    private static final String Postgre_URL = "jdbc:postgresql://localhost:5432/expensesdb";
    private static final String Postgre_User = "postgres";
    private static final String Postgre_PW = "mysecretpassword";
    //Declare a Connection field
    private Connection connection;

    //Constructor should:
    //Connect to PostgreSQL database
    //Create schema if not exists
    //Create tables for: clothing_items, categories, clothing_category (many-to-many join), wishlist_items

    //Clothing Methods: Implement createClothingItem(), getClothingItem(), getAllClothingItems(), deleteClothingItem()

    // Category Methods: Implement createCategory(), getCategory(), getAllCategories(), assignCategoryToClothing(), removeCategoryFromClothing()

    // Wishlist Methods: Implement createWishlistItem(), getWishlistItem(), getAllWishlistItems(), deleteWishlistItem()

    //Add helper methods to build model objects from ResultSet
}
