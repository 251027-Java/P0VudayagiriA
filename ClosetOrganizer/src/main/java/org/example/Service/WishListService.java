package org.example.Service;
import org.example.Repository.IRepository;
import org.example.objects.WishlistItem;

import java.util.List;

public class WishListService {
    //Field for IRepository repo
private IRepository repo;
    //Constructor receives repository
public WishListService(IRepository repo) {
    this.repo = repo;
}
    //Method - addWishlistItem(name, store, price, link): validate price >= 0, validate name not empty, call repo.createWishlistItem()
public WishlistItem addWishlistItem(String name, String store, double price, String link) {
    return repo.createWishlistItem(new WishlistItem(0, name, store, price, link));
}
    //Method - viewWishlist(): call repo.getAllWishlistItems()
public List<WishlistItem> getWishlist() {
    return repo.getAllWishlistItems();
}
    //Method - deleteWishlistItem(id): call repo.deleteWishlistItem()
    public boolean deleteWishlistItem(int id) {
        return repo.deleteWishlistItem(id);
    }
}
