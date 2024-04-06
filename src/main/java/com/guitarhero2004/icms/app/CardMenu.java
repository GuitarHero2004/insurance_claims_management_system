package com.guitarhero2004.icms.app;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.database.AbstractDB;
import com.guitarhero2004.icms.database.CardDB;
import com.guitarhero2004.icms.lib.Utils;
import com.guitarhero2004.icms.lib.Utils.Console;
import com.guitarhero2004.icms.lib.idGenerator.IdGenerator;
import com.guitarhero2004.icms.lib.menu.MenuList;

/**
 * Class for managing the menu related to Insurance Cards.
 * Extends the AbstractPageMenu class with InsuranceCard as the type parameter.
 */
public class CardMenu extends AbstractPageMenu<InsuranceCard> {

    /**
     * Constructor for CardMenu.
     * @param term The terminal where the menu will be displayed.
     * @param menu The menu list where the menu items will be added.
     */
    public CardMenu(Terminal term, MenuList menu) {
        super(term, "Insurance card", menu, CardDB.getInstance());
    }

    /**
     * Method for adding an InsuranceCard object to the database.
     * Overrides the abstract method in the superclass.
     * @param db The database where the object will be added.
     */
    @Override
    protected void addObj(AbstractDB<InsuranceCard> db) {
        Console.clearScreen();

        System.out.println("Add " + name + Utils.getDivider(20));

        String id = IdGenerator.generateId(10).getId();

        String cardHolder = lineReader.readLine("Enter card holder: ");

        String policyOwner = lineReader.readLine("Enter policy owner: ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime expirationDate;
        while (true) {
            String expirationDateStr = lineReader.readLine("Enter expiration date (dd/MM/yyyy): ");
            try {
                expirationDate = LocalDate.parse(expirationDateStr, formatter).atStartOfDay();
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format");
            }
        }

        InsuranceCard card = InsuranceCard.builder().cardNumber(id).cardHolderName(cardHolder).policyOwner(policyOwner).expirationDate(expirationDate).build();
        db.add(card);
    }

}