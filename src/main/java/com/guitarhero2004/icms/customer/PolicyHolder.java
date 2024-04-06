package com.guitarhero2004.icms.customer;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;

import java.util.*;

/**
 * Class representing a policyholder.
 * Extends the Customer class.
 */
public class PolicyHolder extends Customer {
    private ArrayList<Dependent> listOfDependents;

    /**
     * Constructor for PolicyHolder.
     * @param customerId The policyholder's customer ID.
     * @param fullName The policyholder's full name.
     * @param insuranceCard The policyholder's insurance card.
     * @param claims The list of claims made by the policyholder.
     * @param listOfDependents The list of dependents of the policyholder.
     */
    public PolicyHolder(String customerId, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims, ArrayList<Dependent> listOfDependents) {
        super(customerId, fullName, insuranceCard, claims);
        this.listOfDependents = listOfDependents;
    }

    /**
     * Returns the list of dependents of the policyholder.
     * @return The list of dependents.
     */
    public ArrayList<Dependent> getListOfDependents() {
        return listOfDependents;
    }

    /**
     * Sets the list of dependents of the policyholder.
     * @param listOfDependents The new list of dependents.
     */
    public void setListOfDependents(ArrayList<Dependent> listOfDependents) {
        this.listOfDependents = listOfDependents;
    }

    /**
     * Adds a dependent to the list of dependents of the policyholder.
     * @param dependent The dependent to add.
     */
    public void addDependent(Dependent dependent) {
        this.listOfDependents.add(dependent);
    }

    /**
     * Removes a dependent from the list of dependents of the policyholder.
     * @param dependent The dependent to remove.
     */
    public void removeDependent(Dependent dependent) {
        this.listOfDependents.remove(dependent);
    }

    /**
     * Returns a string representation of the PolicyHolder.
     * @return A string representation of the PolicyHolder.
     */
    @Override
    public String toString() {
        return "listOfDependents: " + listOfDependents +
                ", id: '" + getId() + '\'' +
                ", fullName: '" + getFullName() + '\'' +
                ", InsuranceCard: " + getInsuranceCard() +
                ", claims: " + getClaims();
    }

}