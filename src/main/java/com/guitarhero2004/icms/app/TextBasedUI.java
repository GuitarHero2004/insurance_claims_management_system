package com.guitarhero2004.icms.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextBasedUI {
    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("Press any key to start the program...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void displayMenu() {
        while (true) {
            try {
                System.out.println("Please select an option: ");
                System.out.println("1. Create a new customer");
                System.out.println("2. Create a new claim");
                System.out.println("3. Process a claim");
                System.out.println("-1. Exit");

                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Creating a new customer...");
                        break;
                    case 2:
                        System.out.println("Creating a new claim...");
                        break;
                    case 3:
                        System.out.println("Processing a claim...");
                        break;
                    case -1:
                        System.out.println("Are you sure you want to exit the program? (y/n)");
                        String exitOption = scanner.next();
                        if (exitOption.equals("y")) {
                            System.out.println("Goodbye! See you again!");
                            scanner.close();
                            System.exit(0);
                        } else {
                            displayMenu();
                        }
                        break;
                    default:
                        System.out.println("Invalid option, try again");
                        displayMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again");
                displayMenu();
            }
        }
    }
}
