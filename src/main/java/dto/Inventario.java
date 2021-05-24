
package dto;

import Operaciones.operacionesFactura;

public class Inventario {
    
    private int existencias;
    private int cantidad;
    private Producto producto;
    private operacionesFactura operaciones;
    private long valorTproducto;
    private long valorTFact;

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

    
    public Inventario() {}

    public Inventario(int existencias, int cantidad, Producto producto, operacionesFactura operaciones,
        long valorTproducto, long valorTFact) {
        this.existencias = existencias;
        this.cantidad = cantidad;
        this.producto = producto;
        this.operaciones = operaciones;
        this.valorTproducto = valorTproducto;
        this.valorTFact = valorTFact;
    }
    
    @Override
    public String toString(){
        return this.producto.getCodigo()+""+
               this.producto.getNombreP()+""+
               this.producto.getValorUnit()+""+
               this.existencias+""+
               this.cantidad+""+
               this.valorTproducto+""+
               this.valorTFact;
    }
}
