package com.guitarhero2004.icms.customer;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.claim.Claim;

import java.util.ArrayList;

/**
 * Builder class for Dependent.
 * This class follows the Builder design pattern.
 */
public class DependentBuilder {

    /**
     * Returns a new Builder for Dependent.
     * @return A new Builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for Dependent.
     */
    public static class Builder {
        private String id;
        private String name;
        private InsuranceCard insuranceCard;
        private ArrayList<Claim> claims;

        /**
         * Sets the ID of the Dependent.
         * @param id The ID.
         * @return The Builder.
         */
        public Builder setID(String id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the name of the Dependent.
         * @param name The name.
         * @return The Builder.
         */
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the insurance card of the Dependent.
         * @param insuranceCard The insurance card.
         * @return The Builder.
         */
        public Builder setCard(InsuranceCard insuranceCard) {
            this.insuranceCard = insuranceCard;
            return this;
        }

        /**
         * Sets the claims of the Dependent.
         * @param claims The claims.
         * @return The Builder.
         */
        public Builder setClaims(ArrayList<Claim> claims) {
            this.claims = claims;
            return this;
        }

        /**
         * Builds the Dependent object.
         * @return The built Dependent object.
         */
        public Dependent build() {
            return new Dependent(id, name, insuranceCard, claims);
        }
    }
}