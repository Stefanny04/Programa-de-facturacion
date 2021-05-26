
package Operaciones;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class operacionesFactura {

    private long valorTProd;
    private long valorTFact;
    private long descuento;
    
    public long getValorTotal() {
        return valorTProd;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTProd = valorTotal;
    }

    public long getValorTFact() {
        return valorTFact;
    }

    public void setValorTFact(long valorTFact) {
        this.valorTFact = valorTFact;
    }

    public long getValorTProd() {
        return valorTProd;
    }

    public void setValorTProd(long valorTProd) {
        this.valorTProd = valorTProd;
    }

    public long getDescuento() {
        return descuento;
    }

    public void setDescuento(long descuento) {
        this.descuento = descuento;
    }
    
    //Operaciones -------------------------------------
    public int cantidad(int cant, int canInv){
        
        canInv = canInv - cant;
        return canInv;
    }
    
    public long totalFactura(long valorT){
        double iva = 0.19;
        valorTFact += valorT;
        double total = valorTFact*iva;
        return (long)(valorTFact+total);
    }
    
    public long totalProd(int cant, long valUnit){
        valorTProd = valUnit*cant;
        return valorTProd;        
    }
    
    public double valorTarjeta(long valorTfact){
        double desc = 0.035;
        if(valorTfact > 45000){
            double g = (long) valorTfact;
            double total = g*desc;
            return (valorTfact-total);
        } 
        return 0;
    }
    public double valorEfect(long valorTfact){
        double desc = 0.02;
        if(valorTfact > 45000){
            double g = (long) valorTfact;
            double total = g*desc;
            return (valorTfact-total);
        }
        return 0;
    }
}

