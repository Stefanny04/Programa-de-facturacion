
package test;

import dto.Inventario;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import logica.OperFactura;

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
    public void testConsultarOK() {
        OperFactura oper = new OperFactura();
        List<Inventario> datos = new ArrayList<>();
        datos = oper.consultar();
    }

    @Test
    public void testLlevarInventarioOk() {
        OperFactura oper = new OperFactura();
        assertNotNull(oper.llevarInventario("2578"));
    }

    @Test
    public void testLlevarInventarioVacio() {
        OperFactura oper = new OperFactura();
        assertEquals(null, oper.llevarInventario(""));
    }

    @Test
    public void testLlevarInventarioNull() {
        OperFactura oper = new OperFactura();
        Inventario dato = oper.llevarInventario(null);
        assertEquals(null, dato);
    }

    @Test
    public void testActualizarExNull() {
        OperFactura oper = new OperFactura();
        Inventario dato = oper.llevarInventario(null);
        assertEquals(0, oper.actualizarExt(1, dato));
    }

    @Test
    public void testActualizarExCantCero() {
        OperFactura oper = new OperFactura();
        Inventario dato = oper.llevarInventario("2365");
        assertEquals(0, oper.actualizarExt(0, dato));
    }

}
