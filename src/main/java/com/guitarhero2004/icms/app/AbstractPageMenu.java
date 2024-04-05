package com.guitarhero2004.icms.app;

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

public abstract class AbstractPageMenu<T extends Storeable> {
    protected final String name;

    private final Terminal term;

    protected final LineReader lineReader;

    protected final SubMenu objMenu;

    public AbstractPageMenu(Terminal term, String name, MenuList menu, AbstractDB<T> db) {
        this.term = term;
        this.name = name;
        this.lineReader = LineReaderBuilder.builder().terminal(term).build();
        this.objMenu = new SubMenu(term);
        setupObjectMenu(menu, db);
    }

    /* **
     * Set up the object menu
     * @param menu
     * @param db
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

    protected abstract void addObj(AbstractDB<T> db);

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
