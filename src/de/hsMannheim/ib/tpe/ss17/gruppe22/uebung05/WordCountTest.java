/*
 */
package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung05;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class WordCountTest {

    WordCount wordcountShakespeare;
    WordCount wordcountBibel;

    public WordCountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            wordcountShakespeare = new WordCount("C:\\Users\\Marco\\Desktop\\Hochschule Mannheim\\TPE\\Übung 5 - Collections\\shakespeare.txt");
            wordcountBibel = new WordCount("C:\\Users\\Marco\\Desktop\\Hochschule Mannheim\\TPE\\Übung 5 - Collections\\Bibel.txt");
        } catch (IOException ex) {
            Logger.getLogger(WordCountTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        wordcountShakespeare.closeReader();
        wordcountBibel.closeReader();
    }

    /**
     * Test of getTextLength method, of class WordCount.
     */
    @Test
    public void testGetTextLengthShakespeare() {
        System.out.println("getTextLength");
        BigInteger expResult = BigInteger.valueOf(1178962);
        BigInteger result = wordcountShakespeare.getTextLength();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTextLength method, of class WordCount.
     */
    @Test
    public void testGetTextLengthBible() {
        System.out.println("getTextLength");
        BigInteger expResult = BigInteger.valueOf(4286435);
        BigInteger result = wordcountBibel.getTextLength();
        assertEquals(expResult, result);
//        try {
//            wordcountBibel = new WordCount("C:\\Users\\Marco\\Desktop\\Hochschule Mannheim\\TPE\\Übung 5 - Collections\\Bibel.txt");
//            result = wordcountBibel.getTextLength();
//            assertEquals(expResult, result);
//        } catch (IOException ex) {
//            Logger.getLogger(WordCountTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @Test
    public void testForOverflow() {
        BigInteger testValue = BigInteger.valueOf(46968999);
        BigInteger testBibleValue = wordcountBibel.getTextLength();
        System.out.println("BigInteger testBibleValue: " + testBibleValue);
        BigInteger expResult = BigInteger.valueOf(46969000);
        testValue = testValue.add(BigInteger.valueOf(1));
        assertEquals(expResult, testValue);
        System.out.println("BigInteger testValue: " + testValue);
        testValue = testValue.add(BigInteger.valueOf(1));
        System.out.println("BigInteger testValue after adding 1: " + testValue);
        expResult = BigInteger.valueOf(46969001);
        assertEquals(expResult, testValue);        
    }
}
