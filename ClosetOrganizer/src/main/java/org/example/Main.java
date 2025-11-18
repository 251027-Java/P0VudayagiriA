package org.example;

import org.example.Repository.IRepository;
import org.example.Repository.PostgreSQLRepository;
import org.example.Service.ClosetService;
import org.example.Service.WishListService;
import org.example.objects.ClothingItem;
import org.example.objects.WishlistItem;
import org.example.objects.Category;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a single PostgreSQLRepository instance
        IRepository repo = new PostgreSQLRepository();
        // Create ClosetService, WishlistService
        ClosetService cs = new ClosetService(repo);
        WishListService wls = new WishListService(repo);

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Start an infinite loop to display menu options:
        while (true) {
            System.out.println("============================================");
            System.out.println("      CLOSET ORGANIZER + WISHLIST APP");
            System.out.println("============================================");
            System.out.println("1. Add Clothing");
            System.out.println("2. View Closet");
            System.out.println("3. Add Category");
            System.out.println("4. View Categories");
            System.out.println("5. Assign Category");
            System.out.println("6. Remove Category");
            System.out.println("7. Add Wishlist Item");
            System.out.println("8. View Wishlist");
            System.out.println("9. Delete Clothing");
            System.out.println("10. Delete Wishlist Item");
            System.out.println("0. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                //          1. Add clothing item
                case 1:
                    System.out.println("Enter Clothing Name: ");
                    String clothingName = scanner.nextLine();
                    ClothingItem newClothingItem = ClosetService.addClothing(clothingName);
                    System.out.println("Created: "  + newClothingItem);
                    break;
                //          2. View closet
                case 2:
                    List<ClothingItem> clothingList = ClosetService.getAllClothes();

                    if (clothingList.isEmpty()) {
                        System.out.println("No Clothes Found.");
                    } else {
                        for (ClothingItem clothing :  clothingList) {
                            System.out.println(clothing);
                            List<Category> categories = ClosetService.getCategoriesForItem(clothing.getId());
                            System.out.println("Categories: " + categories);
                        }
                    }
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
    }
}