/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Autobomba;
import model.Herramienta;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author i7sra
 */
public class HerramientaDAO implements IDAO<Herramienta, Integer> {

    private final String SQL_FINDALL = "SELECT nombre_herramienta FROM `herramienta` WHERE 1";
    private final String SQL_HERRAMIENTA_MATRICULA_AUTOBOMBA = "SELECT herramienta.nombre_herramienta FROM autobomba "
            + "JOIN conjunto_herramienta ON autobomba.id_herramienta=conjunto_herramienta.id_conjunto_herramienta "
            + "JOIN herramienta ON conjunto_herramienta.id_conjunto_herramienta=herramienta.cojunto_herramienta "
            + "where autobomba.matricula = '";
    private final String SQL_HERRAMIENTA_MATRIUCLA_VEHICULO = " SELECT herramienta.nombre_herramienta FROM vehiculo "
            + "JOIN conjunto_herramienta on vehiculo.id_herramienta=conjunto_herramienta.id_conjunto_herramienta "
            + "JOIN herramienta on conjunto_herramienta.id_conjunto_herramienta=herramienta.cojunto_herramienta "
            + "WHERE vehiculo.matricula = '";

    private MotorSQL motorSQL;

    public HerramientaDAO() {
        motorSQL = ConnectionFactory.selectDb();

    }

    // SELECT nombre_herramienta FROM `herramienta` WHERE 1
    @Override
    public ArrayList<Herramienta> findAll(Herramienta bean) {
        ArrayList<Herramienta> listHerramienta = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            motorSQL.connect();
            System.out.println(sql);

            ResultSet rs = motorSQL.
                    executeQuery(sql);

            while (rs.next()) {
                Herramienta herramienta = new Herramienta();
                herramienta.setNombreHerramienta(rs.getString(1));
                listHerramienta.add(herramienta);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }
        return listHerramienta;
    }
    
    //SELECT herramienta.nombre_herramienta FROM autobomba 
            // JOIN conjunto_herramienta ON autobomba.id_herramienta=conjunto_herramienta.id_conjunto_herramienta 
            // JOIN herramienta ON conjunto_herramienta.id_conjunto_herramienta=herramienta.cojunto_herramienta 
            // where autobomba.matricula = 
            //UNION
    // SELECT herramienta.nombre_herramienta FROM vehiculo 
            // JOIN conjunto_herramienta on vehiculo.id_herramienta=conjunto_herramienta.id_conjunto_herramienta 
            // JOIN herramienta on conjunto_herramienta.id_conjunto_herramienta=herramienta.cojunto_herramienta 
            // WHERE vehiculo.matricula =
    
    public ArrayList<Herramienta> buscarHerramientaMatricula(Autobomba autobomba) {
        ArrayList<Herramienta> listHerramiena = new ArrayList<>();
        String sql = SQL_HERRAMIENTA_MATRICULA_AUTOBOMBA;

        try {
            motorSQL.connect();
            if (autobomba != null) {
                sql += autobomba.getMatricula() + "'" + " UNION "
                        + SQL_HERRAMIENTA_MATRIUCLA_VEHICULO + autobomba.getMatricula() + "'";
            }
            System.out.println(sql);

            ResultSet rs = motorSQL.
                    executeQuery(sql);
            while (rs.next()) {
                Herramienta herramienta = new Herramienta();
                herramienta.setNombreHerramienta(rs.getString(1));
                listHerramiena.add(herramienta);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }

        return listHerramiena;
    }
}
