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
import model.EstadoVehiculo;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author i7sra
 */
public class EstadoVehiculoDAO implements IDAO<EstadoVehiculo, Integer> {

    private final String SQL_FINDALL = "SELECT checklist FROM estado_vehiculo";

    private MotorSQL motorSQL;

    public EstadoVehiculoDAO() {
        motorSQL = ConnectionFactory.selectDb();

    }

    // SELECT checklist FROM estado_vehiculo
    @Override
    public ArrayList<EstadoVehiculo> findAll(EstadoVehiculo bean) {
        ArrayList<EstadoVehiculo> listEstadoVehiculo = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            motorSQL.connect();
            System.out.println(sql);

            ResultSet rs = motorSQL.
                    executeQuery(sql);

            while (rs.next()) {
                EstadoVehiculo estadoVehiculo = new EstadoVehiculo();
                estadoVehiculo.setEstado(rs.getString(1));
                listEstadoVehiculo.add(estadoVehiculo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }
        return listEstadoVehiculo;
    }
}
