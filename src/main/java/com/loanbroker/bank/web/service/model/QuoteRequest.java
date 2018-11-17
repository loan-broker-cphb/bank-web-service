package com.loanbroker.bank.web.service.model;

public class QuoteRequest {

    // Should have all the same fields specified in the assignment for the json bank
    // Should also have a field called replyTo, which is the URL for AMQP queue


    private int ssn;
    private int creditScore;
    private double loanAmount;
    private int loanDuration;

    public QuoteRequest() {
    }

    public QuoteRequest(int ssn, int creditScore, double loanAmount, int loanDurationMount) {
        this.ssn = ssn;
        this.creditScore = creditScore;
        this.loanAmount = loanAmount;
        this.loanDuration = loanDurationMount;
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


