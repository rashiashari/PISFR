/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_BLL;

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
public class NeuralNetworIT {
    
    public NeuralNetworIT() {
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
     * Test of createTrainingset method, of class NeuralNetwor.
     */
    @Test
    public void testCreateTrainingset() {
        System.out.println("createTrainingset");
        int outputSize = 0;
        NeuralNetwor instance = new NeuralNetwor();
        instance.createTrainingset(outputSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trainNetwork method, of class NeuralNetwor.
     */
    @Test
    public void testTrainNetwork() {
        System.out.println("trainNetwork");
        int outputSize = 0;
        int hidden = 0;
        double lrate = 0.0;
        double momentum = 0.0;
        String[] expResult = null;
        String[] result = NeuralNetwor.trainNetwork(outputSize, hidden, lrate, momentum);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recognizeFaces method, of class NeuralNetwor.
     */
    @Test
    public void testRecognizeFaces() {
        System.out.println("recognizeFaces");
        double[] testImage = null;
        int outputsize = 0;
        NeuralNetwor instance = new NeuralNetwor();
        int expResult = 0;
        int result = instance.recognizeFaces(testImage, outputsize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testingFaces method, of class NeuralNetwor.
     */
    @Test
    public void testTestingFaces() {
        System.out.println("testingFaces");
        double[] testImage = null;
        int outputsize = 0;
        NeuralNetwor instance = new NeuralNetwor();
        int expResult = 0;
        int result = instance.testingFaces(testImage, outputsize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class NeuralNetwor.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        NeuralNetwor.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
