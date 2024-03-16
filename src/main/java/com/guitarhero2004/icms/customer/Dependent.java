package com.guitarhero2004.icms.customer;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;

import java.util.ArrayList;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */
public class Dependent extends Customer {

    private PolicyHolder policyHolder;

    public Dependent(String customerId, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims, PolicyHolder policyHolder) {
        super(customerId, fullName, insuranceCard, claims);
        this.policyHolder = policyHolder;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "id='" + getCustomerId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", InsuranceCard=" + getInsuranceCard() +
                ", claims=" + getClaims() +
                '}';
    }
}
