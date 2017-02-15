/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.infra;

import cl.keanzato.app.exceptions.ConexionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author k.zambrano.torres
 */
public class ConexionMySqlJDBC{

    private static ConexionMySqlJDBC _conexion;
	private Connection connection;

	/**
	 * 
	 */
	private ConexionMySqlJDBC() {
	}

	public static ConexionMySqlJDBC getInstancia() {
		if (_conexion == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection(
						"jdbc:mysql://localhost/llamados", 
						"root",
						"");
				ConexionMySqlJDBC conexion = new ConexionMySqlJDBC();
				conexion.setConnection(conn);
				_conexion = conexion;
			} catch (Exception e) {
				throw new ConexionException("Ocurrio un error"
						+ " al conectar con la base de datos", e);
			}
		} 
		return _conexion;
		
	}
        
        /**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
    
    
}
