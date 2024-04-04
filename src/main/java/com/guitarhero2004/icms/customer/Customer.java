package com.guitarhero2004.icms.customer;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.database.Storeable;

import java.util.*;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */

public abstract class Customer implements Storeable {
    private final String id;
    private final String fullName;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;

    public Customer(String id, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        validateId(id);
        this.id = id;
        this.fullName = fullName;
        this.claims = claims;
    }

    private void validateId(String customerId) {
        if (!customerId.matches("c-\\d{7}")) {
            throw new IllegalArgumentException("Invalid id format");
        }
    }

    public String getId() {
        return id;
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

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }

}
