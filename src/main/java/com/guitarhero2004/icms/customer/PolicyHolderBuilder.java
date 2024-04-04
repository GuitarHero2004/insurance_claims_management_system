package com.guitarhero2004.icms.customer;

import java.util.ArrayList;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;

public class PolicyHolderBuilder {
    private String customerId;
    private String fullName;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;
    private ArrayList<Dependent> listOfDependents;

    public PolicyHolderBuilder setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public PolicyHolderBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public PolicyHolderBuilder setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
        return this;
    }

    public PolicyHolderBuilder setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
        return this;
    }

    public PolicyHolderBuilder setListOfDependents(ArrayList<Dependent> listOfDependents) {
        this.listOfDependents = listOfDependents;
        return this;
    }

    public PolicyHolder build() {
        return new PolicyHolder(customerId, fullName, insuranceCard, claims, listOfDependents);
    }
}
