package com.guitarhero2004.icms.lib.menu;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

/**
 * Class representing a menu item.
 * A menu item can either perform an action or open a submenu.
 */
public class MenuItem {
    /**
     * The display name of the menu item.
     */
    private final String displayName;

    /**
     * The action to perform when the menu item is selected.
     */
    private final Runnable action;

    /**
     * The submenu to open when the menu item is selected.
     */
    private MenuList subMenu;

    /**
     * Constructor for a menu item that performs an action.
     * @param displayName The display name of the menu item.
     * @param action The action to perform when the menu item is selected.
     */
    public MenuItem(String displayName, Runnable action) {
        this.displayName = displayName;
        this.action = action;
    }

    /**
     * Constructor for a menu item that opens a submenu.
     * @param displayName The display name of the menu item.
     * @param subMenu The submenu to open when the menu item is selected.
     */
    public MenuItem(String displayName, MenuList subMenu) {
        this.displayName = displayName;
        this.action = () -> {
            try {subMenu.run();} catch (Exception e) {}
        };
        this.subMenu = subMenu;
    }

    /**
     * Runs the action or submenu of the menu item.
     * @return True if the submenu was run, false otherwise.
     * @throws Exception If an exception occurs while running the submenu.
     */
    public boolean run() throws Exception{
        if (subMenu != null) return subMenu.run();
        action.run();
        return true;
    }

    /**
     * Displays the display name of the menu item.
     */
    public void display() {
        System.out.println(displayName);
    }

    /**
     * Returns the display name of the menu item.
     * If the menu item opens a submenu, the display name is followed by " >".
     * @return The display name of the menu item.
     */
    public String getDisplayName() {
        if (subMenu != null) {
            return displayName + " >";
        }
        return displayName;
    }

    /**
     * Returns the submenu of the menu item.
     * @return The submenu of the menu item.
     */
    public MenuList getSubMenu() {
        return subMenu;
    }
}