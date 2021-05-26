package web;

import Operaciones.operacionesFactura;
import dto.Inventario;
import dto.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import logica.OperFactura;

@ManagedBean
@SessionScoped
public class ManejadorBean_Inv implements Serializable {

    private Inventario inventario;
    private String codigoP;
    private int cantidad;
    private long valorTproducto;
    private long valorTFactura;
    private String descuento;
    private long desc;
    private List<Inventario> lista;
    private static ArrayList<Inventario> ListaEstatica = new ArrayList<>();
    private ArrayList<Inventario> agregarProd = new ArrayList<>();

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getValorTproducto() {
        return valorTproducto;
    }

    public void setValorTproducto(long valorTproducto) {
        this.valorTproducto = valorTproducto;
    }

    public long getValorTFactura() {
        return valorTFactura;
    }

    public void setValorTFactura(long valorTFactura) {
        this.valorTFactura = valorTFactura;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public long getDesc() {
        return desc;
    }

    public void setDesc(long desc) {
        this.desc = desc;
    }

    public List<Inventario> getLista() {
        return lista;
    }

    public void setLista(List<Inventario> lista) {
        this.lista = lista;
    }

    public static ArrayList<Inventario> getListaEstatica() {
        return ListaEstatica;
    }

    public static void setListaEstatica(ArrayList<Inventario> ListaEstatica) {
        ManejadorBean_Inv.ListaEstatica = ListaEstatica;
    }

    public ArrayList<Inventario> getAgregarProd() {
        return agregarProd;
    }

    public void setAgregarProd(ArrayList<Inventario> agregarProd) {
        this.agregarProd = agregarProd;
    }

    //--------------------------------------------------------------------------    
    public ManejadorBean_Inv() {
        OperFactura e = new OperFactura();
        this.lista = e.consultar();
        inventario = new Inventario();
    }

    public void agregarDatos() {
        OperFactura oper = new OperFactura();
        Producto prod = new Producto();
        Inventario inv = new Inventario();
        inv.setProducto(prod);
        Inventario inve = oper.llevarInventario(this.codigoP);
        
        //Operación existencias 
        operacionesFactura operF = new operacionesFactura();
        int aux = -1;
        for (int e = 0; e < lista.size(); e++) {
            if (lista.get(e).getProducto().getCodigo().equals(codigoP)) {
                aux = e;
            }
        }
        if(operF.cantidad(cantidad, lista.get(aux).getExistencias()) == 0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "mal, ponga bien la cantidad"));
            
        }else{
            int cantidadF = operF.cantidad(cantidad, lista.get(aux).getExistencias());
            oper.actualizarExt(cantidadF, lista.get(aux));
            ListaEstatica.add(inve);
            this.agregarProd = ListaEstatica;
            inventario = new Inventario();
            for (int e = 0; e < agregarProd.size(); e++) {
            if (agregarProd.get(e).getProducto().getCodigo().equals(codigoP)) {
                aux = e;
            }
        }
        valorTproducto = operF.totalProd(cantidad, agregarProd.get(aux).getProducto().getValorUnit());
        agregarProd.get(aux).setValorTproducto(this.valorTproducto);
        agregarProd.get(aux).setCantidad(this.cantidad);

        //operacion valorTfactura
        for (int e = 0; e < agregarProd.size(); e++) {
            if (agregarProd.get(e).getValorTproducto() == valorTproducto) {
                aux = e;
            }
            valorTFactura = operF.totalFactura(agregarProd.get(aux).getValorTproducto());
        }
        agregarProd.get(aux).setValorTFact(this.valorTFactura);

        
        //aplicar los descuentos
        if (descuento.equals("tarjeta")) {
            desc = (long) operF.valorTarjeta(agregarProd.get(aux).getValorTFact());
            agregarProd.get(aux).setDescT(this.desc);
        } else {
            desc = (long) operF.valorEfect(agregarProd.get(aux).getValorTFact());
            agregarProd.get(aux).setDescE(this.desc);
        }
        if (descuento.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Seleccione un método de pago"));
        }
        }
        

        /*//operacion valorTproducto
        for (int e = 0; e < agregarProd.size(); e++) {
            if (agregarProd.get(e).getProducto().getCodigo().equals(codigoP)) {
                aux = e;
            }
        }
        valorTproducto = operF.totalProd(cantidad, agregarProd.get(aux).getProducto().getValorUnit());
        agregarProd.get(aux).setValorTproducto(this.valorTproducto);
        agregarProd.get(aux).setCantidad(this.cantidad);

        //operacion valorTfactura
        for (int e = 0; e < agregarProd.size(); e++) {
            if (agregarProd.get(e).getValorTproducto() == valorTproducto) {
                aux = e;
            }
            valorTFactura = operF.totalFactura(agregarProd.get(aux).getValorTproducto());
        }
        agregarProd.get(aux).setValorTFact(this.valorTFactura);

        
        //aplicar los descuentos
        if (descuento.equals("tarjeta")) {
            desc = (long) operF.valorTarjeta(agregarProd.get(aux).getValorTFact());
            agregarProd.get(aux).setDescT(this.desc);
        } else {
            desc = (long) operF.valorEfect(agregarProd.get(aux).getValorTFact());
            agregarProd.get(aux).setDescE(this.desc);
        }
        if (descuento.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Seleccione un método de pago"));
        }*/
    }

}
