/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisfr_DL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Rashini_Ashari
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({pisfr_DL.AdminDataBaseIT.class, pisfr_DL.DoctorsIT.class, pisfr_DL.AdminIT.class, pisfr_DL.DBIT.class, pisfr_DL.DoctorDataBaseIT.class})
public class Pisfr_DLITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
