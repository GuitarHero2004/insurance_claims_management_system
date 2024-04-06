package com.guitarhero2004.icms.lib.menu;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import org.jline.terminal.Terminal;

/**
 * Class representing a submenu.
 * A submenu is a type of MenuList that has additional keybinds.
 */
public class SubMenu extends MenuList {
    /**
     * Constructor for SubMenu.
     * @param term The terminal to display the menu on.
     */
    public SubMenu(Terminal term) {
        super(term);
    }

    /**
     * Displays the keybinds for the submenu.
     * In addition to the keybinds of a MenuList, a submenu also has a keybind for going back.
     */
    @Override
    protected void displayKeybinds() {
        System.out.println(String.format(
                "%s | %s | %s%n",
                "<1-9>: select option",
                "Exit: e",
                "Back: b"));
    }

}