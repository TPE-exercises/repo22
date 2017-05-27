/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class DepositorThread extends BankAccountThread {

    public DepositorThread() {
        super();
    }

    public DepositorThread(int newAmount) {
        this();
        this.amount = newAmount;
    }

    /**
     * Deposits money on this BankAccount.
     *
     * @param money The amount of money to be deposited.
     */
    public void deposit(int money) {

        this.myBankAccount.deposit(money);
    }

    @Override
    public void run() {
        try {
            sleep((int) Math.random() * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WithdrawerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        deposit(amount);
    }
}
