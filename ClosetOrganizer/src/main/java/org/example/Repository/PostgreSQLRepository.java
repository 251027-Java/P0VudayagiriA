package org.example.Repository;

import org.example.objects.WishlistItem;
import org.example.objects.Category;
import org.example.objects.ClothingItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLRepository implements IRepository{
    //Declare DB URL, username, password
    private static final String URL = "jdbc:postgresql://localhost:5432/expensesdb";
    private static final String User = "postgres";
    private static final String PW = "mysecretpassword";
    //Declare a Connection field
    private Connection connection;

    //Connect to PostgreSQL database
    public PostgreSQLRepository() {
        try {
            connection = DriverManager.getConnection(URL, User, PW);
            createTables();
        } catch (Exception e) {
            e.printStackTrace();
        }

    //Create schema if not exists
    //Create tables for: clothing_items, categories, clothing_category (many-to-many join), wishlist_items
private void createTables() {
            String sql = ""
                    + "CREATE TABLE IF NOT EXISTS clothing_items ("
                    + "id SERIAL PRIMARY KEY, "
                    + "name varchar(255) NOT NULL);"

                    +"CREATE TABLE IF NOT EXISTS Categories ("
                    + "id SERIAL PRIMARY KEY, "
                    + "name varchar(255) NOT NULL);"

                    +"CREATE TABLE IF NOT EXISTS clothing_category ("
                    +"clothing_id INT REFERENCES clothing_items(id) ON DELETE CASCADE,"
                    +"category_id INT REFERENCES category(id) ON DELETE CASCADE,"
                    +"PRIMARY KEY(clothing_id, category_id));"

                    +"CREATE TABLE IF NOT EXISTS wishlist_items ("
                    + "id SERIAL PRIMARY KEY, "
                    + "item_name varchar(255) NOT NULL,"
                    + "store_name varchar(255) NOT NULL,"
                    + "price DOUBLE NOT NULL,"
                    + "link TEXT NOT NULL);";
            try {
                Statement st = connection.createStatement();
                st.execute(sql);
            } catch (SQLException e) {
            e.printStackTrace();
            }
        }

        }
    //Clothing Methods: Implement createClothingItem(), getClothingItem(), getAllClothingItems(), deleteClothingItem()
@Override
    public ClothingItem createClothingItem(ClothingItem item) {

return null;
}

@Override
    ClothingItem getClothingItem(int id) {

return null;
}

@Override
    public List<ClothingItem> getAllClothingItems() {
        List<ClothingItem> list = new ArrayList<>();

return list;
}

@Override
    public boolean deleteClothingItem(int id) {
return false;
}
    // Category Methods: Implement createCategory(), getCategory(), getAllCategories(), assignCategoryToClothing(), removeCategoryFromClothing()
@Override
    public Category createCategory(Category category) {
return null;
}
@Override
    public Category getCategory(int id) {
return null;
}
@Override
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();

return list;
}
@Override
    public boolean assignCategoryToClothing(int clothingID, int categoryID) {
return false;
 }
@Override
    public boolean removeCategoryFromClothing(int clothingID, int categoryID) {
return false;
 }
@Override
    public List<Category> getCategoriesForClothing(int clothingID) {
List<Category> list = new ArrayList<>();
return list;
}

    // Wishlist Methods: Implement createWishlistItem(), getWishlistItem(), getAllWishlistItems(), deleteWishlistItem()
@Override
    public WishlistItem createWishlistItem(WishlistItem item) {
return null;
}
@Override
    public WishlistItem getWishlistItem(int id) {
return null;
}
@Override
    public List<WishlistItem> getAllWishlistItems() {
List<WishlistItem> list = new ArrayList<>();
return list;
}
@Override
    public boolean deleteWishlistItem(int id) {
return false;
}
}

