
package logica;

import database.Conexiones;
import dto.ListaInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperInventario implements Operaciones<ListaInventario>{

    @Override
    public List<ListaInventario> consultar() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<ListaInventario> inv = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "Select * from inventario";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ListaInventario in = new ListaInventario();
                    in.setExistencias(rs.getInt("existencias"));
                    in.setCodigo(rs.getInt("codigo"));
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

    @Override
    public List<ListaInventario> agregar(Integer dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<ListaInventario> inv = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "Select * from inventario where codigo=?";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                String cod= String.valueOf(dato);
                ps.setString(1, cod);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ListaInventario in = new ListaInventario();
                    in.setExistencias(rs.getInt("existencias"));
                    in.setCodigo(rs.getInt("codigo"));
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
    
}
