
package dto;

import Operaciones.operacionesFactura;

public class Inventario {
    
    private int existencias;
    private int cantidad;
    private Producto producto;
    private operacionesFactura operaciones;
    private long valorTproducto;
    private long valorTFact;
    private long descT;
    private long descE;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public operacionesFactura getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(operacionesFactura operaciones) {
        this.operaciones = operaciones;
    }

    public long getValorTproducto() {
        return valorTproducto;
    }

    public void setValorTproducto(long valorTproducto) {
        this.valorTproducto = valorTproducto;
    }

    public long getValorTFact() {
        return valorTFact;
    }

    public void setValorTFact(long valorTFact) {
        this.valorTFact = valorTFact;
    }

    public long getDescT() {
        return descT;
    }

    public void setDescT(long descT) {
        this.descT = descT;
    }

    public long getDescE() {
        return descE;
    }

    public void setDescE(long descE) {
        this.descE = descE;
    }
        
    public Inventario() {}

    public Inventario(int existencias, int cantidad, Producto producto, operacionesFactura operaciones,
        long valorTproducto, long valorTFact, long descT, long descE) {
        this.existencias = existencias;
        this.cantidad = cantidad;
        this.producto = producto;
        this.operaciones = operaciones;
        this.valorTproducto = valorTproducto;
        this.valorTFact = valorTFact;
        this.descT = descT;
        this.descE = descE;
    }
    
    @Override
    public String toString(){
        return this.producto.getCodigo()+""+
               this.producto.getNombreP()+""+
               this.producto.getValorUnit()+""+
               this.existencias+""+
               this.cantidad+""+
               this.valorTproducto+""+
               this.valorTFact+""+
               this.descT+""+
               this.descE;
    }
}
