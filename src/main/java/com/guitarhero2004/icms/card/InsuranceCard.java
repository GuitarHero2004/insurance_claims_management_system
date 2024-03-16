package com.guitarhero2004.icms.card;

import com.guitarhero2004.icms.customer.Customer;
import com.guitarhero2004.icms.customer.PolicyHolder;

import java.util.Date;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */

public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolderName;
    private final String policyOwner;
    private Date expirationDate;

    // Validate that one card can only have one customer
//    private void validateCardHolderName(Customer cardHolderName) {
//        if (this.cardHolderName == null) {
//            this.cardHolderName = cardHolderName;
//        } else {
//            throw new IllegalArgumentException("This card has already been assigned to a customer");
//        }
//    }

    // Validate that the card number contains exactly 10 digits
    private void validateCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        if (this.cardNumber.matches("\\d{10}")) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("Invalid card number format - Please enter a 10-digit card number");
        }
    }

    // Validate that the expiration date is not in the past
    private void validateExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        if (expirationDate.after(new Date())) {
            this.expirationDate = expirationDate;
        } else {
            throw new IllegalArgumentException("Invalid expiration date - Please enter a date in the future");
        }
    }

    public InsuranceCard() {
        this.cardNumber = "0000000000";
        this.policyOwner = "Policy Owner";
        this.expirationDate = new Date();
    }

    public InsuranceCard(String cardNumber, String policyOwner, Date expirationDate) {
        validateCardNumber(cardNumber);
        this.policyOwner = policyOwner;
        validateExpirationDate(expirationDate);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Customer getCardHolderName() {
        return cardHolderName;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        validateExpirationDate(expirationDate);
    }

    public void setCardHolderName(Customer cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber='" + getCardNumber() + '\'' +
                ", cardHolderName=" + getCardHolderName() +
                ", policyOwner='" + getPolicyOwner() + '\'' +
                ", expirationDate=" + getExpirationDate() +
                '}';
    }
}
