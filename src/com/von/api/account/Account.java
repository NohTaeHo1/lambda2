package com.von.api.account;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})

public class Account {
    private long id;
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Date transactionDate;

    @Builder(builderMethodName = "builder")
    public Account(long id, String accountNumber, String accountHolder, double balance, Date transactionDate){
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactionDate = transactionDate;
    }
}