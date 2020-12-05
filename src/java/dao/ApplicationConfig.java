/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author i7sra
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(webservice.AutobombaResource.class);
        resources.add(webservice.DocumentacionResource.class);
        resources.add(webservice.EstadoVehiculoResource.class);
        resources.add(webservice.HerramientaResource.class);
        resources.add(webservice.RelevoResource.class);
        resources.add(webservice.VehiculoResource.class);
    }
    
}
