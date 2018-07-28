/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import images.ImagesITSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pisfr_BLL.Pisfr_BLLITSuite;
import pisfr_DL.Pisfr_DLITSuite;
import pisfr_UI.Pisfr_UIITSuite;

/**
 *
 * @author Rashini_Ashari
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ImagesITSuite.class, Pisfr_UIITSuite.class, Pisfr_BLLITSuite.class, Pisfr_DLITSuite.class})
public class RootSuite {

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
