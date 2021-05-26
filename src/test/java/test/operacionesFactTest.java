
package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Operaciones.operacionesFactura;

/**
 *
 * @author Stefanny
 */
public class operacionesFactTest {
    
    public operacionesFactTest() {
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
    public void testCantidadOk() {
        operacionesFactura oper = new operacionesFactura();
        assertEquals(0, oper.cantidad(1, 1));
    }
    
    @Test
    public void testCantidadCantMayor(){
        operacionesFactura oper = new operacionesFactura();
        assertEquals(0, oper.cantidad(8, 1));
    }
    
    @Test
    public void testCantidadCantNegativa(){
        operacionesFactura oper = new operacionesFactura();
        assertEquals(0, oper.cantidad(-8, 1));
    }
    
    @Test
    public void testCantidadCantCero(){
        operacionesFactura oper = new operacionesFactura();
        assertEquals(0, oper.cantidad(0, 1));
    }
    
    @Test
    public void testTotalFacturaOk(){
        operacionesFactura oper = new operacionesFactura();
        assertNotEquals(0, oper.totalFactura(1));
    }
    
    @Test
    public void testTotalProdOk(){
        operacionesFactura oper = new operacionesFactura();
        assertEquals(2, oper.totalProd(1, 2));
    }
    
    @Test
    public void testTotalProdCantNegativa(){
        operacionesFactura oper = new operacionesFactura();
        assertEquals(0, oper.totalProd(-1, 2));
    }
    
    @Test
    public void testValorTarOk(){
        operacionesFactura oper = new operacionesFactura();
        assertNotEquals(0, oper.valorTarjeta(46000));
    }
    
    @Test
    public void testValorEfctOk(){
        operacionesFactura oper = new operacionesFactura();
        assertNotEquals(0, oper.valorEfect(46000));
    }
}
