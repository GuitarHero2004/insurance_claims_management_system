package com.guitarhero2004.icms.claim;

import java.time.LocalDateTime;
import java.util.List;

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

    public ClaimBuilder setClaimId(String claimId) {
        this.claimId = claimId;
        return this;
    }

    public ClaimBuilder setClaimDate(LocalDateTime claimDate) {
        this.claimDate = claimDate;
        return this;
    }

    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public void setListOfDocuments(List<String> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setClaimAmount(float claimAmount) {
        this.claimAmount = claimAmount;
    }

    public void setReceiverBankingInfo(String receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }

    public Claim build() {
        return new Claim(claimId, claimDate, insuredPerson, cardNumber, examDate, listOfDocuments, status, claimAmount, receiverBankingInfo);
    }
}
