/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_BLL;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rashini_Ashari
 */
public class PreProcessingTest {
    
    public PreProcessingTest() {
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
     * Test of converttoGray method, of class PreProcessing.
     */
    @Test
    public void testConverttoGray() {
        System.out.println("converttoGray");
        BufferedImage img = null;
        PreProcessing instance = new PreProcessing();
        BufferedImage expResult = null;
        BufferedImage result = instance.converttoGray(img);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of converttoGray3 method, of class PreProcessing.
     */
    @Test
    public void testConverttoGray3() {
        System.out.println("converttoGray3");
        BufferedImage img = null;
        PreProcessing instance = new PreProcessing();
        BufferedImage expResult = null;
        BufferedImage result = instance.converttoGray3(img);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of histogramEqualization method, of class PreProcessing.
     */
    @Test
    public void testHistogramEqualization() {
        System.out.println("histogramEqualization");
        BufferedImage img = null;
        PreProcessing instance = new PreProcessing();
        BufferedImage expResult = null;
        BufferedImage result = instance.histogramEqualization(img);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
