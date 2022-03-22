package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lined
 */

public class ConnectionFactory {
	    private static final String banco = "projetopoo";
	    private static final String usuario = "root";
	    private static final String senha = "";
	    
	    public static Connection getConnect(){
	        
	        try {
	            return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+banco, usuario, senha);
	        } catch (SQLException ex) {
	            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return null;
	    }
}
