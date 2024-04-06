package com.guitarhero2004.icms.claim;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import com.guitarhero2004.icms.database.Storeable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * This class represents a Claim in the system.
 * A Claim has an id, claim date, insured person, card number, exam date, list of documents, status, claim amount, and receiver banking info.
 * It implements the Storeable interface.
 */
public class Claim implements Storeable {
    private final String claimId;
    private final LocalDateTime claimDate;
    private final String insuredPerson;
    private final String cardNumber;
    private LocalDateTime examDate;
    private List<String> listOfDocuments;
    private Status status;
    private float claimAmount;
    private String receiverBankingInfo; // Bank - Name - Number

    /**
     * Constructor for the Claim class.
     * @param claimId The id of the claim.
     * @param claimDate The date of the claim.
     * @param insuredPerson The insured person of the claim.
     * @param cardNumber The card number of the claim.
     * @param examDate The exam date of the claim.
     * @param listOfDocuments The list of documents of the claim.
     * @param status The status of the claim.
     * @param claimAmount The claim amount of the claim.
     * @param receiverBankingInfo The receiver banking info of the claim.
     */
    public Claim(String claimId, LocalDateTime claimDate, String insuredPerson, String cardNumber,
                 LocalDateTime examDate,
                 List<String> listOfDocuments, Status status, float claimAmount, String receiverBankingInfo) {
        validateID(claimId);
        this.claimId = claimId;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.listOfDocuments = listOfDocuments;
        this.status = status;
        this.claimAmount = claimAmount;
        this.receiverBankingInfo = receiverBankingInfo;
    }

    /**
     * Validates the id of the claim.
     * @param id The id to validate.
     * @throws IllegalArgumentException if the id is not in the correct format.
     */
    private void validateID(String id) {
        if (!id.matches("f-\\d{10}")) {
            throw new IllegalArgumentException("Invalid id format");
        }
    }

    // Getters and setters for the class fields.

    public String getClaimId() {
        return claimId;
    }

    public LocalDateTime getClaimDate() {
        return claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public List<String> getListOfDocuments() {
        return listOfDocuments;
    }

    public void setListOfDocuments(List<String> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(float claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    public void setReceiverBankingInfo(String receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }

    /**
     * Returns a string representation of the Claim object.
     * @return A string representation of the Claim object.
     */
    @Override
    public String toString() {
        return "claimId=" + claimId +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + insuredPerson +
                ", cardNumber=" + cardNumber +
                ", examDate=" + examDate +
                ", listOfDocuments=" + listOfDocuments +
                ", status=" + status +
                ", claimAmount=" + claimAmount +
                ", receiverBankingInfo=" + receiverBankingInfo;
    }

}