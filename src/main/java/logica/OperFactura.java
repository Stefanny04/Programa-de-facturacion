package logica;

import database.Conexiones;
import dto.Inventario;
import dto.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperFactura implements Operaciones<Inventario> {

    @Override
    public List<Inventario> consultar() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Inventario> inv = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "Select * from inventario";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Inventario in = new Inventario();
                    Producto prod = new Producto();

                    in.setProducto(prod);
                    in.setExistencias(rs.getInt("existencias"));
                    in.getProducto().setCodigo(rs.getString("codigo"));
                    in.getProducto().setNombreP(rs.getString("nombreP"));
                    in.getProducto().setValorUnit(rs.getLong("valorUnit"));

                    inv.add(in);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperFactura.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return inv;
    }

    @Override
    public Inventario llevarInventario(String dato) {
        if (dato == null || dato.isEmpty()) {
            return null;
        }
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        Inventario in = new Inventario();
        Producto prod = new Producto();
        if (cActiva != null) {
            try {
                String sql = "SELECT * FROM inventario WHERE codigo=?";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    in.setProducto(prod);
                    in.setExistencias(rs.getInt("existencias"));
                    in.getProducto().setNombreP(rs.getString("nombreP"));
                    in.getProducto().setValorUnit(rs.getLong("valorUnit"));
                    in.getProducto().setCodigo(rs.getString("codigo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperFactura.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return in;
    }

    @Override
    public int actualizarExt(int cant, Inventario dato) {
        if (cant == 0 || dato == null) {
            return 0;
        }
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        if (cActiva != null) {
            try {
                String sql = "UPDATE inventario SET existencias =? WHERE codigo=?";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setInt(1, cant);
                ps.setString(2, dato.getProducto().getCodigo());
                int rta = ps.executeUpdate();

                return rta;

            } catch (SQLException ex) {
                Logger.getLogger(OperFactura.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return 0;
    }

}
