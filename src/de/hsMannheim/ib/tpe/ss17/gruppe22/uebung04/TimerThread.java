/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class TimerThread extends Thread {

    public static double time = 1;
    private static TimerThread timer = new TimerThread(time);

    private TimerThread(double countTime) {
        super();
        this.time = countTime;
    }

    public static TimerThread getInstance() {
        return timer;
    }

    /**
     * Sets the amount of time to be count down in minutes.
     *
     * @param amountOfTime the amount of time to be set (in minutes)
     */
    public static void setTime(double amountOfTime) {
        time = amountOfTime * 1000 * 60;
    }

    /**
     * Checks whether the time is over.
     *
     * @return true if time is over, otherwise false.
     */
    public static boolean timeIsOver() {
        return (time <= 0);
    }

    @Override
    public void run() {
        countDown();
        synchronized (this) {
            notifyAll();
        }
    }

    /**
     * Counts the time down all the way to 0.
     */
    public static void countDown() {
        try {
            sleep((long) time);
            time = time - time;
        } catch (InterruptedException ex) {
            Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
