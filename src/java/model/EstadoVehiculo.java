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
public class EstadoVehiculo {

    private int idEstadoVehiculo;
    private String estado;

    public EstadoVehiculo() {
    }

    /**
     * 
     * @param idEstadoVehiculo
     * @param estado 
     */
    public EstadoVehiculo(int idEstadoVehiculo, String estado) {
        this.idEstadoVehiculo = idEstadoVehiculo;
        this.estado = estado;
    }

    /**
     * 
     * @return 
     */
    public int getIdEstadoVehiculo() {
        return idEstadoVehiculo;
    }

    /**
     * 
     * @param idEstadoVehiculo 
     */
    public void setIdEstadoVehiculo(int idEstadoVehiculo) {
        this.idEstadoVehiculo = idEstadoVehiculo;
    }

    /**
     * 
     * @return 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * 
     * @param estado
     * @return 
     */
    public static String
            toArrayJSon(ArrayList<EstadoVehiculo> estado) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(estado);

        return resp;
    }

    /**
     * 
     * @param estado
     * @return 
     */        
    public static String toObjectJson(EstadoVehiculo estado) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(estado);
        return resp;
    }

}
