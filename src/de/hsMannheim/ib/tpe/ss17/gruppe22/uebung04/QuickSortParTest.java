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
public class QuickSortParTest {

    public QuickSortParTest() {
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
     * Test of quickSort method, of class QuickSortPar.
     */
    @Test
    public void testQuickSortParA() {
        System.out.println("quickSort");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35};
        Comparable[] expectedArray = new Integer[]{-1, 2, 20, 35, 40};
        int lowerBorder = 0;
        int upperBorder = 4;
        QuickSortPar instance = new QuickSortPar(array, lowerBorder, upperBorder);
        instance.quickSort(array, lowerBorder, upperBorder);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }
       /**
     * Test of quickSort method, of class QuickSortPar.
     */
    @Test
    public void testQuickSortParB() {
        System.out.println("quickSort");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35, -2};
        Comparable[] expectedArray = new Integer[]{-2, -1, 2, 20, 35, 40};
        int lowerBorder = 0;
        int upperBorder = 5;
        QuickSortPar instance = new QuickSortPar(array, lowerBorder, upperBorder);
        instance.quickSort(array, lowerBorder, upperBorder);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    /**
     * Test of sort method, of class QuickSortPar.
     */
    @Test
    public void testSort() {
        System.out.println("quickSort");
        Comparable[] array = new Integer[]{20, 2, -1, 40, 35, -2, 120000, -42, 0};
        Comparable[] expectedArray = new Integer[]{-42, -2, -1, 0, 2, 20, 35, 40, 120000};
        int lowerBorder = 0;
        int upperBorder = 8;
        QuickSortPar instance = new QuickSortPar(array, lowerBorder, upperBorder);
        instance.quickSort(array, lowerBorder, upperBorder);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

}
