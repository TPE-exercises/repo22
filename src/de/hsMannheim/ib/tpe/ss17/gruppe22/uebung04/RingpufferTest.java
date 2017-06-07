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
public class RingpufferTest {

    public RingpufferTest() {
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
     * Test of put and get method, of class Ringpuffer.
     */
    @Test
    public void testPutAndGetA() {
        System.out.println("put and get");
        Object o = new Integer(5);
        Object p = new Integer(7);
        Object q = new Integer(9);
        Ringpuffer instance = new Ringpuffer(3);
        instance.put(o);
        instance.put(p);
        instance.put(q);
        assertEquals(5, instance.get());
        assertEquals(7, instance.get());
        assertEquals(9, instance.get());
    }

    /**
     * Test of put and get method, of class Ringpuffer.
     */
    @Test
    public void testPutAndGetB() {
        System.out.println("put and get");
        Object o = new Integer(5);
        Object p = new Integer(7);
        Object q = new Integer(9);
        Object r = new Integer(11);
        Ringpuffer instance = new Ringpuffer(4);
        instance.put(o);
        instance.put(p);
        instance.put(q);
        instance.put(r);
        assertEquals(5, instance.get());
        assertEquals(7, instance.get());
        assertEquals(9, instance.get());
        assertEquals(11, instance.get());
    }

    /**
     * Test of put and get method, of class Ringpuffer.
     */
    @Test
    public void testPutAndGetC() {
        System.out.println("put and get");
        Object o = new Integer(5);
        Object p = new Integer(7);
        Object q = new Integer(9);
        Object r = new Integer(11);
        Ringpuffer instance = new Ringpuffer(4);
        instance.put(o);
        instance.put(p);
        instance.put(q);
        instance.put(r);
        assertEquals(5, instance.get());
        assertEquals(7, instance.get());
        assertEquals(9, instance.get());
        assertEquals(11, instance.get());
    }

    /**
     * Tests whether ConsumerThread and Ringpuffer refer to exactly the same
     * cache.
     */
    @Test
    public void testConsume() {
        System.out.println("consume");
        Object o = new Integer(5);
        Object p = new Integer(7);
        Object q = new Integer(9);
        Object r = new Integer(11);
        Ringpuffer instance = new Ringpuffer(4);
        instance.put(o);
        instance.put(p);
        instance.put(q);
        instance.put(r);
        ConsumerThread malcolm = new ConsumerThread(instance);
        malcolm.consume();
        malcolm.consume();
        malcolm.consume();
        assertEquals(11, instance.get());
    }

}
