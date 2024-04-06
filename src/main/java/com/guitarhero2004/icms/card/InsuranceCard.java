package com.guitarhero2004.icms.card;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import com.guitarhero2004.icms.database.Storeable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class representing an insurance card.
 * Implements the Storeable interface.
 */
public class InsuranceCard implements Storeable {
    private final String cardNumber;
    private String cardHolderName;
    private final String policyOwner;
    private LocalDateTime expirationDate;

    /**
     * Constructor for InsuranceCard.
     * @param cardNumber The card number.
     * @param cardHolderName The name of the card holder.
     * @param policyOwner The name of the policy owner.
     * @param expirationDate The expiration date of the card.
     */
    public InsuranceCard(String cardNumber, String cardHolderName, String policyOwner, LocalDateTime expirationDate) {
        validateCardNumber(cardNumber);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    /**
     * Validates that the card number contains exactly 10 digits.
     * @param cardNumber The card number to validate.
     * @throws IllegalArgumentException If the card number does not contain exactly 10 digits.
     */
    private void validateCardNumber(String cardNumber) {
        if (!cardNumber.matches("^\\d{10}$")) {
            throw new IllegalArgumentException("Invalid card number format - Please enter a 10-digit card number");
        }
    }

    /**
     * Sets the name of the card holder.
     * @param cardHolderName The new name of the card holder.
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * Returns a new Builder for InsuranceCard.
     * @return A new Builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for InsuranceCard.
     */
    public static class Builder {
        private String cardNumber;
        private String cardHolderName;
        private String policyOwner;
        private LocalDateTime expirationDate;

        /**
         * Sets the card number.
         * @param cardNumber The card number.
         * @return The Builder.
         */
        public Builder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        /**
         * Sets the name of the cardholder.
         * @param cardHolderName The name of the cardholder.
         * @return The Builder.
         */
        public Builder cardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
            return this;
        }

        /**
         * Sets the name of the policy owner.
         * @param policyOwner The name of the policy owner.
         * @return The Builder.
         */
        public Builder policyOwner(String policyOwner) {
            this.policyOwner = policyOwner;
            return this;
        }

        /**
         * Sets the expiration date of the card.
         * @param expirationDate The expiration date.
         * @return The Builder.
         */
        public Builder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        /**
         * Builds the InsuranceCard.
         * @return The built InsuranceCard.
         */
        public InsuranceCard build() {
            return new InsuranceCard(cardNumber, cardHolderName, policyOwner, expirationDate);
        }
    }

    /**
     * Returns the card number.
     * @return The card number.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Returns the name of the cardholder.
     * @return The name of the cardholder.
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Returns the name of the policy owner.
     * @return The name of the policy owner.
     */
    public String getPolicyOwner() {
        return policyOwner;
    }

    /**
     * Returns the expiration date of the card.
     * @return The expiration date.
     */
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the card.
     * @param expirationDate The new expiration date.
     */
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Returns a string representation of the InsuranceCard.
     * @return A string representation of the InsuranceCard.
     */
    @Override
    public String toString() {
        return "cardNumber=" + cardNumber +
                ", cardHolderName=" + cardHolderName +
                ", policyOwner=" + policyOwner +
                ", expirationDate=" + expirationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}