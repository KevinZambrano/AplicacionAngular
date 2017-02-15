/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author k.zambrano.torres
 */
public class ConexionMySqlJDBC implements ConexionJDBC{

    private Connection conn = null;
    
    public ConexionMySqlJDBC() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = (Connection) DriverManager.getConnection(
						"jdbc:mysql://localhost/llamados", 
						"root",
						"");
        this.conn.setAutoCommit(false);
    }
    @Override
    public Connection getConnection() {
        return this.conn;
    }

    @Override
    public void close() {
        if(this.conn!=null){
            try{
                this.conn.close();
            }catch(SQLException es){
                Logger.getLogger(ConexionMySqlJDBC.class.getName()).log(Level.SEVERE, null, es);
            }
        }
    }

    @Override
    public void commit() throws SQLException {
        this.conn.commit();
        this.close();
    }

    @Override
    public void rollback() {
        if(this.conn != null){
            try{
                this.conn.rollback();
            }catch(SQLException ex){
                Logger.getLogger(ConexionMySqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                this.close();
            }
        }
    }
    
    
}
