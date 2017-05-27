/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

/**
 * Creates a new bank account with a starting balance of 1000€.
 */
public class BankAccountThread extends Thread {
    public static BankAccount myBankAccount = BankAccount.createNewBankAccount(1000);
    public int amount = 0;
}
