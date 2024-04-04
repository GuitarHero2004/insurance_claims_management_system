package com.guitarhero2004.icms.customer;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;

import java.util.*;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */

public class PolicyHolder extends Customer{
    private ArrayList<Dependent> listOfDependents;

    public PolicyHolder(String customerId, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims, ArrayList<Dependent> listOfDependents) {
        super(customerId, fullName, insuranceCard, claims);
        this.listOfDependents = listOfDependents;
    }

    public ArrayList<Dependent> getListOfDependents() {
        return listOfDependents;
    }

    public void setListOfDependents(ArrayList<Dependent> listOfDependents) {
        this.listOfDependents = listOfDependents;
    }

    public void addDependent(Dependent dependent) {
        this.listOfDependents.add(dependent);
    }

    public void removeDependent(Dependent dependent) {
        this.listOfDependents.remove(dependent);
    }

    @Override
    public String toString() {
        return "PolicyHolder{" +
                ", listOfDependents=" + listOfDependents +
                ", id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", InsuranceCard=" + getInsuranceCard().getCardNumber() +
                ", claims=" + getClaims() +
                '}';
    }
}
