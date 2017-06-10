/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class ConsumerThread extends Thread {

    Ringpuffer consumer;
    int sleepTime = 2000;

    ConsumerThread(Ringpuffer newConsumer) {
        super();
        this.consumer = newConsumer;
    }

    ConsumerThread(Ringpuffer newConsumer, int sleepTime) {
        this(newConsumer);
        this.sleepTime = sleepTime;
    }

    /**
     * consumes, then sleeps X milliseconds, then repeat. X by default is 2000.
     */
    @Override
    public void run() {
        while (!TimerThread.timeIsOver()) {
            consume();
            try {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Ich, " + this + ", bin fertig.");
        consumer.wakeEverybodyUp();
    }

    /**
     * Tries to get an element from 'Ringpuffer' and prints it on the console.
     */
    public synchronized void consume() {
        Object temp = consumer.get();
        if (temp != null) {
        String toBePrinted = "Ich, " + this + ", nehme das Element " + temp + " aus dem Ringpuffer.";
        System.out.println(toBePrinted);
        }
        notifyAll();
        consumer.wakeEverybodyUp();
    }
}
