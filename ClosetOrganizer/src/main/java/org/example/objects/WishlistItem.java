package org.example.objects;

public class WishlistItem {
    //Declare Fields: int id, String itemName, String storeName, double price, String link
private int id;
private String itemName;
private String storeName;
private double price;
private String link;

    //Constructor to set fields
    public WishlistItem(int id, String itemName, String storeName, double price, String link) {
        this.id = id;
        this.itemName = itemName;
        this.storeName = storeName;
        this.price = price;
        this.link = link;
    }

    //Add Getters for each field
    public int getId() {
        return id;
    }
    public String getItemName() {
        return itemName;
    }
    public String getStoreName() {
        return storeName;
    }
    public double getPrice() {
        return price;
    }
    public String getLink() {
        return link;
    }

    //Add a  toString() to display formatted wishlist item
    @Override
    public String toString() {
        return "WishListItem{id=" + id + ", itemName='" + itemName + "', storeName='" + storeName + "', price=" + price + ", link='" + link + "'}";
    }
}
