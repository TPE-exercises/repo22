/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions;

/**
 *
 * @author Marco
 */
public class OverflowException extends RuntimeException {
        private int reason;
    public OverflowException() {
        this.reason = 0;
    }
    public OverflowException(int value) {
        this.reason = value;
    }
    public void printInfo() {
        System.out.println("Es tritt ein Overflow bei Wert " + this.reason + " auf.");
    }
}
