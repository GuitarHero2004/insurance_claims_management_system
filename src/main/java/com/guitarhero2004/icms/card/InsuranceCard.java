package com.guitarhero2004.icms.card;

import com.guitarhero2004.icms.database.Storeable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */

public class InsuranceCard implements Storeable {
    private final String cardNumber;
    private String cardHolderName;
    private final String policyOwner;
    private LocalDateTime expirationDate;

    public InsuranceCard(String cardNumber, String cardHolderName, String policyOwner, LocalDateTime expirationDate) {
        validateCardNumber(cardNumber);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    // Validate that the card number contains exactly 10 digits
    private void validateCardNumber(String cardNumber) {
        if (!cardNumber.matches("^\\d{10}$")) {
            throw new IllegalArgumentException("Invalid card number format - Please enter a 10-digit card number");
        }
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String cardNumber;
        private String cardHolderName;
        private String policyOwner;
        private LocalDateTime expirationDate;

        public Builder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder cardHolderName(String cardHolderName) {
            this.cardHolderName = cardHolderName;
            return this;
        }

        public Builder policyOwner(String policyOwner) {
            this.policyOwner = policyOwner;
            return this;
        }

        public Builder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public InsuranceCard build() {
            return new InsuranceCard(cardNumber, cardHolderName, policyOwner, expirationDate);
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "cardNumber=" + cardNumber +
                ", cardHolderName=" + cardHolderName +
                ", policyOwner=" + policyOwner +
                ", expirationDate=" + expirationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}
