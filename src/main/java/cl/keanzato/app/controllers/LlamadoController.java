/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.controllers;

import cl.keanzato.app.data.Estado;
import cl.keanzato.app.data.Llamado;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public List<Llamado> listaLlamados(){
        Llamado l1 = new Llamado();
        l1.setAsunto("Asunto 1");
        l1.setMensage("Mensage 1");
        l1.setEstado(Estado.NUEVO);
        
        Llamado l2 = new Llamado();
        l2.setAsunto("Asunto 2");
        l2.setMensage("Mensage 2");
        l2.setEstado(Estado.NUEVO);
        
        Llamado l3 = new Llamado();
        l3.setAsunto("Asunto 3");
        l3.setMensage("Mensage 3");
        l3.setEstado(Estado.FECHADO);
        
        List<Llamado> llamados = new ArrayList<>();
        llamados.add(l1);
        llamados.add(l2);
        llamados.add(l3);
            
        return llamados;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Llamado getLlamado(@PathParam("id") long id){
        Llamado l1 = new Llamado();
        l1.setId(id);
        l1.setAsunto("Asunto 1"+id);
        l1.setMensage("Mensage 1"+id);
        l1.setEstado(Estado.NUEVO);
        
        return l1;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Llamado llamado){
        System.out.println(llamado.toString());
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Llamado llamado){
        System.out.println(llamado.toString());
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id){
        System.out.println("Eliminando ID: "+id);
        return Response.status(Response.Status.OK).build();
    }
}
