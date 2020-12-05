/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.AutobombaDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Autobomba;

/**
 * REST Web Service
 *
 * @author i7sra
 */
@Path("autobomba")
public class AutobombaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AutobombaResource
     */
    public AutobombaResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.AutobombaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        AutobombaDAO autobombaDAO = new AutobombaDAO();
        ArrayList<Autobomba> listAutobomba = autobombaDAO.findAll(null);
        return Autobomba.toArrayJSon(listAutobomba);
    }

    /**
     * PUT method for updating or creating an instance of AutobombaResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
