/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_DL;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
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
public class DoctorDataBaseIT {
    
    public DoctorDataBaseIT() {
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
     * Test of addDoctors method, of class DoctorDataBase.
     */
    @Test
    public void testAddDoctors() {
        System.out.println("addDoctors");
        Doctors obj = null;
        DoctorDataBase instance = new DoctorDataBase();
        int expResult = 0;
        int result = instance.addDoctors(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetails method, of class DoctorDataBase.
     */
    @Test
    public void testGetDetails() {
        System.out.println("getDetails");
        Doctors obj = null;
        DoctorDataBase instance = new DoctorDataBase();
        ResultSet expResult = null;
        ResultSet result = instance.getDetails(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocdetails method, of class DoctorDataBase.
     */
    @Test
    public void testGetDocdetails() {
        System.out.println("getDocdetails");
        Doctors obj = null;
        DoctorDataBase instance = new DoctorDataBase();
        ResultSet expResult = null;
        ResultSet result = instance.getDocdetails(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlldetails method, of class DoctorDataBase.
     */
    @Test
    public void testGetAlldetails() {
        System.out.println("getAlldetails");
        DoctorDataBase instance = new DoctorDataBase();
        ResultSet expResult = null;
        ResultSet result = instance.getAlldetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doctorTable method, of class DoctorDataBase.
     */
    @Test
    public void testDoctorTable() {
        System.out.println("doctorTable");
        DoctorDataBase instance = new DoctorDataBase();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.doctorTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of docdetailsTable method, of class DoctorDataBase.
     */
    @Test
    public void testDocdetailsTable() {
        System.out.println("docdetailsTable");
        DoctorDataBase instance = new DoctorDataBase();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.docdetailsTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDoctors method, of class DoctorDataBase.
     */
    @Test
    public void testUpdateDoctors() {
        System.out.println("updateDoctors");
        Doctors obj = null;
        DoctorDataBase instance = new DoctorDataBase();
        int expResult = 0;
        int result = instance.updateDoctors(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
