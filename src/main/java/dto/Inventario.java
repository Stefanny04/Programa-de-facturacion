
package dto;

public class Inventario {
    
    private Integer existencias;
    private Producto producto;

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Inventario() {}

    public Inventario(Integer existencias, Producto producto) {
        this.existencias = existencias;
        this.producto = producto;
    }
}
