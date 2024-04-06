package com.guitarhero2004.icms.customer;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.util.ArrayList;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;

/**
 * Builder class for PolicyHolder.
 * This class follows the Builder design pattern.
 */
public class PolicyHolderBuilder {
    private String customerId;
    private String fullName;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;
    private ArrayList<Dependent> listOfDependents;

    /**
     * Sets the customer ID of the PolicyHolder.
     * @param customerId The customer ID.
     * @return The Builder.
     */
    public PolicyHolderBuilder setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Sets the full name of the PolicyHolder.
     * @param fullName The full name.
     * @return The Builder.
     */
    public PolicyHolderBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    /**
     * Sets the insurance card of the PolicyHolder.
     * @param insuranceCard The insurance card.
     * @return The Builder.
     */
    public PolicyHolderBuilder setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
        return this;
    }

    /**
     * Sets the claims of the PolicyHolder.
     * @param claims The claims.
     * @return The Builder.
     */
    public PolicyHolderBuilder setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
        return this;
    }

    /**
     * Sets the list of dependents of the PolicyHolder.
     * @param listOfDependents The list of dependents.
     * @return The Builder.
     */
    public PolicyHolderBuilder setListOfDependents(ArrayList<Dependent> listOfDependents) {
        this.listOfDependents = listOfDependents;
        return this;
    }

    /**
     * Builds the PolicyHolder object.
     * @return The built PolicyHolder object.
     */
    public PolicyHolder build() {
        return new PolicyHolder(customerId, fullName, insuranceCard, claims, listOfDependents);
    }
}