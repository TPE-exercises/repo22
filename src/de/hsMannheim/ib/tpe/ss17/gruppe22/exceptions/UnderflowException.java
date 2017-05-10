/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions;

/**
 *
 * @author Marco
 */
public class UnderflowException extends RuntimeException {
    private int reason;
    public UnderflowException() {
        this.reason = 0;
    }
    public UnderflowException(int value) {
        this.reason = value;
    }
    public void printInfo() {
        System.out.println("Es tritt ein Underflow bei Wert " + this.reason + " auf.");
    }
}
