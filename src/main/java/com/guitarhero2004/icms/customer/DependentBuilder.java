package com.guitarhero2004.icms.customer;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;

import java.util.ArrayList;

public class DependentBuilder {
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
}
