/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.HerramientaDAO;
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
import model.Herramienta;

/**
 * REST Web Service
 *
 * @author i7sra
 */
@Path("herramienta")
public class HerramientaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HerramientaResource
     */
    public HerramientaResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.HerramientaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        HerramientaDAO herramientaDAO = new HerramientaDAO();
        ArrayList<Herramienta> listHerramienta = herramientaDAO.findAll(null);
        return Herramienta.toArrayJSon(listHerramienta);
    }

    /**
     * PUT method for updating or creating an instance of HerramientaResource
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
    @Path("/buscaHerramienta")
    public String buscarHerramientaMatricula(Autobomba autobomba) {
        HerramientaDAO herramientaDAO = new HerramientaDAO();
        ArrayList<Herramienta> listHerramienta = herramientaDAO.buscarHerramientaMatricula(autobomba);
        return Herramienta.toArrayJSon(listHerramienta);
    }

}
