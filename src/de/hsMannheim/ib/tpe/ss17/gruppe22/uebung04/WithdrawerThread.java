/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class WithdrawerThread extends BankAccountThread {
    public WithdrawerThread() {
        super();
    }
    public WithdrawerThread(int newAmount) {
        this();
        this.amount = newAmount;
    }
    /**
     * Sleeps a random time and then withdraws money from this bank account.
     * @param money The amount of money to be withdrawn.
     */
    public void withdraw(int money) {
        try {
            sleep((int) Math.random()*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WithdrawerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.myBankAccount.withdraw(money);
    }
    @Override
    public void run() {
        withdraw(amount);
    }
}