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
public class Autobomba {

    private int idAutobomba;
    private String matricula;
    private int kilometros;
    private String url;
    private Documentacion documentacion;
    private Herramienta herramienta;

    public Autobomba() {
    }

    /**
     *
     * @param idAutobomba
     * @param matricula
     * @param kilometros
     * @param url
     * @param documentacion
     * @param herramienta
     */
    public Autobomba(int idAutobomba, String matricula, int kilometros, String url, Documentacion documentacion, Herramienta herramienta) {
        this.idAutobomba = idAutobomba;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.url = url;
        this.documentacion = documentacion;
        this.herramienta = herramienta;
    }

    /**
     *
     * @return
     */
    public int getIdAutobomba() {
        return idAutobomba;
    }

    /**
     *
     * @param idAutobomba
     */
    public void setIdAutobomba(int idAutobomba) {
        this.idAutobomba = idAutobomba;
    }

    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public int getKilometros() {
        return kilometros;
    }

    /**
     *
     * @param kilometros
     */
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public Documentacion getDocumentacion() {
        return documentacion;
    }

    /**
     *
     * @param documentacion
     */
    public void setDocumentacion(Documentacion documentacion) {
        this.documentacion = documentacion;
    }

    /**
     *
     * @return
     */
    public Herramienta getHerramienta() {
        return herramienta;
    }

    /**
     *
     * @param herramienta
     */
    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    /**
     *
     * @param autobomba
     * @return
     */
    public static String
            toArrayJSon(ArrayList<Autobomba> autobomba) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(autobomba);

        return resp;
    }

    /**
     *
     * @param autobomba
     * @return
     */
    public static String toObjectJson(Autobomba autobomba) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(autobomba);
        return resp;
    }

}
