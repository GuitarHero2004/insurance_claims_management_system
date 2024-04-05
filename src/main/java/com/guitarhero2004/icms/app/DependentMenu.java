package com.guitarhero2004.icms.app;

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

public class DependentMenu extends AbstractPageMenu<Dependent> {

    public DependentMenu(Terminal term, MenuList menu) {
        super(term, "Dependent", menu, DependentDB.getInstance());
    }

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
