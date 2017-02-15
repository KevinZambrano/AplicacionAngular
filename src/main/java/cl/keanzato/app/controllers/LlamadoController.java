/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.controllers;

import cl.keanzato.app.dao.DaoLlamado;
import cl.keanzato.app.data.Llamado;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author k.zambrano.torres
 */
@Path("llamados")
public class LlamadoController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Llamado> listaLlamados() {
        try {
            DaoLlamado daoLlamado = new DaoLlamado();
            return daoLlamado.listar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LlamadoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Llamado getLlamado(@PathParam("id") long id) {
        try {
            DaoLlamado daoLlamado = new DaoLlamado();
            return daoLlamado.obtener(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LlamadoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Llamado llamado) {
        try {            
            DaoLlamado daoLlamado = new DaoLlamado();
            llamado.setEstado("NUEVO");
            daoLlamado.agregar(llamado);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LlamadoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Llamado llamado) {
         try {
            llamado.setEstado("PENDIENTE");
            
            DaoLlamado daoLlamado = new DaoLlamado();
            daoLlamado.actualizar(llamado);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LlamadoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
         try {
            DaoLlamado daoLlamado = new DaoLlamado();
            daoLlamado.eliminar(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LlamadoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PUT
    @Path("{id}/")
    public Response concluir(@PathParam("id") long id){
        try{
            DaoLlamado daoLlamado = new DaoLlamado();
            
            Llamado l = daoLlamado.obtener(id);
            l.setEstado("FECHADO");
            
            daoLlamado.actualizar(l);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LlamadoController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
