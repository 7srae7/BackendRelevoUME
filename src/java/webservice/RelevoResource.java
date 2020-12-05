/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.RelevoDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Autobomba;
import model.Relevo;
import model.Vehiculo;

/**
 * REST Web Service
 *
 * @author i7sra
 */
 @Path("relevo")
public class RelevoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RelevoResource
     */
    public RelevoResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.RelevoResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        RelevoDAO relevoDAO = new RelevoDAO();
        ArrayList<Relevo> listRelevo = relevoDAO.listaRelevoVehiculo();
        return Relevo.toArrayJSon(listRelevo);
    }

    /**
     * PUT method for updating or creating an instance of RelevoResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/todosRelevo")
    public String getTodosRelevos(){
        RelevoDAO relevoDAO = new RelevoDAO();
        ArrayList<Relevo> listRelevo = relevoDAO.todosRelevosDesc();
        return Relevo.toArrayJSon(listRelevo);
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ultimoRelevoVehiculo")
    public String getUltimoRelevo(Vehiculo vehiculo) {
        RelevoDAO relevoDAO = new RelevoDAO();
        ArrayList<Relevo> listRelevo = relevoDAO.ultimoRelevoVehiculo(vehiculo);
        return Relevo.toArrayJSon(listRelevo);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ultimoRelevoAutobomba")
    public String getUltimoRelevoAuto(Autobomba autobomba) {
        RelevoDAO relevoDAO = new RelevoDAO();
        ArrayList<Relevo> listRelevo = relevoDAO.ultimoRelevoAutobomba(autobomba);
        return Relevo.toArrayJSon(listRelevo);

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/relevar")
    public String insertRelevo(Relevo relevo) {
        RelevoDAO relevoDAO = new RelevoDAO();
        relevoDAO.insertarRelevo(relevo);
        return Relevo.toObjectJson(relevo);
    }

}
