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

import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author i7sra
 */
public class AutobombaDAO implements IDAO<Autobomba, Integer> {

    private final String SQL_FINDALL = "SELECT matricula, kilometros, url FROM autobomba";

    private MotorSQL motorSQL;

    public AutobombaDAO() {
        motorSQL = ConnectionFactory.selectDb();

    }

    // SELECT matricula, kilometros, url FROM autobomba
    @Override
    public ArrayList<Autobomba> findAll(Autobomba bean) {
        ArrayList<Autobomba> listAutobomba = new ArrayList<>();
        String sql = SQL_FINDALL;
        try {
            motorSQL.connect();
            ResultSet rs = motorSQL.
                    executeQuery(sql);
            while (rs.next()) {
                Autobomba autobomba = new Autobomba();
                autobomba.setMatricula(rs.getString(1));
                autobomba.setKilometros(rs.getInt(2));
                autobomba.setUrl(rs.getString(3));
                listAutobomba.add(autobomba);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }
        return listAutobomba;
    }

}
