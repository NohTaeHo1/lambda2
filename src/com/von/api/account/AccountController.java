package com.von.api.account;


import com.von.api.enums.Messenger;

import java.util.Scanner;

public class AccountController {
    AccountServiceImpl as;

    public AccountController() {
        this.as  = AccountServiceImpl.getInstance();
    }

    public Messenger save(Scanner sc) {
        return as.save(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()
        );
    }

    public String deposit(Scanner sc) {
        return as.deposit(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()
        );

    }

    public String withdraw(Scanner sc) {
        return as.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()
        );
    }

    public String getBalance(Scanner sc) {
        return as.getBalance(sc.next());

    }

    public String deleteAccount(Scanner sc) {
        return as.delete(Account.builder().accountNumber(sc.next()).build());
    }
}