
package test;


import database.Conexiones;
import java.sql.Connection;
import org.junit.Assert;
import org.junit.Test;

public class pruebaConexion {
    
    public pruebaConexion() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testpruebaConexion() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        Assert.assertNotNull(cActiva);
    }
}
