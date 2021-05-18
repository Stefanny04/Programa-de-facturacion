
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
    private Integer codigo;
    private String nombreP;
    private Long valorUnit;
    private List<ListaInventario> inventario;
    private static List<ListaInventario> agregarProd = new ArrayList<ListaInventario>();

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public static List<ListaInventario> getAgregarProd() {
        return agregarProd;
    }

    public static void setAgregarProd(List<ListaInventario> agregarProd) {
        ManejadorBean_Inv.agregarProd = agregarProd;
    }
    
    //--------------------------------------------------------------------------    
    public ManejadorBean_Inv() {
        OperInventario e = new OperInventario();
        this.inventario = e.consultar();
    }
    
    public void agregar() {
        inventario = agregarProd;
        OperInventario e = new OperInventario();
        ListaInventario in = new ListaInventario();
        in.setCodigo(this.codigo);
        this.inventario = e.agregar(this.codigo);
        inventario = (List<ListaInventario>) new ListaInventario();
    }
    
}
