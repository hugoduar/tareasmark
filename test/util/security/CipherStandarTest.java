/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.security;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class CipherStandarTest {
    
    public CipherStandarTest() {
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
     * Test of encrypt method, of class CipherStandar.
     */
    @Test
    public void testEncrypt() throws Exception {
        System.out.println("encrypt");
        String unencryptedString = "securepassword";
        CipherStandar instance = new CipherStandar();
        String expResult = "CE6A4ADB795496FAD58055F30BBED4B8";
        String result = instance.encrypt("fibonacci",unencryptedString);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of decrypt method, of class CipherStandar.
     */
    @Test
    public void testDecrypt() throws Exception {
        System.out.println("decrypt");
        String encryptedString = "CE6A4ADB795496FAD58055F30BBED4B8";
        CipherStandar instance = new CipherStandar();
        String expResult = "securepassword";
        String result = instance.decrypt("fibonacci",encryptedString);
        assertEquals(expResult, result);
    }
}
