package com.cognizant.account;

public class Account {
    private String number;
    private String type;
    private long balance;

    // Constructor
    public Account(String number, String type, long balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    // Getters and Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}