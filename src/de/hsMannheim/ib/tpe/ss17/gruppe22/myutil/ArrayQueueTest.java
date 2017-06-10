/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.myutil;

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
public class ArrayQueueTest {

    public ArrayQueueTest() {
    }

    /**
     * Test of getFront method, of class ArrayQueue.
     */
    @Test
    public void testGetFront() {
        System.out.println("getFront");
        ArrayQueue instance = new ArrayQueue();
        int expResult = 0;
        int result = instance.getFront();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnd method, of class ArrayQueue.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        ArrayQueue instance = new ArrayQueue();
        int expResult = 0;
        int result = instance.getEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class ArrayQueue.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ArrayQueue instance = new ArrayQueue();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enter method, of class ArrayQueue.
     */
    @Test
    public void testEnterAndLeaveA() {
        System.out.println("enter");
        ArrayQueue instance = new ArrayQueue(5, false);
        instance.enter(5);
        instance.enter(7);
        instance.enter(8);
        instance.enter(9);
        assertEquals(5, instance.leave());
        assertEquals(7, instance.leave());
        assertEquals(8, instance.leave());
        assertEquals(9, instance.leave());
        assertEquals(null, instance.leave());
    }

    /**
     * Test of leave method, of class ArrayQueue.
     */
    @Test
    public void testLeave() {
        System.out.println("leave");
        ArrayQueue instance = new ArrayQueue();
        Object expResult = null;
        Object result = instance.leave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peak method, of class ArrayQueue.
     */
    @Test
    public void testPeak() {
        System.out.println("peak");
        ArrayQueue instance = new ArrayQueue();
        Object expResult = null;
        Object result = instance.peak();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ArrayQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayQueue instance = new ArrayQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFull method, of class ArrayQueue.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        ArrayQueue instance = new ArrayQueue();
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class ArrayQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayQueue instance = new ArrayQueue();
        instance.enter(1);
        instance.enter(2);
        instance.enter(3);
        instance.enter(4);
        instance.enter(5);
        instance.enter(6);
        assertEquals(6, instance.size());
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        assertEquals(0, instance.size());
        instance.leave();
        assertEquals(0, instance.size());
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        instance.leave();
        assertEquals(0, instance.size());
        instance.enter(2);
        assertEquals(1, instance.size());
    }

}
