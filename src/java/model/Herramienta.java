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
public class Herramienta {

    private int idHerramienta;
    private String nombreHerramienta;

    public Herramienta() {

    }

    /**
     * 
     * @param idHerramienta
     * @param nombreHerramienta 
     */
    public Herramienta(int idHerramienta, String nombreHerramienta) {
        this.idHerramienta = idHerramienta;
        this.nombreHerramienta = nombreHerramienta;
    }

    /**
     * 
     * @return 
     */
    public int getIdHerramienta() {
        return idHerramienta;
    }

    /**
     * 
     * @param idHerramienta 
     */
    public void setIdHerramienta(int idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    /**
     * 
     * @return 
     */
    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    /**
     * 
     * @param nombreHerramienta 
     */
    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    /**
     * 
     * @param herramienta
     * @return 
     */
    public static String
            toArrayJSon(ArrayList<Herramienta> herramienta) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(herramienta);

        return resp;
    }

   /**
    * 
    * @param herramienta
    * @return 
    */         
    public static String toObjectJson(Herramienta herramienta) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(herramienta);
        return resp;
    }
}
