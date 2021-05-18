
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiones {
    private final String URL = "C:/APL/db_sqlite/inventario.db";
    
    public Connection conectarse(){
        try {
            Class.forName("org.sqlite.JDBC");//DRIVER DE CONEXION
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:"+URL); //CADENA QUE IDENTIFICA LA CONEXION 
            return conexion;
            
        } catch (ClassNotFoundException | SQLException ex) {
            ;
        }
        return null;
    }
    public void desconectase(Connection dato){
        if (dato != null){
            try {
                dato.close();
            } catch (SQLException ex) {
                ;
            }
        }
    }
}
