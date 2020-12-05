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
import model.Documentacion;
import model.EstadoVehiculo;
import model.Herramienta;
import model.Vehiculo;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author i7sra
 */
public class VehiculoDAO implements IDAO<Vehiculo, Integer> {

    private final String SQL_MATRICULAS_URL = "SELECT vehiculo.matricula, vehiculo.url, vehiculo.id_vehiculo FROM vehiculo"
            + " UNION "
            + "SELECT autobomba.matricula, autobomba.url, autobomba.id_autobomba FROM autobomba";

    private final String SQL_MATRICULA_VHICULO = "SELECT autobomba.matricula, autobomba.url FROM autobomba "
            + "WHERE autobomba.matricula LIKE ";

    private final String SQL_MATRICULA_AUTOBOMBA = " UNION "
            + "SELECT vehiculo.matricula, vehiculo.url FROM vehiculo "
            + "WHERE vehiculo.matricula LIKE ";

    private MotorSQL motorSql;

    public VehiculoDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    // SELECT autobomba.matricula, autobomba.url FROM autobomba 
    // WHERE autobomba.matricula LIKE 
    // SELECT autobomba.matricula, autobomba.url FROM autobomba 
    // WHERE autobomba.matricula LIKE 
    public ArrayList<Vehiculo> buscarVehiculoMatricula(Vehiculo matricula) {
        ArrayList<Vehiculo> listMatriculas = new ArrayList<>();
        String sql = SQL_MATRICULA_VHICULO;
        String sql2 = SQL_MATRICULA_AUTOBOMBA;

        try {
            motorSql.connect();
            if (matricula != null) {
                sql += "'%" + matricula.getMatricula() + "%'";
                sql2 += "'%" + matricula.getMatricula() + "%'";
            }

            String sqlCompleta = sql + sql2;
            System.out.println(sqlCompleta);

            ResultSet rs = motorSql.
                    executeQuery(sqlCompleta);

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setMatricula(rs.getString(1));
                vehiculo.setUrl(rs.getString(2));
                listMatriculas.add(vehiculo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }

        return listMatriculas;
    }

    //SELECT vehiculo.matricula, vehiculo.url, vehiculo.id_vehiculo FROM vehiculo
    //UNION 
    // SELECT autobomba.matricula, autobomba.url, autobomba.id_autobomba FROM autobomba
    @Override
    public ArrayList<Vehiculo> findAll(Vehiculo bean) {
        ArrayList<Vehiculo> listVehiculo = new ArrayList<>();
        String sql = SQL_MATRICULAS_URL;
        try {
            motorSql.connect();
            System.out.println(sql);

            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setMatricula(rs.getString(1));
                vehiculo.setUrl(rs.getString(2));
                vehiculo.setIdVehiculo(rs.getInt(3));
                listVehiculo.add(vehiculo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return listVehiculo;
    }
}
