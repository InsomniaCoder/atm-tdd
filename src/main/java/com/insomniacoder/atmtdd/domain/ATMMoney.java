package com.insomniacoder.atmtdd.domain;

public class ATMMoney {

    private static final int TWENTY_BAHT = 20;
    private static final int FIFTY_BAHT = 50;
    private static final int HUNDRED_BAHT = 100;
    private static final int FIVEHUNDRED_BAHT = 500;
    private static final int THOUSAND_BAHT = 1000;

    private int twentyBankNote;
    private int fiftyBankNote;
    private int hundredBankNote;
    private int fiveHundredBankNote;
    private int thousandBankNote;

    public ATMMoney() {
    }

    public ATMMoney(int twentyBankNote, int fiftyBankNote, int hundredBankNote, int fiveHundredBankNote, int thousandBankNote) {
        this.twentyBankNote = twentyBankNote;
        this.fiftyBankNote = fiftyBankNote;
        this.hundredBankNote = hundredBankNote;
        this.fiveHundredBankNote = fiveHundredBankNote;
        this.thousandBankNote = thousandBankNote;
    }

    public void initMoney(int twentyBankNote, int fiftyBankNote, int hundredBankNote, int fiveHundredBankNote, int thousandBankNote) {
        this.twentyBankNote = twentyBankNote;
        this.fiftyBankNote = fiftyBankNote;
        this.hundredBankNote = hundredBankNote;
        this.fiveHundredBankNote = fiveHundredBankNote;
        this.thousandBankNote = thousandBankNote;
    }

    public int getTotalAmount() {
        return (twentyBankNote * TWENTY_BAHT) + (fiftyBankNote * FIFTY_BAHT) +
                (hundredBankNote * HUNDRED_BAHT) + (fiveHundredBankNote * FIVEHUNDRED_BAHT) + (thousandBankNote * THOUSAND_BAHT);
    }

    public int getTwentyBankNote() {
        return twentyBankNote;
    }

    public void setTwentyBankNote(int twentyBankNote) {
        this.twentyBankNote = twentyBankNote;
    }

    public int getFiftyBankNote() {
        return fiftyBankNote;
    }

    public void setFiftyBankNote(int fiftyBankNote) {
        this.fiftyBankNote = fiftyBankNote;
    }

    public int getHundredBankNote() {
        return hundredBankNote;
    }

    public void setHundredBankNote(int hundredBankNote) {
        this.hundredBankNote = hundredBankNote;
    }

    public int getFiveHundredBankNote() {
        return fiveHundredBankNote;
    }

    public void setFiveHundredBankNote(int fiveHundredBankNote) {
        this.fiveHundredBankNote = fiveHundredBankNote;
    }

    public int getThousandBankNote() {
        return thousandBankNote;
    }

    public void setThousandBankNote(int thousandBankNote) {
        this.thousandBankNote = thousandBankNote;
    }
}
