package org.example.models;

public class Category {
    //Fields: int id, String name
private int id;
private String name;

    //Add constructor to initialize fields
public Category(int id, String name) {
    this.id = id;
    this.name = name;

}
    //Add getters for id and name
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //Add a toString() for printing category name
    @Override
    public String toString() {
        return "category{" + "id=" + id + ", name=" + name + '}';
    }
}
