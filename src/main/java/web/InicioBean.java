
package web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class InicioBean {
    public String mostrarBaseDatos(){
        return "baseDatos";
    }
    public String crearFact(){
        return "nuevaFact";
    }
    public String volverIni(){
        return "index";
    }
}
