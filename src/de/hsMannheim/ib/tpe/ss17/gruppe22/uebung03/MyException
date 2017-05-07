package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;

public class MyException extends Exception {
    private int reason;
    public int getReason() {
        return reason;
    }
    MyException() {
        this.reason = 0;
    }
    MyException(int val) {
        this.reason = val;
    }
    MyException(String s, int val) {
        super(s);
        this.reason = val;
    }
    public void printInfo() {
        System.out.println("Bei Wert " + this.reason + " tritt ein Fehler auf.");
    }
}
