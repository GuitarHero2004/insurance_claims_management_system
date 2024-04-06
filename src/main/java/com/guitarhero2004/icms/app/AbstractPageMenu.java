package com.guitarhero2004.icms.app;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.io.IOException;
import java.util.Collection;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.database.AbstractDB;
import com.guitarhero2004.icms.database.Storeable;
import com.guitarhero2004.icms.lib.Utils;
import com.guitarhero2004.icms.lib.Utils.Console;
import com.guitarhero2004.icms.lib.menu.MenuItem;
import com.guitarhero2004.icms.lib.menu.MenuList;
import com.guitarhero2004.icms.lib.menu.SubMenu;

/**
 * Abstract class for creating a page menu.
 * @param <T> The type of objects that this menu will handle. Must implement Storeable.
 */
public abstract class AbstractPageMenu<T extends Storeable> {
    protected final String name;
    private final Terminal term;
    protected final LineReader lineReader;
    protected final SubMenu objMenu;

    /**
     * Constructor for AbstractPageMenu.
     * @param term The terminal where the menu will be displayed.
     * @param name The name of the menu.
     * @param menu The menu list where the menu items will be added.
     * @param db The database where the objects will be stored.
     */
    public AbstractPageMenu(Terminal term, String name, MenuList menu, AbstractDB<T> db) {
        this.term = term;
        this.name = name;
        this.lineReader = LineReaderBuilder.builder().terminal(term).build();
        this.objMenu = new SubMenu(term);
        setupObjectMenu(menu, db);
    }

    /**
     * Set up the object menu.
     * @param menu The menu list where the menu items will be added.
     * @param db The database where the objects will be stored.
     */
    protected void setupObjectMenu(MenuList menu, AbstractDB<T> db) {
        MenuItem objMenuItem = new MenuItem(name, objMenu);

        MenuItem viewObj = new MenuItem("View " + name, () -> {
            Console.clearScreen();
            displayData(db.getAll());
            System.out.println("\nPress any key to continue...");
            try {
                Console.getch(term);
            } catch (IOException e) {
            }
        });
        MenuItem addObjItem = new MenuItem("Add " + name, () -> {
            addObj(db);
        });
        MenuItem removeObjItem = new MenuItem("Remove " + name, () -> {
            delObj(db);
        });

        objMenu.addItem(viewObj);
        objMenu.addItem(addObjItem);
        objMenu.addItem(removeObjItem);

        menu.addItem(objMenuItem);
    }

    /**
     * Abstract method for adding an object to the database.
     * @param db The database where the object will be added.
     */
    protected abstract void addObj(AbstractDB<T> db);

    /**
     * Method for removing an object from the database.
     * @param db The database where the object will be removed.
     */
    protected void delObj(AbstractDB<T> db) {
        Console.clearScreen();

        System.out.println("Remove " + name + Utils.getDivider(20));

        Collection<T> objCollection = db.getAll();

        displayData(objCollection);

        int idx = 0;
        while (true) {
            try {
                String line = lineReader.readLine("\nEnter index to remove (c to cancel): ");

                if (line.equals("c")) {
                    break;
                }

                idx = Integer.parseInt(line);

                T dep = objCollection.stream().skip(idx - 1).findFirst().get();
                db.delete(dep);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                break;
            } catch (Exception e) {
                System.out.println("Invalid index");
            }
        }

    }

    /**
     * Method for displaying data from a collection.
     * @param dataList The collection of data to be displayed.
     */
    protected void displayData(Collection<?> dataList) {
        if (dataList.isEmpty()) {
            System.out.println("No data available");
            return;
        }

        int idx = 1;
        for (Object s : dataList) {
            System.out.print(idx + ") ");
            System.out.println(s.toString());

            idx++;
        }

    }
}