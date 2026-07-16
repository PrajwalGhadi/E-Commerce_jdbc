package com.ecommerce.ui;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private int loggedInCustomerId = -1; 

    public void start() {
        System.out.println("======================================");
        System.out.println("    WELCOME TO THE E-COMMERCE APP");
        System.out.println("======================================");
        
        // Instantiate the isolated Auth UI panel
        AuthConsoleUI authUI = new AuthConsoleUI(scanner);
        
        // Block application entry until auth returns a valid customer account ID number
        this.loggedInCustomerId = authUI.showAuthMenu();
        
        // Break operation cleanly if user picked "Exit Application" on auth screen
        if (this.loggedInCustomerId == -1) {
            scanner.close();
            return;
        }

        // Initialize store system layouts with the verified customer identity
        ProductConsoleUI productUI = new ProductConsoleUI(scanner, loggedInCustomerId);
        CartConsoleUI cartUI = new CartConsoleUI(scanner, loggedInCustomerId);
        OrderConsoleUI orderUI = new OrderConsoleUI(scanner, loggedInCustomerId);

        while (true) {
            System.out.println("\n======================================");
            System.out.println("  E-COMMERCE MAIN MENU (User ID: " + loggedInCustomerId + ")");
            System.out.println("======================================");
            System.out.println("1. Product Management");
            System.out.println("2. Cart System");
            System.out.println("3. Order & Inventory Management");
            System.out.println("4. Logout & Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    productUI.showMenu();
                    break;
                case 2:
                    cartUI.showMenu();
                    break;
                case 3:
                    orderUI.showMenu();
                    break;
                case 4:
                    System.out.println("Logged out successfully. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid entry. Enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Clear scanner buffer trailing newline
        return value;
    }
}