
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
    
    private Integer existencias;
    private String codigo;
    private String nombreP;
    private Long valorUnit;
    private List<ListaInventario> inventario;
    private ArrayList<ListaInventario> agregarProd = new ArrayList<ListaInventario>();
    

    public ArrayList<ListaInventario> getAgregarProd() {
        return agregarProd;
    }


    public void setAgregarProd(ArrayList<ListaInventario> agregarProd) {
        this.agregarProd = agregarProd;
    }
    

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public Long getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Long valorUnit) {
        this.valorUnit = valorUnit;
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

    }
    
    public void agregarDatos() {
        OperInventario e = new OperInventario();
        ListaInventario in = e.agregar(this.codigo);
        this.agregarProd.add(in);
        
    }    
}
