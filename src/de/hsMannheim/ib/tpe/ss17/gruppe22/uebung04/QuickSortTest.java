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
    public void testDivideA() {
        System.out.println("divide");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35};
        int lowerBorder = 0;
        int upperBorder = 4;
        QuickSort instance = new QuickSortSeq();
        int expResult = 3;
        int result = instance.divide(array, lowerBorder, upperBorder);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class QuickSort.
     */
    @Test
    public void testDivideB() {
        System.out.println("divide");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35};
        int lowerBorder = 0;
        int upperBorder = 4;
        QuickSort instance = new QuickSortPar(array, 0, 4);
        int expResult = 3;
        int result = instance.divide(array, lowerBorder, upperBorder);
        assertEquals(expResult, result);
    }
        /**
     * Test of divide method, of class QuickSort.
     */
    @Test
    public void testDivideC() {
        System.out.println("divide");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35, 5, 17, 12};
        int lowerBorder = 0;
        int upperBorder = 4;
        QuickSort instance = new QuickSortPar(array, 0, 4);
        int expResult = 3;
        int result = instance.divide(array, lowerBorder, upperBorder);
        assertEquals(expResult, result);
    }

    /**
     * Test of quickSort method, of class QuickSort.
     */
    @Test
    public void testQuickSortA() {
        System.out.println("quickSort");
        Comparable[] array = new Integer[]{20, -2, -1};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20};
        QuickSort instance = new QuickSortSeq();
        instance.quickSort(array, 0, 2);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }



    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSortSeq1A() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, -2, -1};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20};
        QuickSort instance = new QuickSortSeq();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    @Test
    public void testSortPar1A() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, -2, -1};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20};
        QuickSort instance = new QuickSortPar(array, 0, 2);
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
        QuickSort instance = new QuickSortSeq();
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
        QuickSort instance = new QuickSortSeq();
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
        QuickSort instance = new QuickSortSeq();
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
        QuickSort instance = new QuickSortSeq();
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
        QuickSort instance = new QuickSortSeq();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort. Comparison to testSort4A: 1 has
     * been replaced by -1.
     */
    @Test
    public void testSort4AA() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35};
        Comparable[] expectedArray = new Integer[]{-1, 2, 20, 35, 40};
        QuickSort instance = new QuickSortSeq();
        instance.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSort. Comparison to testSort4AA: 2 has
     * been replaced by -2.
     */
    @Test
    public void testSort4AAA() {
        System.out.println("sort");
        Comparable[] array = new Integer[]{20, -2, -1, 40, 35};
        Comparable[] expectedArray = new Integer[]{-2, -1, 20, 35, 40};
        QuickSort instance = new QuickSortSeq();
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
        QuickSort instance = new QuickSortSeq();
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

}
