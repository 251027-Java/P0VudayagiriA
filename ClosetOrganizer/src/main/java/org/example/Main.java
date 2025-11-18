package org.example;

import org.example.Repository.IRepository;
import org.example.Repository.PostgreSQLRepository;
import org.example.Service.closetService;
import org.example.Service.wishListService;
import org.example.objects.clothingItem;
import org.example.objects.category;
import org.example.objects.wishlistItem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a single PostgreSQLRepository instance
        IRepository repo = new PostgreSQLRepository();
        // Create ClosetService, WishlistService
        closetService cs = new closetService(repo);
        wishListService wls = new wishListService(repo);

        // Create Scanner for user input
        Scanner sc = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("      CLOSET ORGANIZER + WISHLIST APP");
        System.out.println("============================================");

        // Start an infinite loop to display menu options:
        //          1. Add clothing item
        //          2. View closet
        //          3. Add category
        //          4. View categories
        //          5. Assign category to clothing item
        //          6. Remove category from clothing item
        //          7. Add wishlist item
        //          8. View wishlist
        //          9. Delete clothing item
        //         10. Delete wishlist item
        //          0. Exit program
        // Handle invalid input with try/catch
        // Call appropriate service method based on menu choice
        // Break loop when user chooses Exit
    }
}