/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.VehiculoDAO;
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
import model.Vehiculo;

/**
 * REST Web Service
 *
 * @author i7sra
 */
@Path("vehiculo")
public class VehiculoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VehiculoResource
     */
    public VehiculoResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.VehiculoResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        ArrayList<Vehiculo> listVehiculos = vehiculoDAO.findAll(null);
        return Vehiculo.toArrayJSon(listVehiculos);
    }

    /**
     * PUT method for updating or creating an instance of VehiculoResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/buscarMatricula")
    public String getVehiculosMatriculas(Vehiculo vehiculo) {
        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        ArrayList<Vehiculo> listVehiculos = vehiculoDAO.buscarVehiculoMatricula(vehiculo);
        return Vehiculo.toArrayJSon(listVehiculos);
    }

}
