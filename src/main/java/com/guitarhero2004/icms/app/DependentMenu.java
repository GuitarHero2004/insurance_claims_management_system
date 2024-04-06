package com.guitarhero2004.icms.app;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import com.guitarhero2004.icms.customer.Dependent;
import com.guitarhero2004.icms.customer.DependentBuilder;
import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.database.AbstractDB;
import com.guitarhero2004.icms.database.CardDB;
import com.guitarhero2004.icms.database.DependentDB;
import com.guitarhero2004.icms.lib.Utils;
import com.guitarhero2004.icms.lib.Utils.Console;
import com.guitarhero2004.icms.lib.idGenerator.IdGenerator;
import com.guitarhero2004.icms.lib.menu.MenuList;

/**
 * Class for managing the menu related to Dependents.
 * Extends the AbstractPageMenu class with Dependent as the type parameter.
 */
public class DependentMenu extends AbstractPageMenu<Dependent> {

    /**
     * Constructor for DependentMenu.
     * @param term The terminal where the menu will be displayed.
     * @param menu The menu list where the menu items will be added.
     */
    public DependentMenu(Terminal term, MenuList menu) {
        super(term, "Dependent", menu, DependentDB.getInstance());
    }

    /**
     * Method for adding a Dependent object to the database.
     * Overrides the abstract method in the superclass.
     * @param db The database where the object will be added.
     */
    @Override
    protected void addObj(AbstractDB<Dependent> db) {
        Console.clearScreen();

        System.out.println("Add " + name + Utils.getDivider(20));

        String id = IdGenerator.generateId(7).prefix("c-");

        String name = lineReader.readLine("Enter name: ");

        InsuranceCard card = Utils.Console.promptForInput("\n[v to view | s to skip]\nEnter card number (index from list):", lineReader, CardDB.getInstance(), this::displayData);

        Dependent dep = new DependentBuilder.Builder().setID(id).setName(name).setCard(card).build();
        db.add(dep);
    }

}