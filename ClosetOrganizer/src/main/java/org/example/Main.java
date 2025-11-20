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
