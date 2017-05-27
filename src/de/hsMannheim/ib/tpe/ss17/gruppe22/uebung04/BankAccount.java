/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * The monitor class for the BankAccountThread.
 * @author Marco
 */
public class BankAccount {

    private int balance = 0;

    private BankAccount(int startBalance) {
        this.balance = startBalance;
    }

    public static BankAccount createNewBankAccount(int startBalance) {
        return new BankAccount(startBalance);
    }

    /**
     * Stores money on this bank account.
     *
     * @param money The amount of money to be stored.
     */
    public synchronized void deposit(int money) {

        this.balance += money;
        System.out.println("Es wurde " + money + "€ eingezahlt.");
        notifyAll();
    }

    /**
     * Withdraws money from this bank account.
     *
     * @param money The amount of money to be withdrawn.
     */
    public void withdraw(int money) {
        boolean isWithdrawalIncomplete = true;
        synchronized (this) {
            while (isWithdrawalIncomplete) {
                if (this.balance >= money) {
                    this.balance -= money;
                    System.out.println("Es wurde " + money + "€ abgehoben.");
                    isWithdrawalIncomplete = false;
                } else {
                    try {
                        System.out.println("Warte bis mehr Geld zur Verfügung steht.");                        
//                  // Example for a livelock if there are two or more withdrawers.
//                        notifyAll();
//                        System.out.println("Kann ein anderer Geld abheben?");
                        wait();
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    public static void main(String[]args) {
        // starting balance by default is 1000€
        BankAccountThread withdrawer = new WithdrawerThread(1200);
        withdrawer.start();
        BankAccountThread depositor = new DepositorThread(500);
        depositor.start();
        
    
//        BankAccountThread withdrawer2 = new WithdrawerThread(1200);
//        withdrawer2.start();
    }
}
