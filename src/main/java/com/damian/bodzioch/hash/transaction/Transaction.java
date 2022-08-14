package com.damian.bodzioch.hash.transaction;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Transaction {
    private String previousHash;
    private double value;
    private int mineFactor;

    public Transaction(int mineFactor){
        previousHash = RandomStringUtils.randomAlphanumeric(32);
        value = new Random().nextDouble(100.01);
        this.mineFactor = mineFactor;
    }

    public Transaction() {
    }

    @Override
    public String toString() {
        return previousHash + value + mineFactor;
    }
}
