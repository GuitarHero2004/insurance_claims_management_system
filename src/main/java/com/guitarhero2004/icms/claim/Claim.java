package com.guitarhero2004.icms.claim;

import com.guitarhero2004.icms.database.Storeable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Tran Nguyen Anh Minh - s3979367
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

    private void validateID(String id) {
        if (!id.matches("f-\\d{10}")) {
            throw new IllegalArgumentException("Invalid id format");
        }
    }

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
