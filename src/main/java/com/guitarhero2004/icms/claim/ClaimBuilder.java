package com.guitarhero2004.icms.claim;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.time.LocalDateTime;
import java.util.List;

/**
 * Builder class for Claim.
 * This class follows the Builder design pattern.
 */
public class ClaimBuilder {
    private String claimId;
    private LocalDateTime claimDate;
    private String insuredPerson;
    private String cardNumber;
    private LocalDateTime examDate;
    private List<String> listOfDocuments;
    private Status status;
    private float claimAmount;
    private String receiverBankingInfo; // Bank - Name - Number

    /**
     * Sets the claim ID.
     * @param claimId The claim ID.
     * @return The Builder.
     */
    public ClaimBuilder setClaimId(String claimId) {
        this.claimId = claimId;
        return this;
    }

    /**
     * Sets the claim date.
     * @param claimDate The claim date.
     * @return The Builder.
     */
    public ClaimBuilder setClaimDate(LocalDateTime claimDate) {
        this.claimDate = claimDate;
        return this;
    }

    /**
     * Sets the insured person's name.
     * @param insuredPerson The insured person's name.
     */
    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    /**
     * Sets the card number.
     * @param cardNumber The card number.
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Sets the exam date.
     * @param examDate The exam date.
     */
    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    /**
     * Sets the list of documents.
     * @param listOfDocuments The list of documents.
     */
    public void setListOfDocuments(List<String> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    /**
     * Sets the status of the claim.
     * @param status The status of the claim.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Sets the claim amount.
     * @param claimAmount The claim amount.
     */
    public void setClaimAmount(float claimAmount) {
        this.claimAmount = claimAmount;
    }

    /**
     * Sets the receiver's banking information.
     * @param receiverBankingInfo The receiver's banking information.
     */
    public void setReceiverBankingInfo(String receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }

    /**
     * Builds the Claim object.
     * @return The built Claim object.
     */
    public Claim build() {
        return new Claim(claimId, claimDate, insuredPerson, cardNumber, examDate, listOfDocuments, status, claimAmount, receiverBankingInfo);
    }
}