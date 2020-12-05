/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author i7sra
 */
public class Documentacion {

    private int idDocumentacion;
    private String documento;

    /**
     * 
     * @param idDocumentacion
     * @param documento 
     */
    public Documentacion(int idDocumentacion, String documento) {
        this.idDocumentacion = idDocumentacion;
        this.documento = documento;
    }
    
    public Documentacion() {
    }

    /**
     * 
     * @return 
     */
    public int getIdDocumentacion() {
        return idDocumentacion;
    }

    /**
     * 
     * @param idDocumentacion 
     */
    public void setIdDocumentacion(int idDocumentacion) {
        this.idDocumentacion = idDocumentacion;
    }

    /**
     * 
     * @return 
     */
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * 
     * @param documentacion
     * @return 
     */
    public static String
            toArrayJSon(ArrayList<Documentacion> documentacion) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(documentacion);

        return resp;
    }

    /**
     * 
     * @param documento
     * @return 
     */
    public static String toObjectJson(Documentacion documento) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(documento);
        return resp;
    }
}
