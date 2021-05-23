
package dto;

import Operaciones.operacionesFactura;

public class Factura {

    private Long totalProducto;
    private Long totalFact;
    private Integer cantExist;
    private Inventario inventario;
    private operacionesFactura operaciones;

    public Long getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(Long totalProducto) {
        this.totalProducto = totalProducto;
    }

    public Long getTotalFact() {
        return totalFact;
    }

    public void setTotalFact(Long totalFact) {
        this.totalFact = totalFact;
    }

    public Integer getCantExist() {
        return cantExist;
    }

    public void setCantExist(Integer cantExist) {
        this.cantExist = cantExist;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario lista) {
        this.inventario = lista;
    }

    public operacionesFactura getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(operacionesFactura operaciones) {
        this.operaciones = operaciones;
    }
    
    public Factura(){}
    
    public Factura(Long totalProducto, Long totalFact, Integer cantExist,Inventario inventario){
        this.totalProducto = totalProducto;
        this.totalFact = totalFact;        
        this.cantExist = cantExist;
        this.inventario = inventario;
    }
       
    @Override
    public String toString(){
        return this.cantExist+" "+
                this.totalFact+" "+
                this.totalProducto+" "+
                this.inventario.getExistencias()+" "+
                this.inventario.getProducto().getCodigo()+" "+
                this.inventario.getProducto().getNombreP()+" "+
                this.inventario.getProducto().getValorUnit();
    }
}
