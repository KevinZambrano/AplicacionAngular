/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app;

import cl.keanzato.app.dao.DaoLlamado;
import cl.keanzato.app.data.Llamado;
import java.sql.SQLException;

/**
 *
 * @author k.zambrano.torres
 */
public class Test {

    public static void main(String[] args){
        try {
            DaoLlamado daoLlamado = new DaoLlamado();
            Llamado l = new Llamado("qipa", "xuncoco", "NUEVO");
            System.out.println(l.toString());
            daoLlamado.agregar(l);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
