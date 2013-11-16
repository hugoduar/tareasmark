/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operations.publicacion;

import com.mongodb.DB;
import com.mongodb.WriteResult;
import java.sql.ResultSet;
import model.publicacion.Publicacion;
import model.publicacion.PublicacionFisica;
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
public class StorePublicacionTest {
    
    public StorePublicacionTest() {
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
     * Test of savePublicacionFisica method, of class StorePublicacion.
     */
    @Test
    public void testSavePublicacionFisica() throws Exception {
        System.out.println("savePublicacionFisica");
        PublicacionFisica pub = new PublicacionFisica("foo", "foo", "foo", "foo", 2, 3);
        StorePublicacion instance = new StorePublicacion();
        boolean result = instance.savePublicacionFisica(pub); 
        result = instance.savePublicacionFisica(pub);
        assertEquals(true, result);
    }
}
