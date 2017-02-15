/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.dao;

import cl.keanzato.app.data.Llamado;
import cl.keanzato.app.infra.ConexionJDBC;
import cl.keanzato.app.infra.ConexionMySqlJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author k.zambrano.torres
 */
public class DaoLlamado {

    public boolean agregar(Llamado llamado) throws SQLException, ClassNotFoundException {
        ConexionMySqlJDBC con = ConexionMySqlJDBC.getInstancia();
        PreparedStatement consulta = con.getConnection().prepareStatement("insert into llamado values(null,'" + llamado.getAsunto() + "','" + llamado.getEstado() + "','" + llamado.getMensage() + "')");
        /*consulta.setString(1,llamado.getAsunto());
            consulta.setString(2,llamado.getEstado());
            consulta.setString(3, llamado.getMensage());*/

        if (consulta.execute()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean actualizar(Llamado llamado) throws SQLException, ClassNotFoundException {
        try {
            ConexionMySqlJDBC con = ConexionMySqlJDBC.getInstancia();
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE llamado set asunto = ?,estado=?,mensaje=? WHERE id=?");
            consulta.setString(1, llamado.getAsunto());
            consulta.setString(2, llamado.getEstado());
            consulta.setString(3, llamado.getMensage());
            consulta.setLong(4, llamado.getId());
            if (0 < consulta.executeUpdate()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean eliminar(long id) throws SQLException, ClassNotFoundException {
        try {
            ConexionMySqlJDBC con = ConexionMySqlJDBC.getInstancia();
            PreparedStatement consulta = con.getConnection().prepareStatement("delete from llamado where id = ?");
            consulta.setLong(1, id);
            if (0 < consulta.executeUpdate()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    public Llamado obtener(long id) throws SQLException, ClassNotFoundException {
        try {
            ConexionMySqlJDBC con = ConexionMySqlJDBC.getInstancia();
            PreparedStatement consulta = con.getConnection().prepareStatement("select * from llamado where id = ?");
            consulta.setLong(1, id);
            ResultSet rst = consulta.executeQuery();
            if (rst.next()) {
                return parser(rst);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<Llamado> listar() throws SQLException, ClassNotFoundException {
        try {
            ConexionMySqlJDBC con = ConexionMySqlJDBC.getInstancia();
        PreparedStatement consulta = con.getConnection().prepareStatement("SELECT * FROM llamado ORDER BY id");
            ResultSet rst = consulta.executeQuery();

            List<Llamado> llamados = new ArrayList<>();

            while (rst.next()) {
                llamados.add(parser(rst));
            }
            return llamados;

        } catch (SQLException ex) {
            return null;
        }
    }

    private Llamado parser(ResultSet resultSet) throws SQLException {
        Llamado l = new Llamado();

        l.setId(resultSet.getLong("id"));
        l.setAsunto(resultSet.getString("asunto"));
        l.setEstado(resultSet.getString("estado"));
        l.setMensage(resultSet.getString("mensaje"));

        return l;
    }
}
