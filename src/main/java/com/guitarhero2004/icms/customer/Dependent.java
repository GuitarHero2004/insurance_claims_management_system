package com.guitarhero2004.icms.customer;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;
import com.guitarhero2004.icms.database.DependentDB;

import java.util.ArrayList;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */
public class Dependent extends Customer {

    public static void main(String[] args) {
        DependentDB dp = DependentDB.getInstance();
        Dependent test = Dependent.builder().setID("c-1234567").setName("TEST").build();
        dp.add(test);
    }

    public Dependent(String customerId, String fullName, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        super(customerId, fullName, insuranceCard, claims);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private InsuranceCard insuranceCard;
        private ArrayList<Claim> claims;

        public Builder setID(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCard(InsuranceCard insuranceCard) {
            this.insuranceCard = insuranceCard;
            return this;
        }

        public Builder setClaims(ArrayList<Claim> claims) {
            this.claims = claims;
            return this;
        }

        public Dependent build() {
            return new Dependent(id, name, insuranceCard, claims);
        }
    }

    @Override
    public String toString() {
        return "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", InsuranceCard=" + getInsuranceCard() +
                ", claims=" + getClaims();
    }
}
