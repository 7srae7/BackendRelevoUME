/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.DocumentacionDAO;
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
import model.Documentacion;

/**
 * REST Web Service
 *
 * @author i7sra
 */
@Path("documentacion")
public class DocumentacionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DocumentacionResource
     */
    public DocumentacionResource() {
    }

    /**
     * Retrieves representation of an instance of
     * webservice.DocumentacionResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        DocumentacionDAO documentacionDAO = new DocumentacionDAO();
        ArrayList<Documentacion> listDocumentacion = documentacionDAO.findAll(null);
        return Documentacion.toArrayJSon(listDocumentacion);

    }

    /**
     * PUT method for updating or creating an instance of DocumentacionResource
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
    @Path("/buscaDocumentacion")
    public String getDocumentacionMatricula(Autobomba autobomba) {
        DocumentacionDAO documentacionDAO = new DocumentacionDAO();
        ArrayList<Documentacion> listDocumentacion = documentacionDAO.buscarDocumentacionMatricula(autobomba);
        return Documentacion.toArrayJSon(listDocumentacion);
    }
}
