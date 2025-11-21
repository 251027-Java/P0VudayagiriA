package org.example;

import org.example.Service.WishListService;
import org.example.Service.ClosetService;
import org.example.models.Category;
import org.example.models.ClothingItem;
import org.example.models.WishlistItem;

import java.util.List;
import java.util.Scanner;

public class MenuHandler {

//Fields: ClosetService, WishlistService, Scanner for user input
    private ClosetService closetService;
    private WishListService wishListService;
    private Scanner scanner;

//Constructor receives ClosetService and WishlistService, initializes Scanner
    public MenuHandler(ClosetService closetService, WishListService wishListService) {
        this.closetService = closetService;
        this.wishListService = wishListService;
        this.scanner = new Scanner(System.in);
    }

//Method start(): Runs the main application loop, displays menu, handles user choices
    public void start() {
    //Loop until user chooses to exit
        while (true) {
            //Display menu options
            System.out.println("============================================");
            System.out.println("      CLOSET ORGANIZER + WISHLIST APP");
            System.out.println("=============================================");
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
            System.out.print("\nEnter your choice: ");
            //Get the user's choice
            int choice = Integer.parseInt(scanner.nextLine());
            //Option 1: Add a new clothing item
            if (choice == 1) {
                System.out.print("Enter Clothing Name: ");
                String clothingName = scanner.nextLine();
                ClothingItem newClothingItem = closetService.addClothing(clothingName);
                System.out.println("Added a New Clothing Item: " + newClothingItem);

            //Option 2: View all clothing items in the closet along with their categories
            } else if (choice == 2) {
                List<ClothingItem> clothingList = closetService.getAllClothes();
                if (clothingList.isEmpty()) {
                    System.out.println("Your closet is empty.");
                } else {
                    for (ClothingItem clothing : clothingList) {
                        System.out.println(clothing);
                        List<Category> categories = closetService.getCategoriesForItem(clothing.getId());
                        System.out.print("Categories: " + categories);
                }
             }

            //Option 3: Add a new category
            } else if (choice == 3) {
                System.out.print("Enter the Category's Name: ");
                String categoryName = scanner.nextLine();
                Category newCategory = closetService.addCategory(categoryName);
                System.out.println("Added a New Category: " + newCategory);

            //Option 4: View all categories
            } else if (choice == 4) {
                System.out.println(closetService.getAllCategories());

            //Option 5: Assign a category to a clothing item
            } else if (choice == 5) {
                System.out.print("Enter Clothing ID: ");
                int clothingId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Category ID: ");
                int categoryId = Integer.parseInt(scanner.nextLine());
                closetService.assignCategory(clothingId, categoryId);
                System.out.println("Category Has Been Assigned");

            //Option 6: Remove a category from a clothing item
            } else if (choice == 6) {
                System.out.print("Enter Clothing ID: ");
                int clothingId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Category ID: ");
                int categoryId = Integer.parseInt(scanner.nextLine());
                closetService.removeCategory(clothingId, categoryId);
                System.out.println("Category Has Been Removed");

            //Option 7: Add a new wishlist item
            } else if (choice == 7) {
                System.out.print("Enter Item Name: ");
                String itemName = scanner.nextLine();
                System.out.print("Enter Store Name: ");
                String storeName = scanner.nextLine();
                System.out.print("Enter Price: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter Link to Item: ");
                String link = scanner.nextLine();
                WishlistItem newWishlistItem = wishListService.addWishlistItem(itemName, storeName, price, link);
                System.out.println("Added a New Wishlist Item: " + newWishlistItem);
            //Option 8: View all wishlist items
            } else if (choice == 8) {
                System.out.println(wishListService.getWishlist());

            //Option 9: Delete a clothing item
            } else if (choice == 9) {
                System.out.print("Enter the ID of the Item You Wish to Delete: ");
                int clothingId = Integer.parseInt(scanner.nextLine());
               closetService.deleteClothing(clothingId);
                System.out.println("Clothing Item Has Been Deleted");

            //Option 10: Delete a wishlist item
            } else if (choice == 10) {
                System.out.print("Enter the ID of the Item You Wish to Delete: ");
                int wishlistId = Integer.parseInt(scanner.nextLine());
                wishListService.deleteWishlistItem(wishlistId);
                System.out.println("Wishlist Item Has Been Deleted");
            //Option 0: Exit
            } else if (choice == 0) {
                System.out.println("Exiting...");
                System.out.println("Goodbye, and See you Again!");
                break;
            
            //Handle invalid input
            } else {
                System.out.println("Invalid Option. Please try again.");
            }
        }
        
    //Close the scanner
    scanner.close();

    }
}