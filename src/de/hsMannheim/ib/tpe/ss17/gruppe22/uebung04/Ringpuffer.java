/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.Queue;
import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.ArrayQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
        synchronized (this) {
            while (!elementHasBeenPut && !TimerThread.timeIsOver()) {

                if (!ringpuffer.isFull()) {
                    ringpuffer.enter(o);
                    elementHasBeenPut = true;
                    notifyAll();
                } else {
                    try {
                        System.out.println("Ich warte bis Platz zum Ablegen bereit ist.");
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ringpuffer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void wakeEverybodyUp() {
        synchronized (this) {
            notifyAll();
        }
    }

    /**
     * Gets the first element in the ring cache.
     *
     * @return the element to be got
     */
    public Object get() {
        boolean elementHasBeenGot = false;
        synchronized (this) {
            while (!elementHasBeenGot && !TimerThread.timeIsOver()) {

                if (!ringpuffer.isEmpty()) {
                    elementHasBeenGot = true; //Not needed because of return statement.
                    notifyAll();
                    return ringpuffer.leave();
                } else {
                    try {
                        System.out.println("Ich warte bis sich ein Element im Ringpuffer befindet.");
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ringpuffer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("run 3 producer, 2 consumer, 1 timer");
        Ringpuffer instance = new Ringpuffer(7);
        ConsumerThread malcolm = new ConsumerThread(instance, 5000);
        ConsumerThread reese = new ConsumerThread(instance, 1600);
        ConsumerThread dewie = new ConsumerThread(instance);
        ProducerThread lois = new ProducerThread(instance, 400);
        ProducerThread hal = new ProducerThread(instance);
        TimerThread.setTime(1);
        TimerThread.getInstance().start();
        malcolm.start();
        reese.start();
        dewie.start();
        lois.start();
        hal.start();
        
        
    }
}
