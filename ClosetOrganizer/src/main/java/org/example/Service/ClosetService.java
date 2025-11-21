package org.example.Service;
import org.example.models.Category;
import org.example.Repository.IRepository;
import org.example.models.ClothingItem;

import java.util.List;

public class ClosetService {
    //Declare IRepository field
private IRepository repo;
    //Constructor should receive repository
    public ClosetService(IRepository repo) {
        this.repo = repo;
    }

    //Clothing:
    //Method - addClothingItem(name): validate name is not empty, call repo.createClothingItem(), return created ClothingItem
public ClothingItem addClothing(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("The name of the piece of clothing cannot be blank.");
            return null;
        }
        return repo.createClothingItem(new ClothingItem(0, name));
}
    //Method - viewCloset(): call repo.getAllClothingItems()
public List<ClothingItem> getAllClothes(){
    return repo.getAllClothingItems();
}
    //Method - deleteClothingItem(id): check if item exists first, call repo.deleteClothingItem()
public boolean deleteClothing(int id) {
        return repo.deleteClothingItem(id);
}
    // Categories:
    //Method - addCategory(name): validate name, call repo.createCategory()
public Category addCategory(String name) {
        return repo.createCategory(new Category(0, name));
}
    //Method - viewAllCategories(): call repo.getAllCategories()
public List<Category> getAllCategories(){
        return repo.getAllCategories();
}
    //Method - List<Category> getCategoriesForItem(int clothingId): List what category each item belongs to.
public List<Category> getCategoriesForItem(int ClothingId) {
        return repo.getCategoriesForClothing(ClothingId);
}
    //Method - assignCategoryToClothing(clothingId, categoryId): verify both exist, call repo.assignCategoryToClothing()
public boolean assignCategory(int ClothingId, int CategoryId) {
    return repo.assignCategoryToClothing(ClothingId, CategoryId);
}
    //Method - removeCategoryFromClothing(clothingId, categoryId): call repo.removeCategoryFromClothing()
    public boolean removeCategory(int ClothingId, int CategoryId) {
        return repo.removeCategoryFromClothing(ClothingId, CategoryId);
    }
}
