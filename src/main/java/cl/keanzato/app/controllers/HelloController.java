/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author k.zambrano.torres
 */
@Path("hello")
public class HelloController {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@QueryParam("usuario") String usuario){
        return "Bienvenido: "+ usuario;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("usuarios/{id}")
    public long getUsuario(@PathParam("id") long id){
        return id;
    }
}
