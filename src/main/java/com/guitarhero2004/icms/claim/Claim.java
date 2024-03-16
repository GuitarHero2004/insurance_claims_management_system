package com.guitarhero2004.icms.claim;

import com.guitarhero2004.icms.card.InsuranceCard;
import com.guitarhero2004.icms.customer.Customer;
import java.util.Date;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 */

public class Claim {
    private String claimId;
    private Date claimDate;
    private Customer insuredPerson;
    private InsuranceCard cardNumber;
    private Date examDate;
//    private ArrayList<ClaimDocuments> listOfDocuments;
    private Status status;
    private float claimAmount;
    private String receiverBankingInfo; // Bank - Name - Number

    private boolean validateID(String id) {
        if (id.matches("f-\\d{10}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid id format");
        }
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
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
        return "Claim{" +
                "id='" + claimId + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + insuredPerson +
                ", cardNumber=" + cardNumber +
                ", examDate=" + examDate +
                ", status=" + status +
                ", claimAmount=" + claimAmount +
                ", receiverBankingInfo='" + receiverBankingInfo + '\'' +
                '}';
    }
}
