package com.von.api.account;
import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {
        com.von.api.account.AccountController ac = new com.von.api.account.AccountController();

        while (true) {
            System.out.println("[Menu]\n" +
                    "0-EXIT\n" +
                    "1-Create Account\n" +
                    "2-Deposit\n" +
                    "3-Withdraw\n" +
                    "4-Balance\n" +
                    "5-Cancel Account\n"+
                    "6-Account List");

            switch (sc.next()) {
                case "0":
                    System.out.println("========EXIT=========");
                    return;
                case "1":
                    System.out.println("========Create Account=========");
                    System.out.println(ac.save(sc));
                    break;
                case "2":
                    System.out.println("========Deposit=========");
                    System.out.println(ac.deposit(sc));
                    break;
                case "3":
                    System.out.println("========Withdraw=========");
                    System.out.println(ac.withdraw(sc));
                    break;
                case "4":
                    System.out.println("========Balance=========");
                    String temp = ac.getBalance(sc);
                    break;
                case "5":
                    System.out.println("========Cancel Account=========");
                    System.out.println(ac.deleteAccount(sc));
                    break;
            }
        }
    }


}