
package web;

import dto.ListaInventario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import logica.OperInventario;


@ManagedBean
@SessionScoped
public class ManejadorBean_Inv implements Serializable {
   
    private ListaInventario lista;
    private List<ListaInventario> inventario;
    private static ArrayList<ListaInventario> ListaEstatica= new ArrayList<>();
    private ArrayList<ListaInventario> agregarProd= new ArrayList<>();

    public ListaInventario getLista() {
        return lista;
    }

    public static ArrayList<ListaInventario> getListaEstatica() {
        return ListaEstatica;
    }

    public static void setListaEstatica(ArrayList<ListaInventario> ListaEstatica) {
        ManejadorBean_Inv.ListaEstatica = ListaEstatica;
    }

    public void setLista(ListaInventario lista) {
        this.lista = lista;
    }

    public ArrayList<ListaInventario> getAgregarProd() {
        return ListaEstatica;
    }

    public void setAgregarProd(ArrayList<ListaInventario> agregarProd) {
        this.agregarProd = agregarProd;
    }

    public List<ListaInventario> getInventario() {
        return inventario;
    }

    public void setInventario(List<ListaInventario> inventario) {
        this.inventario = inventario;
    }

    //--------------------------------------------------------------------------    
    public ManejadorBean_Inv() {
        OperInventario e = new OperInventario();
        this.inventario = e.consultar();
        lista = new ListaInventario();
    }
    
    public void agregarDatos() {
        OperInventario e = new OperInventario();
        ListaInventario in = e.agregar(lista.getCodigo());
        ListaEstatica.add(in);
        this.agregarProd = ListaEstatica;
        lista = new ListaInventario();
    }    
}
