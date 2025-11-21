package org.example.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.models.Category;
import org.example.models.ClothingItem;
import org.example.models.WishlistItem;

public class PostgreSQLRepository implements IRepository {
    
    private String url = "jdbc:postgresql://localhost:5432/closetdb";
    private String user = "postgres";
    private String password = "mysecretpassword";
    private Connection connection;

    public PostgreSQLRepository() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");
            createTables();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    private void createTables() {
        try {
            Statement stmt = connection.createStatement();
            
            stmt.execute("CREATE TABLE IF NOT EXISTS clothing_items ("
                    + "id SERIAL PRIMARY KEY, "
                    + "name VARCHAR(255) NOT NULL)");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS categories ("
                    + "id SERIAL PRIMARY KEY, "
                    + "name VARCHAR(255) NOT NULL)");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS clothing_category ("
                    + "clothing_id INT REFERENCES clothing_items(id) ON DELETE CASCADE, "
                    + "category_id INT REFERENCES categories(id) ON DELETE CASCADE, "
                    + "PRIMARY KEY(clothing_id, category_id))");
            
            stmt.execute("CREATE TABLE IF NOT EXISTS wishlist_items ("
                    + "id SERIAL PRIMARY KEY, "
                    + "item_name VARCHAR(255) NOT NULL, "
                    + "store_name VARCHAR(255) NOT NULL, "
                    + "price DOUBLE PRECISION NOT NULL, "
                    + "link TEXT NOT NULL)");
            
            System.out.println("Tables created!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClothingItem createClothingItem(ClothingItem item) {
        try {
            String sql = "INSERT INTO clothing_items (name) VALUES (?) RETURNING id";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, item.getName());
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                return new ClothingItem(id, item.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClothingItem getClothingItem(int id) {
        try {
            String sql = "SELECT * FROM clothing_items WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new ClothingItem(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClothingItem> getAllClothingItems() {
        List<ClothingItem> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM clothing_items ORDER BY id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new ClothingItem(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteClothingItem(int id) {
        try {
            String sql = "DELETE FROM clothing_items WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category createCategory(Category category) {
        try {
            String sql = "INSERT INTO categories (name) VALUES (?) RETURNING id";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, category.getName());
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                return new Category(id, category.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getCategory(int id) {
        try {
            String sql = "SELECT * FROM categories WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Category(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM categories ORDER BY name";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Category> getCategoriesForClothing(int clothingId) {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "SELECT c.id, c.name FROM categories c "
                    + "JOIN clothing_category cc ON c.id = cc.category_id "
                    + "WHERE cc.clothing_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, clothingId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean assignCategoryToClothing(int clothingId, int categoryId) {
        try {
            String sql = "INSERT INTO clothing_category (clothing_id, category_id) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, clothingId);
            pstmt.setInt(2, categoryId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeCategoryFromClothing(int clothingId, int categoryId) {
        try {
            String sql = "DELETE FROM clothing_category WHERE clothing_id = ? AND category_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, clothingId);
            pstmt.setInt(2, categoryId);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public WishlistItem createWishlistItem(WishlistItem item) {
        try {
            String sql = "INSERT INTO wishlist_items (item_name, store_name, price, link) VALUES (?, ?, ?, ?) RETURNING id";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, item.getItemName());
            pstmt.setString(2, item.getStoreName());
            pstmt.setDouble(3, item.getPrice());
            pstmt.setString(4, item.getLink());
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                return new WishlistItem(id, item.getItemName(), item.getStoreName(), item.getPrice(), item.getLink());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WishlistItem getWishlistItem(int id) {
        try {
            String sql = "SELECT * FROM wishlist_items WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new WishlistItem(
                    rs.getInt("id"),
                    rs.getString("item_name"),
                    rs.getString("store_name"),
                    rs.getDouble("price"),
                    rs.getString("link")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WishlistItem> getAllWishlistItems() {
        List<WishlistItem> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM wishlist_items ORDER BY id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String itemName = rs.getString("item_name");
                String storeName = rs.getString("store_name");
                double price = rs.getDouble("price");
                String link = rs.getString("link");
                list.add(new WishlistItem(id, itemName, storeName, price, link));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteWishlistItem(int id) {
        try {
            String sql = "DELETE FROM wishlist_items WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
