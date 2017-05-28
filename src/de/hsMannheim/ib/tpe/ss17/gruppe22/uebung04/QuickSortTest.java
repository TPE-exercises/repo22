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
 * Tests the methods of the class QuickSort.
 */
public class QuickSortTest {

    public QuickSortTest() {
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
     * Test of divide method, of class QuickSort.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Comparable[] array = null;
        int lowerBorder = 0;
        int upperBorder = 0;
        QuickSort instance = new QuickSort();
        int expResult = 0;
        int result = instance.divide(array, lowerBorder, upperBorder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

//    /**
//     * Test of printArray method, of class QuickSort.
//     * This method, on the 29th of May, 2017, does not require testing as it is a sole print-method.
//     */
//    @Test
//    public void testPrintArray() { 
//    }
    /**
     * Test of quickSort method, of class QuickSort.
     */
    @Test
    public void testQuickSort() {
        System.out.println("quickSort");
        Comparable[] array = null;
        int lowerBorder = 0;
        int upperBorder = 0;
        QuickSort instance = new QuickSort();
        instance.quickSort(array, lowerBorder, upperBorder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSort1A() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, -2, -1};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSort1B() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{-1, -2, 20};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSort1C() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{-1, 20, -2};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort. Contains only positive numbers.
     */
    @Test
    public void testSort2() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, 16, 30, 12, 5, 80, 45, 1, 48, 75, 46, 78, 95, 125, 100, 99};
        Comparable[] expectedArray = new Integer[]{1, 5, 12, 16, 20, 30, 45, 46, 48, 75, 78, 80, 95, 99, 100, 125};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSort3() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, -2, -1, 40};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20, 40};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSort4A() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, 2, 1, 40, 35};
        Comparable[] expectedArray = new Integer[]{1, 2, 20, 35, 40};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort.
     * 1 has been replaced by -1.
     */
    @Test
    public void testSort4AA() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35};
        Comparable[] expectedArray = new Integer[]{-1, 2, 20, 35, 40};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }
    /**
     * Test of sort method, of class QuickSort.
     * 2 has been replaced by -2.
     */
    @Test
    public void testSort4AAA() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, -2, -1, 40, 35};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20, 35, 40};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }
        /**
     * Test of sort method, of class QuickSort.
     * 2 has been replaced by -2.
     */
    @Test
    public void testSort4D() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, -2, -1, 40, 35};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20, 35, 40};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }
    /**
     * Test of swap method, of class QuickSort.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        // Index range is 0 to 8
        Comparable[] array = new Integer[]{5, 2, -270000, 0, 1, 16232, 1000000, -1, 10};
        QuickSort instance = new QuickSort();
        int expResult = (int) array[0];
        // Isn't this call by value? Why does it still work, then?
        instance.swap(array, 0, 2);
        assertEquals(expResult, array[2]);
        expResult = (int) array[2];
        instance.swap(array, 2, 7);
        assertEquals(expResult, array[7]);
        expResult = (int) array[8];
        instance.swap(array, 4, 8);
        assertEquals(expResult, array[4]);
        expResult = (int) array[7];
        instance.swap(array, 0, 7);
        assertEquals(expResult, array[0]);
        expResult = (int) array[8];
        instance.swap(array, 8, 7);
        assertEquals(expResult, array[7]);
        expResult = (int) array[8];
        instance.swap(array, 8, 8);
        assertEquals(expResult, array[8]);
        expResult = (int) array[1];
        instance.swap(array, 1, 3);
        assertEquals(expResult, array[3]);
        expResult = (int) array[4];
        instance.swap(array, 6, 4);
        assertEquals(expResult, array[6]);
        expResult = (int) array[8];
        instance.swap(array, 8, 3);
        assertEquals(expResult, array[3]);
        expResult = (int) array[7];
        instance.swap(array, 2, 7);
        assertEquals(expResult, array[2]);
        expResult = (int) array[6];
        instance.swap(array, 6, 5);
        assertEquals(expResult, array[5]);
    }

    /**
     * Test of main method, of class QuickSort.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        QuickSort.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
