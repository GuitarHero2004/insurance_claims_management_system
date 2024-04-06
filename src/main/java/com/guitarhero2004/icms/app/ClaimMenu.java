package com.guitarhero2004.icms.app;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.claim.Status;
import com.guitarhero2004.icms.customer.Customer;
import com.guitarhero2004.icms.database.AbstractDB;
import com.guitarhero2004.icms.database.CardDB;
import com.guitarhero2004.icms.database.ClaimDB;
import com.guitarhero2004.icms.database.DependentDB;
import com.guitarhero2004.icms.database.PolicyHolderDB;
import com.guitarhero2004.icms.lib.Utils;
import com.guitarhero2004.icms.lib.Utils.Console;
import com.guitarhero2004.icms.lib.idGenerator.IdGenerator;
import com.guitarhero2004.icms.lib.menu.MenuItem;
import com.guitarhero2004.icms.lib.menu.MenuList;

/**
 * Class for managing the menu related to Claims.
 * Extends the AbstractPageMenu class with Claim as the type parameter.
 */
public class ClaimMenu extends AbstractPageMenu<Claim> {
    /**
     * Constructor for ClaimMenu.
     * @param term The terminal where the menu will be displayed.
     * @param menu The menu list where the menu items will be added.
     */
    public ClaimMenu(Terminal term, MenuList menu) {
        super(term, "Claim", menu, ClaimDB.getInstance());
    }

    /**
     * Method for setting up the object menu
     * Overrides the method in the superclass.
     * @param menu The menu list where the menu items will be added.
     * @param db The database where the objects will be stored.
     */
    @Override
    protected void setupObjectMenu(MenuList menu, AbstractDB<Claim> db) {
        super.setupObjectMenu(menu, db);
        MenuItem updateObjItem = new MenuItem("Update " + name, () -> {
            Claim claim = Utils.Console.promptForInput("Enter claim id to update (index from list): ", lineReader, db, this::displayData);
            updateClaim(claim);
        });

        objMenu.addItem(updateObjItem);
    }

    /**
     * Method for adding a Claim object to the database.
     * Overrides the abstract method in the superclass.
     * @param db The database where the object will be added.
     */
    @Override
    protected void addObj(AbstractDB<Claim> db) {
        Console.clearScreen();

        System.out.println("Add " + name + Utils.getDivider(20));

        String id = IdGenerator.generateId(10).prefix("f-");

        LocalDateTime claimDate = LocalDateTime.now();

        Set<Customer> customers = new HashSet<>(DependentDB.getInstance().getAll());
        customers.addAll(PolicyHolderDB.getInstance().getAll());

        Customer insuredPerson = Utils.Console.promptForInput("Enter insured person (index from list): ", lineReader, customers, this::displayData);
        String insuredPersonStr = insuredPerson.getFullName();

        InsuranceCard card = Utils.Console.promptForInput("Enter card number (index from list): ", lineReader, CardDB.getInstance(), this::displayData);
        String cardStr = card.getCardNumber();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime examDate;
        while (true) {
            String claimDateStr = lineReader.readLine("Enter claim date (dd/MM/yyyy): ");
            try {
                LocalDateTime date = LocalDate.parse(claimDateStr, formatter).atStartOfDay();
                examDate = date;
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format");
            }
        }

        String[] documents = lineReader.readLine("Enter list of documents (separated by comma): ").split(",");
        Set<String> setOfDocuments = new HashSet<>();
        for (String doc : documents) {
            setOfDocuments.add(doc.trim());
        }
        // turn all into claimid_cardNumber_documentName.pdf
        List<String> listOfDocuments = setOfDocuments.stream().map(
            doc -> id + "_" + cardStr + "_" + doc + ".pdf"
        ).collect(java.util.stream.Collectors.toList());

        System.out.println("1. NEW | 2. PROCESSING | 3. DONE");
        Status status;
        while (true) {
            try {
                int idx = Integer.parseInt(lineReader.readLine("Enter claim status: "));
                if (idx < 1 || idx > 3) {
                    throw new IllegalArgumentException("Invalid status");
                }
                status = Status.values()[idx - 1];
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid claim amount format");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // try catch float parse
        float claimAmount;
        while (true) {
            try {
                claimAmount = Float.parseFloat(lineReader.readLine("Enter claim amount (in $): "));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid claim amount format");
            }
        }

        String receiverBankingInfo = lineReader.readLine("Enter receiver banking info (Bank - Name - Number): ");

        Claim claim = new Claim(id, claimDate, insuredPersonStr, cardStr, examDate, listOfDocuments, status, claimAmount, receiverBankingInfo);
        db.add(claim);
    }

    /**
     * Method for updating a Claim object in the database.
     * @param oldClaim The old claim object to be updated.
     */
    protected void updateClaim(Claim oldClaim) {
        System.out.println("Update " + name + Utils.getDivider(20));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime examDate;
        System.out.println("\nOld exam date: " + oldClaim.getExamDate().format(formatter));
        while (true) {
            String expirationDateStr = lineReader.readLine("Enter expiration date (dd/MM/yyyy): ");
            try {
                LocalDateTime date = LocalDate.parse(expirationDateStr, formatter).atStartOfDay();
                examDate = date;
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format");
            }
        }

        System.out.println("\nOld list of documents: " + oldClaim.getListOfDocuments());
        String[] documents = lineReader.readLine("Enter list of documents (separated by comma): ").split(",");
        List<String> setOfDocuments = new ArrayList<>();
        for (String doc : documents) {
            setOfDocuments.add(doc.trim());
        }
        // turn all into claimid_cardNumber_documentName.pdf
        List<String> listOfDocuments = setOfDocuments.stream().map(
            doc -> oldClaim.getClaimId() + "_" + oldClaim.getCardNumber() + "_" + doc + ".pdf"
        ).collect(java.util.stream.Collectors.toList());

        System.out.println("\nOld claim status: " + oldClaim.getStatus());
        System.out.println("1. NEW | 2. PROCESSING | 3. DONE");
        Status status;
        while (true) {
            try {
                int idx = Integer.parseInt(lineReader.readLine("Enter claim status: "));
                if (idx < 1 || idx > 3) {
                    throw new IllegalArgumentException("Invalid status");
                }
                status = Status.values()[idx - 1];
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid claim amount format");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // try catch float parse
        float claimAmount;
        System.out.println("\nOld claim amount: " + oldClaim.getClaimAmount());
        while (true) {
            try {
                claimAmount = Float.parseFloat(lineReader.readLine("Enter claim amount: "));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid claim amount format");
            }
        }

        System.out.println("\nOld receiver banking info: " + oldClaim.getReceiverBankingInfo());
        String receiverBankingInfo = lineReader.readLine("Enter receiver banking info (Bank - Name - Number): ");
    
        Claim claim = new Claim(oldClaim.getClaimId(), oldClaim.getClaimDate(), oldClaim.getInsuredPerson(), oldClaim.getCardNumber(), examDate, listOfDocuments, status, claimAmount, receiverBankingInfo);
        ClaimDB.getInstance().update(oldClaim, claim);
    }
    
}
