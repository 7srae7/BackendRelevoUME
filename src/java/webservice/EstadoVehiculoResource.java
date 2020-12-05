/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.EstadoVehiculoDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.EstadoVehiculo;

/**
 * REST Web Service
 *
 * @author i7sra
 */
@Path("estadoVehiculo")
public class EstadoVehiculoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EstadoVehiculoResource
     */
    public EstadoVehiculoResource() {
    }

    /**
     * Retrieves representation of an instance of
     * webservice.EstadoVehiculoResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        EstadoVehiculoDAO estadoVehiculoDAO = new EstadoVehiculoDAO();
        ArrayList<EstadoVehiculo> listEstadoVehiculos = estadoVehiculoDAO.findAll(null);
        return EstadoVehiculo.toArrayJSon(listEstadoVehiculos);
    }

    /**
     * PUT method for updating or creating an instance of EstadoVehiculoResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
