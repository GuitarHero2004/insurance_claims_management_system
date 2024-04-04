package com.guitarhero2004.icms.lib.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.lib.Utils;

public class MenuList {
    List<MenuItem> items;

    final protected Terminal term;

    public MenuList(Terminal term) {
        items = new ArrayList<>();
        this.term = term;
    }

    public void addItem(MenuItem event) {
        items.add(event);
    }

    protected void displayKeybinds() {
        System.out.println(String.format("%s | %s %n", "<1-9>: select option", "Exit: E"));
    }

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

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public Terminal getScreen() {
        return term;
    }
}
