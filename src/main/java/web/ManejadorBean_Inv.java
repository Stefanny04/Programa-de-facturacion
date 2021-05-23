
package web;

import dto.Factura;
import dto.Inventario;
import dto.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import logica.OperFactura;


@ManagedBean
@SessionScoped
public class ManejadorBean_Inv implements Serializable {
   
    private Factura lista;
    private String codigoP;
    private List<Factura> inventario;
    private static ArrayList<Factura> ListaEstatica = new ArrayList<>();
    private ArrayList<Factura> agregarProd= new ArrayList<>();

    public Factura getLista() {
        return lista;
    }

    public static ArrayList<Factura> getListaEstatica() {
        return ListaEstatica;
    }

    public static void setListaEstatica(ArrayList<Factura> ListaEstatica) {
        ManejadorBean_Inv.ListaEstatica = ListaEstatica;
    }

    public void setLista(Factura lista) {
        this.lista = lista;
    }

    public ArrayList<Factura> getAgregarProd() {
        return ListaEstatica;
    }

    public void setAgregarProd(ArrayList<Factura> agregarProd) {
        this.agregarProd = agregarProd;
    }

    public List<Factura> getInventario() {
        return inventario;
    }

    public void setInventario(List<Factura> inventario) {
        this.inventario = inventario;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    //--------------------------------------------------------------------------    
    public ManejadorBean_Inv() {
        OperFactura e = new OperFactura();
        this.inventario = e.consultar();
        lista = new Factura();
    }
    
    public void agregarDatos() {
        OperFactura e = new OperFactura();
        Producto prod = new Producto();
        Inventario inv = new Inventario();
        inv.setProducto(prod);
        lista.setInventario(inv);
        Factura fact = e.llevarInventario(this.codigoP);
        ListaEstatica.add(fact);
        this.agregarProd = ListaEstatica;
        lista = new Factura();
    }    
}