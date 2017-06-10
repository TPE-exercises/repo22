/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class ProducerThread extends Thread {

    Ringpuffer producer;
    int sleepTime = 5000;

    ProducerThread(Ringpuffer newProducer) {
        super();
        this.producer = newProducer;
    }

    ProducerThread(Ringpuffer newProducer, int sleepTime) {
        this(newProducer);
        this.sleepTime = sleepTime;
    }

    /**
     * produces, then sleeps X milliseconds, then repeat. X by default is 5000.
     */
    @Override
    public void run() {
        while (!TimerThread.timeIsOver()) {
            produce();
            try {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        producer.wakeEverybodyUp();
        System.out.println("Ich, " + this + ", bin fertig.");
    }

    /**
     * Tries to get an element from 'Ringpuffer' and prints it on the console.
     */
    public synchronized void produce() {
        Object random = new Random();
                

        
        Object product = (int) (Math.random() * 200);
        producer.put(product);
        String toBePrinted = "Ich, " + this + ", füge die Zahl " + product + " ein.";
        System.out.println(toBePrinted);
        notifyAll();
        producer.wakeEverybodyUp();
    }
}
