
package web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class InicioBean {
    public String mostrarBaseDatos(){
        return "baseDatos";
    }
    public String consultaFact(){
        return "consulFac";
    }
    public String crearFact(){
        return "nuevaFact";
    }
}
