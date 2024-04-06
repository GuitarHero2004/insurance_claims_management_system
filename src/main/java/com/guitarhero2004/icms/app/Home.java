package com.guitarhero2004.icms.app;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.lib.menu.MenuItem;
import com.guitarhero2004.icms.lib.menu.MenuList;

/**
 * Class for managing the home menu of the application.
 */
public class Home {

    private final LineReader lineReader;
    private final MenuList menu;

    /**
     * Constructor for Home.
     * Initializes the line reader, menu list and all the submenus.
     * @param term The terminal where the menu will be displayed.
     * @throws Exception If an error occurs while setting up the menus.
     */
    public Home(Terminal term) throws Exception {
        this.lineReader = LineReaderBuilder.builder().terminal(term).build();
        this.menu = new MenuList(term);

        // Initialize the submenu for Dependents
        new DependentMenu(term, menu);

        // Initialize the submenu for PolicyHolders
        new PolicyHolderMenu(term, menu);

        // Initialize the submenu for Cards
        new CardMenu(term, menu);

        // Initialize the submenu for Claims
        new ClaimMenu(term, menu);

        // Run the main menu
        menu.run();
    }

}