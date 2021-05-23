/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import database.Conexiones;
import java.sql.Connection;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;


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
        
    }
}
