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
public class AdminDataBaseIT {
    
    public AdminDataBaseIT() {
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
     * Test of login method, of class AdminDataBase.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Admin obj = null;
        AdminDataBase instance = new AdminDataBase();
        ResultSet expResult = null;
        ResultSet result = instance.login(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class AdminDataBase.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        Admin obj = null;
        AdminDataBase instance = new AdminDataBase();
        int expResult = 0;
        int result = instance.addUser(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminTable method, of class AdminDataBase.
     */
    @Test
    public void testAdminTable() {
        System.out.println("adminTable");
        AdminDataBase instance = new AdminDataBase();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.adminTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlldetails method, of class AdminDataBase.
     */
    @Test
    public void testGetAlldetails() {
        System.out.println("getAlldetails");
        AdminDataBase instance = new AdminDataBase();
        ResultSet expResult = null;
        ResultSet result = instance.getAlldetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
