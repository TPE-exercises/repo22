/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung04;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class TimerThreadTest {

    public TimerThreadTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setTime method, of class TimerThread.
     */
    @Test
    public void testSetTimeA() {
        System.out.println("setTime");
        double amountOfTime = 2.5;
        TimerThread.setTime(amountOfTime);
        assertEquals(2.5 * 1000 * 60, TimerThread.time, 0);
    }

    /**
     * Test of setTime method, of class TimerThread.
     */
    @Test
    public void testSetTimeB() {
        System.out.println("setTime");
        double amountOfTime = 2000;
        TimerThread.setTime(amountOfTime);
        assertEquals(2000 * 1000 * 60, TimerThread.time, 0);
    }

    /**
     * Test of setTime method, of class TimerThread.
     */
    @Test
    public void testSetTimeC() {
        System.out.println("setTime");
        double amountOfTime = -1.0;
        TimerThread.setTime(amountOfTime);
        assertEquals(-1.0 * 1000 * 60, TimerThread.time, 0);
    }

    /**
     * Test of setTime method, of class TimerThread.
     */
    @Test
    public void testSetTimeD() {
        System.out.println("setTime");
        double amountOfTime = 0.0;
        TimerThread.setTime(amountOfTime);
        assertEquals(0.0, TimerThread.time, 0);
    }

    /**
     * Test of timeIsOver method, of class TimerThread.
     */
    @Test
    public void testTimeIsOverA() {
        System.out.println("timeIsOver");
        TimerThread.countDown();
        boolean result = TimerThread.timeIsOver();
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of timeIsOver method, of class TimerThread.
     */
    @Test
    public void testTimeIsOverB() {
        System.out.println("timeIsOver");
        TimerThread.countDown();
        boolean result = TimerThread.timeIsOver();
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
    }



    /**
     * Test of countDown method, of class TimerThread.
     */
    @Test
    public void testCountDownA() {
        System.out.println("countDown");
        TimerThread.countDown();
        boolean zeroOrSmaller = (TimerThread.time <= 0);
        assertEquals(true, zeroOrSmaller);
    }
    /**
     * Test of countDown method, of class TimerThread.
     */
    @Test
    public void testCountDownB() {
        TimerThread.setTime(0.5);
        System.out.println("countDown");
        TimerThread.countDown();
        boolean zeroOrSmaller = (TimerThread.time <= 0);
        assertEquals(true, zeroOrSmaller);
    }

}
