package logica;

import database.Conexiones;
import dto.Factura;
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

public class OperFactura implements Operaciones<Factura> {

    @Override
    public List<Factura> consultar() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Factura> inv = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "Select * from inventario";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Factura fact = new Factura();
                    Inventario in = new Inventario(); 
                    Producto prod = new Producto();
                    fact.setInventario(in);
                    in.setProducto(prod);
                    fact.getInventario().setExistencias(rs.getInt("existencias"));
                    fact.getInventario().getProducto().setCodigo(rs.getString("codigo"));
                    fact.getInventario().getProducto().setNombreP(rs.getString("nombreP"));
                    fact.getInventario().getProducto().setValorUnit(rs.getLong("valorUnit"));

                    inv.add(fact);
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
    public Factura llevarInventario(String dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        Factura fact = new Factura();
        Inventario in = new Inventario();
        Producto prod = new Producto();
        if (cActiva != null) {
            try {
                String sql = "SELECT * FROM inventario WHERE codigo=?";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    fact.setInventario(in);
                    in.setProducto(prod);
                    fact.getInventario().setExistencias(rs.getInt("existencias"));
                    fact.getInventario().getProducto().setNombreP(rs.getString("nombreP"));
                    fact.getInventario().getProducto().setValorUnit(rs.getLong("valorUnit"));
                    fact.getInventario().getProducto().setCodigo(rs.getString("codigo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(OperFactura.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectase(cActiva);
            }
        }
        return fact;
    }

}
