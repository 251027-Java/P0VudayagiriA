package org.example.Service;
import org.example.objects.category;
import org.example.objects.clothingItem;
import org.example.Repository.IRepository;

import java.util.List;

public class closetService {
    //Declare IRepository field
private IRepository repo;
    //Constructor should receive repository
    public closetService(IRepository repo) {
        this.repo = repo;
    }

    //Clothing:
    //Method - addClothingItem(name): validate name is not empty, call repo.createClothingItem(), return created ClothingItem

    //Method - viewCloset(): call repo.getAllClothingItems()

    //Method - deleteClothingItem(id): check if item exists first, call repo.deleteClothingItem()

    // Categories:
    //Method - addCategory(name): validate name, call repo.createCategory()

    //Method - viewAllCategories(): call repo.getAllCategories()

    //Method - assignCategoryToClothing(clothingId, categoryId): verify both exist, call repo.assignCategoryToClothing()
public List<category> getcategoriesforClothing(int clothingId) {
        return repo.getcategoriesforClothing(clothingId);
}
    //Method - removeCategoryFromClothing(clothingId, categoryId): call repo.removeCategoryFromClothing()
}
