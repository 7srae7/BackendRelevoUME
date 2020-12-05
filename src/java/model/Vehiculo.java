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
public class Vehiculo {

    private int idVehiculo;
    private String matricula;
    private int kilometros;
    private Documentacion documentacion;
    private Herramienta herramienta;
    private String url;

    public Vehiculo() {
    }

    /**
     * 
     * @param idVehiculo
     * @param matricula
     * @param kilometros
     * @param documentacion
     * @param herramienta
     * @param url 
     */
    public Vehiculo(int idVehiculo, String matricula, int kilometros, Documentacion documentacion, Herramienta herramienta, String url) {
        this.idVehiculo = idVehiculo;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.documentacion = documentacion;
        this.herramienta = herramienta;
        this.url = url;
    }

    /**
     * 
     * @return 
     */
    public int getIdVehiculo() {
        return idVehiculo;
    }

    /**
     * 
     * @param idVehiculo 
     */
    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
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
     * @param vehiculo
     * @return 
     */
    public static String
            toArrayJSon(ArrayList<Vehiculo> vehiculo) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(vehiculo);
        return resp;
    }

    /**
     * 
     * @param vehiculo
     * @return 
     */        
    public static String toObjectJson(Vehiculo vehiculo) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(vehiculo);
        return resp;
    }
}
