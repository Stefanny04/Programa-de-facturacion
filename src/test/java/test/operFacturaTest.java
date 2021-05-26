/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.Inventario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import logica.OperFactura;
/**
 *
 * @author Stefanny
 */
public class operFacturaTest {
    
    public operFacturaTest() {
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

    @Test
    public void testLlevarInventarioNull(){
        OperFactura oper = new OperFactura();
        Inventario rta = oper.llevarInventario(null);
        assertEquals(0, rta);
    }
    /*public void testLlevarInventarioOK() {
        OperFactura oper = new OperFactura();
        Inventario in = new Inventario();
        in.setExistencias(1);
        in.getProducto().setCodigo("2365");
        in.getProducto().setNombreP("bebida Mr. tea durazno");
        in.getProducto().setValorUnit(2100L);
        Inventario rta = oper.llevarInventario("");
        assertEquals("", "", 0L);
        
    }*/
    
}
