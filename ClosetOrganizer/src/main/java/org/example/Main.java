package org.example;

import org.example.Repository.IRepository;
import org.example.Repository.PostgreSQLRepository;
import org.example.Service.ClosetService;
import org.example.Service.WishListService;


public class Main {
    public static void main(String[] args) {
        // Create a single PostgreSQLRepository instance
        IRepository repo = new PostgreSQLRepository();
        // Create ClosetService, WishlistService
        ClosetService closetService = new ClosetService(repo);
        WishListService wishListService = new WishListService(repo);

        //Create the Menu Handler, which passes both services
        //The Menu Handler manages user interactions and menu display
        MenuHandler menu = new MenuHandler(closetService, wishListService);




        //Starte the application loop
        //Displays the menu and handles user choices until they exit
        menu.start();

    }
}

/* 
package org.example;

import org.example.Repository.IRepository;
import org.example.Repository.PostgreSQLRepository;
import org.example.Service.ClosetService;
import org.example.Service.WishListService;


public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("PROGRAM STARTING NOW!");
        System.out.println("========================================");
        System.out.flush();
        
        // Create a single PostgreSQLRepository instance
        System.out.println("Step 1: Creating repository...");
        IRepository repo = new PostgreSQLRepository();
        
        // Create ClosetService, WishlistService
        System.out.println("Step 2: Creating services...");
        ClosetService closetService = new ClosetService(repo);
        WishListService wishListService = new WishListService(repo);

        //Create the Menu Handler, which passes both services
        //The Menu Handler manages user interactions and menu display
        System.out.println("Step 3: Creating menu handler...");
        MenuHandler menu = new MenuHandler(closetService, wishListService);

        //Start the application loop
        //Displays the menu and handles user choices until they exit
        System.out.println("Step 4: Starting menu...");
        System.out.flush();
        menu.start();
    }
}
*/