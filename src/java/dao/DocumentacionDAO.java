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
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author i7sra
 */
public class DocumentacionDAO implements IDAO<Documentacion, Integer> {

    private final String SQL_DOCUMENTACION_MATRICULA_AUTOBOMBA = "SELECT documentacion.documento1 FROM autobomba "
            + "JOIN conjunto_documentacion on autobomba.id_documentacion=conjunto_documentacion.id_conjunto_documentacion "
            + "JOIN documentacion on conjunto_documentacion.id_conjunto_documentacion=documentacion.conjunto_documentacion "
            + "where autobomba.matricula = '";
    private final String SQL_DOCUMENTACION_MATRICULA_VEHICULO = "SELECT documentacion.documento1 FROM vehiculo "
            + "JOIN conjunto_documentacion on conjunto_documentacion.id_conjunto_documentacion=vehiculo.id_documentacion "
            + "JOIN documentacion on conjunto_documentacion.id_conjunto_documentacion=documentacion.conjunto_documentacion "
            + "where vehiculo.matricula= '";

    private final String SQL_FINDALL = "SELECT documento1 FROM documentacion ";

    private MotorSQL motorSQL;

    public DocumentacionDAO() {
        motorSQL = ConnectionFactory.selectDb();

    }

    /*
        SELECT documentacion.documento1 FROM autobomba
        JOIN conjunto_documentacion on autobomba.id_documentacion=conjunto_documentacion.id_conjunto_documentacion
        JOIN documentacion on conjunto_documentacion.id_conjunto_documentacion=documentacion.conjunto_documentacion
        where autobomba.matricula = ''
        UNION
        SELECT documentacion.documento1 FROM vehiculo 
        JOIN conjunto_documentacion on conjunto_documentacion.id_conjunto_documentacion=vehiculo.id_documentacion 
        JOIN documentacion on conjunto_documentacion.id_conjunto_documentacion=documentacion.conjunto_documentacion 
        where vehiculo.matricula= ''
     */
    public ArrayList<Documentacion> buscarDocumentacionMatricula(Autobomba autobomba) {
        ArrayList<Documentacion> listDocumentacion = new ArrayList<>();
        String sql = SQL_DOCUMENTACION_MATRICULA_AUTOBOMBA;

        try {
            motorSQL.connect();
            if (autobomba != null) {
                sql += autobomba.getMatricula() + "'" + " UNION "
                        + SQL_DOCUMENTACION_MATRICULA_VEHICULO + autobomba.getMatricula() + "'";
            }
            System.out.println(sql);

            ResultSet rs = motorSQL.
                    executeQuery(sql);
            while (rs.next()) {
                Documentacion documentacion = new Documentacion();
                documentacion.setDocumento(rs.getString(1));
                listDocumentacion.add(documentacion);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }

        return listDocumentacion;
    }

    // SELECT documento1 FROM documentacion 
    @Override
    public ArrayList<Documentacion> findAll(Documentacion bean) {
        ArrayList<Documentacion> listDocumentacion = new ArrayList<>();
        String sql = SQL_FINDALL;

        try {
            motorSQL.connect();

            System.out.println(sql);

            ResultSet rs = motorSQL.
                    executeQuery(sql);

            while (rs.next()) {
                Documentacion documentacion = new Documentacion();
                documentacion.setDocumento(rs.getString(1));
                listDocumentacion.add(documentacion);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }

        return listDocumentacion;
    }
}
