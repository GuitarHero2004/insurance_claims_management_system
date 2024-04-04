package com.guitarhero2004.icms.app;

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

public class CardMenu extends AbstractPageMenu<InsuranceCard> {

    public CardMenu(Terminal term, MenuList menu) {
        super(term, "Insurance card", menu, CardDB.getInstance());
    }

    @Override
    protected void addObj(AbstractDB<InsuranceCard> db) {
        Console.clearScreen();

        System.out.println("Add " + name + Utils.getDivider(20));

        String id = IdGenerator.generateId(10).getId();

        String holderName = lineReader.readLine("Enter card holder: ");
        String cardHolder = holderName;

        String policyOwner = lineReader.readLine("Enter policy owner: ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime expirationDate;
        while (true) {
            String expirationDateStr = lineReader.readLine("Enter expiration date (dd/MM/yyyy): ");
            try {
                LocalDateTime date = LocalDate.parse(expirationDateStr, formatter).atStartOfDay();
                expirationDate = date;
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format");
            }
        }

        InsuranceCard card = InsuranceCard.builder().cardNumber(id).cardHolderName(cardHolder).policyOwner(policyOwner).expirationDate(expirationDate).build();
        db.add(card);
    }
    
}
