/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.Queue;
import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.ArrayQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Ringpuffer {

    public static Queue ringpuffer;

    Ringpuffer(int length) {
        this.ringpuffer = new ArrayQueue(length, false);
    }

    /**
     * Puts an element into the ring cache.
     *
     * @param o the element to be put
     */
    public void put(Object o) {

        boolean elementHasBeenPut = false;

        while (!elementHasBeenPut) {
            synchronized (this) {
                if (!ringpuffer.isFull()) {
                    ringpuffer.enter(o);
                    elementHasBeenPut = true;
                    notifyAll();
                } else {
                    try {
                        System.out.println("Warte bis Platz zum Ablegen bereit ist.");
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ringpuffer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    /**
     * Gets the first element in the ring cache.
     *
     * @return the element to be got
     */
    public Object get() {
        boolean elementHasBeenGot = false;
        while (!elementHasBeenGot) {
            synchronized (this) {
                if (!ringpuffer.isEmpty()) {
                    //elementHasBeenGot = true; //Not needed because of return statement.
                    notifyAll();
                    return ringpuffer.leave();
                } else {
                    try {
                        System.out.println("Warte bis sich ein Element im Ringpuffer befindet.");
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ringpuffer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }
        return null;
    }
}
