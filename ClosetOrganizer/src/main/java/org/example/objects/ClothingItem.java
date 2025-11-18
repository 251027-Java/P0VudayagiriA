package org.example.objects;

public class ClothingItem {

    private int id;
    private String name;

    public ClothingItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id; }

    public String getName() {
        return name; }

    @Override
    public String toString() {
        return "ClothingItem{id=" + id + ", name='" + name + "'}";
    }
}

