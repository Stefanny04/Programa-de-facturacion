package logica;

import database.Conexiones;
import dto.ListaInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperInventario implements Operaciones<ListaInventario> {

    
    @Override
    public List<ListaInventario> consultar() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<ListaInventario> inv = new ArrayList<>();
        PreparedStatement ps = null;
        if (cActiva != null) {
            try {
                String sql = "Select * from inventario";
                ps = cActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ListaInventario in = new ListaInventario();
                    in.setExistencias(rs.getInt("existencias"));
                    in.setCodigo(rs.getString("codigo"));
                    in.setNombreP(rs.getString("nombreP"));
                    in.setValorUnit(rs.getLong("valorUnit"));

                    inv.add(in);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ListaInventario.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return inv;
    }

    //List<ListaInventario> valores;
    @Override
    public ListaInventario agregar(String dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        ListaInventario in = new ListaInventario();
        //Statement ps = null;
        if (cActiva != null) {
            try {
                
                String sql = "SELECT * FROM inventario WHERE codigo=?";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                //ps = c.conectarse().createStatement();
                ps.setString(1, dato);
                ResultSet rs = ps.executeQuery();
                //ResultSet rs = ps.executeQuery(sql);
                while (rs.next()){
                    
                    
                    in.setExistencias(rs.getInt("existencias"));
                    in.setCodigo(rs.getString("codigo"));
                    System.out.println("textito"+in.getCodigo());
                    in.setNombreP(rs.getString("nombreP"));
                    in.setValorUnit(rs.getLong("valorUnit"));
                    
                    System.out.print("prueba");
                    System.out.println(rs.getInt("codigo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ListaInventario.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                System.out.print("otroMensaje");
                c.desconectase(cActiva);
                
            }
        }
        return in;
    }

    /*public List<ListaInventario> getValores(Integer dato) {
        return new ArrayList<>(valores);
    }*/
}
