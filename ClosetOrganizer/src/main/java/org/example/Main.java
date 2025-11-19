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
        ClosetService closetService = new ClosetService(repo);
        WishListService wishListService = new WishListService(repo);

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
                // Call appropriate service method based on menu choice
                case 1:
                    System.out.println("Enter Clothing Name: ");
                    String clothingName = scanner.nextLine();
                    ClothingItem newClothingItem = closetService.addClothing(clothingName);
                    System.out.println("Created: "  + newClothingItem);
                    break;
                //          2. View closet
                // Call appropriate service method based on menu choice
                case 2:
                    List<ClothingItem> clothingList = closetService.getAllClothes();

                    if (clothingList.isEmpty()) {
                        System.out.println("No Clothes Found.");
                    } else {
                        for (ClothingItem clothing :  clothingList) {
                            System.out.println(clothing);
                            List<Category> categories = closetService.getCategoriesForItem(clothing.getId());
                            System.out.println("Categories: " + categories);
                        }
                    }
                    break;
                //          3. Add category
                // Call appropriate service method based on menu choice
                case 3:
                    System.out.println("Enter the Category's Name:");
                    String categoryName = scanner.nextLine();
                    Category newCategory = closetService.addCategory(categoryName);
                    System.out.println("Created: "  + newCategory);
                    break;
                //          4. View categories
                // Call appropriate service method based on menu choice
                case 4:
                    System.out.println(closetService.getAllCategories());
                    break;
                //          5. Assign category to clothing item
                // Call appropriate service method based on menu choice
                case 5:
                    System.out.println("Enter Clothing ID: ");
                    int clothingId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Category ID: ");
                    int categoryId = Integer.parseInt(scanner.nextLine());
                    closetService.assignCategory(clothingId, categoryId);
                    break;
                //          6. Remove category from clothing item
                // Call appropriate service method based on menu choice
                case 6:
                    System.out.println("Enter Clothing ID: ");
                    int clothingIdRemove = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Category ID: ");
                    int categoryIdRemove = Integer.parseInt(scanner.nextLine());
                    closetService.removeCategory(clothingIdRemove, categoryIdRemove);
                    break;
                //          7. Add wishlist item
                // Call appropriate service method based on menu choice
                case 7:
                    System.out.println("Enter Item Name: ");
                    String itemName = scanner.nextLine();

                    System.out.println("Enter Store Name: ");
                    String storeName = scanner.nextLine();

                    System.out.println("Enter Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Enter Link to Item: ");
                    String link = scanner.nextLine();

                    WishlistItem wishlistItem = wishListService.addWishlistItem(itemName, storeName, price, link);
                    System.out.println("Added to Your Wishlist: "  + wishlistItem);
                    break;
                //          8. View wishlist
                // Call appropriate service method based on menu choice
                case 8:
                    System.out.println(wishListService.getWishlist());
                    break;
                //          9. Delete clothing item
                // Call appropriate service method based on menu choice
                case 9:
                    System.out.println("Enter ID of the Item You Wish to Delete: ");
                    int deleteClothingId = Integer.parseInt(scanner.nextLine());
                    closetService.deleteClothing(deleteClothingId);
                    break;
                //         10. Delete wishlist item
                // Call appropriate service method based on menu choice
                case 10:
                    System.out.println("Enter ID of the Wishlist Item You Wish to Delete: ");
                    int deleteWishlistItemId = Integer.parseInt(scanner.nextLine());
                    wishListService.deleteWishlistItem(deleteWishlistItemId);
                    break;
                //          0. Exit program
                // Break loop when user chooses Exit
                case 0:
                    System.out.println("Exiting...");
                    System.out.println("Goodbye, and See You Again!");
                    return;
                // Handle invalid option
                default:
                    System.out.println("Invalid Option");

            }

        }
    }
}