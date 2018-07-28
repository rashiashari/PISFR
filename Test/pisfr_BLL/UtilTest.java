/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_BLL;

import java.awt.image.BufferedImage;
import org.bytedeco.javacpp.opencv_core;
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
public class UtilTest {
    
    public UtilTest() {
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
     * Test of ipltoBuffered method, of class Util.
     */
    @Test
    public void testIpltoBuffered() {
        System.out.println("ipltoBuffered");
        opencv_core.IplImage src = null;
        Util instance = new Util();
        BufferedImage expResult = null;
        BufferedImage result = instance.ipltoBuffered(src);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bufferedtoIpl method, of class Util.
     */
    @Test
    public void testBufferedtoIpl() {
        System.out.println("bufferedtoIpl");
        BufferedImage bufImage = null;
        Util instance = new Util();
        opencv_core.IplImage expResult = null;
        opencv_core.IplImage result = instance.bufferedtoIpl(bufImage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resizeImage method, of class Util.
     */
    @Test
    public void testResizeImage_3args_1() {
        System.out.println("resizeImage");
        opencv_core.IplImage src = null;
        int height = 0;
        int width = 0;
        Util instance = new Util();
        BufferedImage expResult = null;
        BufferedImage result = instance.resizeImage(src, height, width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resizeImage method, of class Util.
     */
    @Test
    public void testResizeImage_3args_2() {
        System.out.println("resizeImage");
        BufferedImage src = null;
        int height = 0;
        int width = 0;
        Util instance = new Util();
        BufferedImage expResult = null;
        BufferedImage result = instance.resizeImage(src, height, width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
