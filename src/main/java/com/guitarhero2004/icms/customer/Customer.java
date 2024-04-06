package com.guitarhero2004.icms.customer;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.database.Storeable;

import java.util.*;

/**
 * Abstract class representing a customer.
 * Implements the Storeable interface.
 */
public abstract class Customer implements Storeable {
    private final String id;
    private final String fullName;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;

    /**
     * Constructor for Customer.
     * @param id The customer's ID.
     * @param fullName The customer's full name.
     * @param insuranceCard The customer's insurance card.
     * @param claims The list of claims made by the customer.
     */
    public Customer(String id, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        validateId(id);
        this.id = id;
        this.fullName = fullName;
        this.claims = claims;
    }

    /**
     * Validates the customer's ID.
     * The ID must match the pattern "c-\d{7}".
     * @param customerId The customer's ID to validate.
     * @throws IllegalArgumentException If the ID does not match the required pattern.
     */
    private void validateId(String customerId) {
        if (!customerId.matches("c-\\d{7}")) {
            throw new IllegalArgumentException("Invalid id format");
        }
    }

    /**
     * Returns the customer's ID.
     * @return The customer's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the customer's full name.
     * @return The customer's full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns the customer's insurance card.
     * @return The customer's insurance card.
     */
    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    /**
     * Sets the customer's insurance card.
     * @param insuranceCard The new insurance card.
     */
    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    /**
     * Returns the list of claims made by the customer.
     * @return The list of claims.
     */
    public ArrayList<Claim> getClaims() {
        return claims;
    }

    /**
     * Sets the list of claims made by the customer.
     * @param claims The new list of claims.
     */
    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }

}