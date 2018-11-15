package com.loanbroker.bank.web.service.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

import java.io.Serializable;


public class QuoteResponse implements Serializable {
    private double interestRate;
    private int ssn ;
    private static final long serialVersionUID = -295422703255886286L;

    public QuoteResponse() {
    }

    public QuoteResponse(double interestRate, int ssn) {
        this.interestRate = interestRate;
        this.ssn = ssn;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "QuoteResponse{" +
                "interestRate=" + interestRate +
                ", ssn=" + ssn +
                '}';
    }
}

