package com.guitarhero2004.icms.customer;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.claim.ClaimProcessManager;

import java.util.*;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */

public abstract class Customer {
    private String customerId;
    private final String fullName;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;

    private void validateId(String customerId) {
        if (customerId.matches("c-\\d{7}")) {
            this.customerId = customerId;
        } else {
            throw new IllegalArgumentException("Invalid id format");
        }
    }

    // Validate that the customer has an insurance card
    private void validateInsuranceCard(InsuranceCard insuranceCard) {
        if (insuranceCard != null) {
            this.insuranceCard = insuranceCard;
        } else {
            throw new IllegalArgumentException("The customer must have an insurance card");
        }
    }

    public Customer(String customerId, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        validateId(customerId);
        this.fullName = fullName;
        validateInsuranceCard(insuranceCard);
        this.claims = claims;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }
}
