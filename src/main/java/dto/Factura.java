
package dto;

import Operaciones.operacionesFactura;
import java.util.List;

public class Factura {

    private double totalFact;

    private List<Inventario> ListaInv ;
    private Inventario inventario;

    public double getTotalFact() {
        return totalFact;
    }

    public void setTotalFact(double totalFact) {
        this.totalFact = totalFact;
    }

    public List<Inventario> getListaInv() {
        return ListaInv;
    }

    public void setListaInv(List<Inventario> ListaInv) {
        this.ListaInv = ListaInv;
    }
    
    
    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario lista) {
        this.inventario = lista;
    }
    
    @Override
    public String toString(){
        return  //this.valorTotalProd+" "+
                this.totalFact+" "+
                this.inventario.getExistencias()+" "+
                this.inventario.getProducto().getCodigo()+" "+
                this.inventario.getProducto().getNombreP()+" "+
                this.inventario.getProducto().getValorUnit();
    }

}
