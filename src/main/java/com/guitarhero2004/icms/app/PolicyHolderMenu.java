package com.guitarhero2004.icms.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.customer.Customer;
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

public class PolicyHolderMenu extends AbstractPageMenu<PolicyHolder> {
    public PolicyHolderMenu(Terminal term, MenuList menu) {
        super(term, "Policy holder", menu, PolicyHolderDB.getInstance());
    }

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
