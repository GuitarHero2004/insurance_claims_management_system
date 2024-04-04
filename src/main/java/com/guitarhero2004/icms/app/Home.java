package com.guitarhero2004.icms.app;

import java.io.IOException;
import java.util.Collection;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.customer.Dependent;
import com.guitarhero2004.icms.database.DependentDB;
import com.guitarhero2004.icms.database.Storeable;
import com.guitarhero2004.icms.lib.Utils;
import com.guitarhero2004.icms.lib.Utils.Console;
import com.guitarhero2004.icms.lib.idGenerator.IdGenerator;
import com.guitarhero2004.icms.lib.menu.MenuItem;
import com.guitarhero2004.icms.lib.menu.MenuList;
import com.guitarhero2004.icms.lib.menu.SubMenu;

public class Home {

    private final Terminal term;

    LineReader lineReader;

    private final MenuList menu;

    public Home(Terminal term) throws Exception {
        this.term = term;
        this.lineReader = LineReaderBuilder.builder().terminal(term).build();
        this.menu = new MenuList(term);

        // Dependents
        setupDependentMenu();

        // Policy holders
        MenuItem policyHolders = new MenuItem("Policy holders", () -> {
            System.out.println("Policy holders");
        });

        MenuItem insuranceCards = new MenuItem("Insurance cards", () -> {
            System.out.println("Insurance cards");
        });

        MenuItem claims = new MenuItem("Claims", () -> {
            System.out.println("Claims");
        });

        menu.addItem(policyHolders);
        menu.addItem(insuranceCards);
        menu.addItem(claims);

        menu.run();
    }

    private void setupDependentMenu() {
        SubMenu dependentsMenu = new SubMenu(term);
        MenuItem dependents = new MenuItem("Dependents", dependentsMenu);

        MenuItem viewDependent = new MenuItem("View dependent", () -> {
            DependentDB db = DependentDB.getInstance();
            displayData(db.getAll());
        });
        MenuItem addDependent = new MenuItem("Add dependent", () -> {
            // System.out.println("Add dependent");
            addDependent();
        });
        MenuItem removeDependent = new MenuItem("Remove dependent", () -> {
            System.out.println("Remove dependent");
        });

        dependentsMenu.addItem(viewDependent);
        dependentsMenu.addItem(addDependent);
        dependentsMenu.addItem(removeDependent);

        menu.addItem(dependents);
    }

    private void addDependent() {
        Console.clearScreen();

        System.out.println("Add dependent" + Utils.getDivider(20));

        String id = IdGenerator.generateId(7).prefix("c-");

        String name = lineReader.readLine("Enter name: ");

        DependentDB db = DependentDB.getInstance();
        Dependent dep = Dependent.builder().setID(id).setName(name).build();
        db.add(dep);
    }

    private <T extends Storeable> void displayData(Collection<T> dataList) {

        Console.clearScreen();

        for (T s : dataList) {
            System.out.println(s.toString());
        }

        System.out.println("\nPress any key to continue...");
        try {
            Console.getch(term);
        } catch (IOException e) {}
    }

}
