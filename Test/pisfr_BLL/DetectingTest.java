/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_BLL;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
public class DetectingTest {
    
    public DetectingTest() {
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
     * Test of detectFace method, of class Detecting.
     */
    @Test
    public void testDetectFace() throws IOException {
        System.out.println("detectFace");
        File file = new File("C:\\PISFC\\TestImg\\1_8.jpg");
        BufferedImage imgfile=ImageIO.read(file);
        Detecting instance = new Detecting();
        int expResult = 1;
        int x=0;
       
        BufferedImage result = instance.detectFace(imgfile);
        if(result!=null)
            x=1;
        assertEquals(expResult, x);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
