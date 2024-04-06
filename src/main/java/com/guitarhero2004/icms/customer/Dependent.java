package com.guitarhero2004.icms.customer;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.database.DependentDB;

import java.util.ArrayList;

/**
 * Class representing a dependent customer.
 * Extends the Customer class.
 */
public class Dependent extends Customer {

    /**
     * Constructor for Dependent.
     * @param customerId The dependent's customer ID.
     * @param fullName The dependent's full name.
     * @param insuranceCard The dependent's insurance card.
     * @param claims The list of claims made by the dependent.
     */
    public Dependent(String customerId, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        super(customerId, fullName, insuranceCard, claims);
    }

    /**
     * Returns a string representation of the Dependent.
     * @return A string representation of the Dependent.
     */
    @Override
    public String toString() {
        return "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", InsuranceCard=" + getInsuranceCard() +
                ", claims=" + getClaims();
    }
}