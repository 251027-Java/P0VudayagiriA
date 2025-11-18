package org.example.objects;

public class clothingItem {
    //Fields: int id, String name
private int id;
private String name;

    //Constructor to set fields
public clothingItem(int id, String name) {
    this.id = id;
    this.name = name;
}
    //Getters for id and name
public int getId() {
    return id;
}
    //Add a toString() method to display clothing item name and id
    @Override
    public String toString() {
        return "clothingItem{" + "id=" + id + ", name=" + name + '}';
    }
}
