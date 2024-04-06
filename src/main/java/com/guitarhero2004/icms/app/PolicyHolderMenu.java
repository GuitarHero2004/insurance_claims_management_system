package com.guitarhero2004.icms.app;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.util.ArrayList;

import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.customer.Dependent;
import com.guitarhero2004.icms.customer.PolicyHolder;
import com.guitarhero2004.icms.customer.PolicyHolderBuilder;
import com.guitarhero2004.icms.database.AbstractDB;
import com.guitarhero2004.icms.database.CardDB;
import com.guitarhero2004.icms.database.DependentDB;
import com.guitarhero2004.icms.database.PolicyHolderDB;
import com.guitarhero2004.icms.lib.Utils;
import com.guitarhero2004.icms.lib.Utils.Console;
import com.guitarhero2004.icms.lib.idGenerator.IdGenerator;
import com.guitarhero2004.icms.lib.menu.MenuList;

/**
 * Class for managing the menu related to PolicyHolders.
 * Extends the AbstractPageMenu class with PolicyHolder as the type parameter.
 */
public class PolicyHolderMenu extends AbstractPageMenu<PolicyHolder> {

    /**
     * Constructor for PolicyHolderMenu.
     * @param term The terminal where the menu will be displayed.
     * @param menu The menu list where the menu items will be added.
     */
    public PolicyHolderMenu(Terminal term, MenuList menu) {
        super(term, "Policy holder", menu, PolicyHolderDB.getInstance());
    }

    /**
     * Method for adding a PolicyHolder object to the database.
     * Overrides the abstract method in the superclass.
     * @param db The database where the object will be added.
     */
    @Override
    protected void addObj(AbstractDB<PolicyHolder> db) {
        Console.clearScreen();

        System.out.println("Add " + name + Utils.getDivider(20));

        String id = IdGenerator.generateId(7).prefix("c-");

        String name = lineReader.readLine("Enter name: ");

        InsuranceCard card = Utils.Console.promptForInput("Enter card number (index from list): ", lineReader, CardDB.getInstance(), this::displayData);

        ArrayList<Dependent> dependents = new ArrayList<Dependent>();
        Dependent dep;
        do {
            dep = Utils.Console.promptForInput("Enter dependents (index from list): ", lineReader, DependentDB.getInstance().getAll(), this::displayData);
            if (dep != null) {
                dependents.add(dep);
            }
        } while (dep != null);

        PolicyHolder policyHolder = new PolicyHolderBuilder().setCustomerId(id).setFullName(name).setInsuranceCard(card).setListOfDependents(dependents).build();

        db.add(policyHolder);
    }
}