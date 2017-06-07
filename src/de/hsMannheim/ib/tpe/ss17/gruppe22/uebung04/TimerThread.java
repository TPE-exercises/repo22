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

    public static double time;
    private static TimerThread thisTimer = new TimerThread(0);

    private TimerThread(double countTime) {
        this.time = countTime;
    }

    /**
     * Sets the amount of time to be count down in minutes.
     *
     * @param amountOfTime the amount of time to be set (in minutes)
     */
    public static void setTime(double amountOfTime) {
        thisTimer = new TimerThread(amountOfTime * 1000 * 60);
    }

    public static boolean timeIsOver() {
        return (time <= 0);
    }

    public void run() {

    }

    /**
     * Counts the time down all the way to 0.
     */
    public void countDown() {
        /**
         * Sets the duration this thread shall last.
         */
        try {
            join((long) time);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Counts down in millisecond steps.
         */
        while (time > 0) {
            time = time - 1;
            try {
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        synchronized (this) {
            notifyAll();
        }
    }
}
