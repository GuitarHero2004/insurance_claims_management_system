package com.guitarhero2004.icms.lib.menu;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.lib.Utils;

/**
 * Class representing a list of menu items.
 * This class is used to display a list of menu items and handle user inputs
 */
public class MenuList {
    /**
     * The list of menu items.
     */
    List<MenuItem> items;
    /**
     * The terminal object used to display the menu.
     */
    final protected Terminal term;

    /**
     * Constructor for a MenuList object.
     * @param term The terminal object used to display the menu.
     */
    public MenuList(Terminal term) {
        items = new ArrayList<>();
        this.term = term;
    }

    /**
     * Adds a menu item to the list of menu items.
     * @param event The menu item to add.
     */
    public void addItem(MenuItem event) {
        items.add(event);
    }

    /**
     * Displays the keybinds for the menu.
     */
    protected void displayKeybinds() {
        System.out.println(String.format("%s | %s %n", "<1-9>: select option", "Exit: E"));
    }

    /**
     * Displays the menu.items
     * @throws IOException If an I/O error occurs.
     */
    public void display() throws IOException {
        // Clear screen and set cursor to top left
        Utils.Console.clearScreen();

        displayKeybinds();
        int index = 1;
        String indentation = "  ";
        for (MenuItem e : items) {
            System.out.println(String.format("%2s[%d] %s", indentation, index, e.getDisplayName()));
            index++;
        }

    }

    /**
     * Runs the menu.
     * @return True if the menu should be displayed again, false otherwise.
     * @throws Exception If an exception occurs while running the menu items.
     */
    public boolean run() throws Exception {

        while (true) {
            display();
            Character choice = Utils.Console.getch(term);

            switch (choice) {
                // Exit
                case 'E':
                    System.exit(0);
                    break;
                // Back
                case 'b':
                    return true;
                //
                case null:
                    break;
                default:
                    int index = Character.getNumericValue(choice);
                    if (index >= 1 && index <= items.size()) {
                        if (!items.get(index - 1).run())
                            return false;
                    }
            }

        }

        // while (true) {
        // display();
        // System.out.print("Enter choice: ");
        // choice = InputValidator.validateInt(i -> i >= -1 && i <= items.size() + 1);
        // if (choice == -1) {
        // if (InputValidator.validateBoolean("Are you sure you want to exit?")) {
        // input.close();
        // System.exit(0);
        // }
        // Divider.printDivider();
        // continue;
        // } else if (choice == items.size() + 1) {
        // // Return false to break the menu loop
        // return false;
        // } else if (choice == 0) {
        // // Return true so the menu can be displayed again
        // return true;
        // }
        // if (!items.get(choice - 1).run()) return false;
        // Divider.printDivider();
        // }
        // return true;
    }

    /**
     * Returns the list of menu items.
     * @return The list of menu items.
     */
    public List<MenuItem> getItems() {
        return items;
    }

    /**
     * Sets the list of menu items.
     * @param items The new list of menu items.
     */
    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    /**
     * Returns the terminal object used to display the menu.
     * @return The terminal object used to display the menu.
     */
    public Terminal getScreen() {
        return term;
    }
}
