package org.example.Service;
import org.example.objects.wishlistItem;
import org.example.Repository.IRepository;

public class wishListService {
    //Field for IRepository repo
private IRepository repo;
    //Constructor receives repository
public wishListService(IRepository repo) {
    this.repo = repo;
}
    //Method - addWishlistItem(name, store, price, link): validate price >= 0, validate name not empty, call repo.createWishlistItem()

    //Method - viewWishlist(): call repo.getAllWishlistItems()

    //Method - deleteWishlistItem(id): call repo.deleteWishlistItem()
}
