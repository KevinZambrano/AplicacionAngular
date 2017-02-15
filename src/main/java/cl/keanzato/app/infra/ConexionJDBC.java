/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.infra;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author k.zambrano.torres
 */
public interface ConexionJDBC {
 
    public Connection getConnection();
    
    public void close();
    
    public void commit() throws SQLException;
    
    public void rollback(); 
}
