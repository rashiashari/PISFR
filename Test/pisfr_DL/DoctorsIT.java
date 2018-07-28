/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_DL;

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
public class DoctorsIT {
    
    public DoctorsIT() {
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
     * Test of getName method, of class Doctors.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Doctors instance = new Doctors();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Doctors.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Doctors instance = new Doctors();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getField method, of class Doctors.
     */
    @Test
    public void testGetField() {
        System.out.println("getField");
        Doctors instance = new Doctors();
        String expResult = "";
        String result = instance.getField();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setField method, of class Doctors.
     */
    @Test
    public void testSetField() {
        System.out.println("setField");
        String field = "";
        Doctors instance = new Doctors();
        instance.setField(field);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChanellingdays method, of class Doctors.
     */
    @Test
    public void testGetChanellingdays() {
        System.out.println("getChanellingdays");
        Doctors instance = new Doctors();
        String expResult = "";
        String result = instance.getChanellingdays();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChanellingdays method, of class Doctors.
     */
    @Test
    public void testSetChanellingdays() {
        System.out.println("setChanellingdays");
        String chanellingdays = "";
        Doctors instance = new Doctors();
        instance.setChanellingdays(chanellingdays);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMobile method, of class Doctors.
     */
    @Test
    public void testGetMobile() {
        System.out.println("getMobile");
        Doctors instance = new Doctors();
        int expResult = 0;
        int result = instance.getMobile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMobile method, of class Doctors.
     */
    @Test
    public void testSetMobile() {
        System.out.println("setMobile");
        int mobile = 0;
        Doctors instance = new Doctors();
        instance.setMobile(mobile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocid method, of class Doctors.
     */
    @Test
    public void testGetDocid() {
        System.out.println("getDocid");
        Doctors instance = new Doctors();
        String expResult = "";
        String result = instance.getDocid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDocid method, of class Doctors.
     */
    @Test
    public void testSetDocid() {
        System.out.println("setDocid");
        String docid = "";
        Doctors instance = new Doctors();
        instance.setDocid(docid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImg1 method, of class Doctors.
     */
    @Test
    public void testGetImg1() {
        System.out.println("getImg1");
        Doctors instance = new Doctors();
        BufferedImage expResult = null;
        BufferedImage result = instance.getImg1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImg1 method, of class Doctors.
     */
    @Test
    public void testSetImg1() {
        System.out.println("setImg1");
        BufferedImage img1 = null;
        Doctors instance = new Doctors();
        instance.setImg1(img1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImg2 method, of class Doctors.
     */
    @Test
    public void testGetImg2() {
        System.out.println("getImg2");
        Doctors instance = new Doctors();
        BufferedImage expResult = null;
        BufferedImage result = instance.getImg2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImg2 method, of class Doctors.
     */
    @Test
    public void testSetImg2() {
        System.out.println("setImg2");
        BufferedImage img2 = null;
        Doctors instance = new Doctors();
        instance.setImg2(img2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImg3 method, of class Doctors.
     */
    @Test
    public void testGetImg3() {
        System.out.println("getImg3");
        Doctors instance = new Doctors();
        BufferedImage expResult = null;
        BufferedImage result = instance.getImg3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImg3 method, of class Doctors.
     */
    @Test
    public void testSetImg3() {
        System.out.println("setImg3");
        BufferedImage img3 = null;
        Doctors instance = new Doctors();
        instance.setImg3(img3);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Doctors.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Doctors instance = new Doctors();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class Doctors.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 0;
        Doctors instance = new Doctors();
        instance.setID(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecretCode method, of class Doctors.
     */
    @Test
    public void testGetSecretCode() {
        System.out.println("getSecretCode");
        Doctors instance = new Doctors();
        int expResult = 0;
        int result = instance.getSecretCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecretCode method, of class Doctors.
     */
    @Test
    public void testSetSecretCode() {
        System.out.println("setSecretCode");
        int secretcode = 0;
        Doctors instance = new Doctors();
        instance.setSecretCode(secretcode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
