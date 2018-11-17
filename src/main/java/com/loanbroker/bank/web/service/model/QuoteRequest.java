package com.loanbroker.bank.web.service.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuoteRequest {

    // Should have all the same fields specified in the assignment for the json bank
    // Should also have a field called replyTo, which is the URL for AMQP queue


    @NotNull
    private int ssn;

    @NotNull
    private int creditScore;

    @NotNull
    private double loanAmount;

    @NotNull
    private int loanDuration;

    @NotBlank
    private String replyTo;

    public QuoteRequest() {
    }

    public QuoteRequest(int ssn, int creditScore, double loanAmount, int loanDurationMount, String replyTo) {
        this.ssn = ssn;
        this.creditScore = creditScore;
        this.loanAmount = loanAmount;
        this.loanDuration = loanDurationMount;
        this.replyTo = replyTo;
    }


    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    @Override
    public String toString() {
        return "QuoteRequest{" +
                "ssn=" + ssn +
                ", creditScore=" + creditScore +
                ", loanAmount=" + loanAmount +
                ", loanDuration=" + loanDuration +
                '}';
    }
}


