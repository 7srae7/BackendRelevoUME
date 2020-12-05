/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author i7sra
 */
public class Relevo {

    private int idRelevo;
    private String novedades;
    private String fechaRelevo;
    private Vehiculo vehiculo;
    private Autobomba autobomba;
    private int kilometros;
    private String nombre;
    private String empleo;

    public Relevo() {
    }

    /**
     *
     * @param idRelevo
     * @param novedades
     * @param fechaRelevo
     * @param vehiculo
     * @param autobomba
     * @param kilometros
     * @param nombre
     * @param empleo
     */
    public Relevo(int idRelevo, String novedades, String fechaRelevo, Vehiculo vehiculo, Autobomba autobomba, int kilometros, String nombre, String empleo) {
        this.idRelevo = idRelevo;
        this.novedades = novedades;
        this.fechaRelevo = fechaRelevo;
        this.vehiculo = vehiculo;
        this.autobomba = autobomba;
        this.kilometros = kilometros;
        this.nombre = nombre;
        this.empleo = empleo;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getEmpleo() {
        return empleo;
    }

    /**
     *
     * @param empleo
     */
    public void setEmpleo(String empleo) {
        this.empleo = empleo;
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
    public int getIdRelevo() {
        return idRelevo;
    }

    /**
     *
     * @param idRelevo
     */
    public void setIdRelevo(int idRelevo) {
        this.idRelevo = idRelevo;
    }

    /**
     *
     * @return
     */
    public String getNovedades() {
        return novedades;
    }

    /**
     *
     * @param novedades
     */
    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    /**
     *
     * @return
     */
    public String getFechaRelevo() {
        return fechaRelevo;
    }

    /**
     *
     * @param fechaRelevo
     */
    public void setFechaRelevo(String fechaRelevo) {
        this.fechaRelevo = fechaRelevo;
    }

    /**
     *
     * @return
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     *
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     *
     * @return
     */
    public Autobomba getAutobomba() {
        return autobomba;
    }

    /**
     *
     * @param autobomba
     */
    public void setAutobomba(Autobomba autobomba) {
        this.autobomba = autobomba;
    }

    /**
     *
     * @param relevo
     * @return
     */
    public static String
            toArrayJSon(ArrayList<Relevo> relevo) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(relevo);

        return resp;
    }

    /**
     *
     * @param relevo
     * @return
     */
    public static String toObjectJson(Relevo relevo) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(relevo);
        return resp;
    }
}
