package de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions;

/**
 *
 * @author Marco
 */
public class MyException extends RuntimeException {
    private int reason;
    public int getReason() {
        return reason;
    }
    public MyException() {
        this.reason = 0;
    }
    public MyException(int val) {
        this.reason = val;
    }
    public MyException(String s, int val) {
        super(s);
        this.reason = val;
    }
    public void printInfo() {
        System.out.println("Bei Wert " + this.reason + " tritt ein Fehler auf.");
    }
}
