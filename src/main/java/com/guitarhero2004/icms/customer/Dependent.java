package com.guitarhero2004.icms.customer;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.database.DependentDB;

import java.util.ArrayList;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */
public class Dependent extends Customer {

    public Dependent(String customerId, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        super(customerId, fullName, insuranceCard, claims);
    }

    @Override
    public String toString() {
        return "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", InsuranceCard=" + getInsuranceCard() +
                ", claims=" + getClaims();
    }
}
