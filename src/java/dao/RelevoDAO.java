/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Autobomba;
import model.Relevo;
import model.Vehiculo;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author i7sra
 */
public class RelevoDAO implements IDAO<Relevo, Integer> {

    private final String SQL_RELEVO_VEHICULO = "SELECT novedades, fecha_relevo, empleo, nombre, vehiculo.matricula FROM relevo "
            + "JOIN vehiculo ON relevo.id_vehiculo=vehiculo.id_vehiculo";
  

    private final String SQL_INSERT_RELEVO = "INSERT INTO relevo (novedades, nombre, empleo, fecha_relevo, id_vehiculo, id_veh_pesado) "
            + " VALUES ('";

    private final String SQL_ULTIMO_RELEVO_VEHICULO = "SELECT  novedades, nombre, empleo, fecha_relevo, vehiculo.matricula FROM relevo "
            + " JOIN vehiculo on relevo.id_vehiculo=vehiculo.id_vehiculo "
            + " WHERE vehiculo.matricula= ";

    private final String SQL_ULTIMO_RELEVO_AUTOBOMBA = "SELECT novedades, nombre, empleo, fecha_relevo, autobomba.matricula FROM relevo "
            + "JOIN autobomba on relevo.id_veh_pesado=autobomba.id_autobomba "
            + "WHERE autobomba.matricula= ";

    private final String SQL_UPDATE_VEHICULO_MATRICULA = "UPDATE vehiculo SET kilometros = ";
    private final String SQL_UPDATE_AUTOBOMBA_MATRICUAL = "UPDATE autobomba SET kilometros = ";

    private final String SQL_ULTIMO_RELEVOS_DESC = "SELECT nombre, empleo, fecha_relevo, novedades FROM `relevo` "
            + "ORDER BY `relevo`.`id_relevo` DESC";

    private MotorSQL motorSQL;

    @Override
    public ArrayList<Relevo> findAll(Relevo bean) {
        return null;
    }

    public RelevoDAO() {
        motorSQL = ConnectionFactory.selectDb();
    }

    // SELECT nombre, empleo, fecha_relevo, novedades FROM `relevo` ORDER BY `relevo`.`id_relevo` DESC
    public ArrayList<Relevo> todosRelevosDesc() {
        ArrayList<Relevo> listRelevo = new ArrayList<>();
        String sql = SQL_ULTIMO_RELEVOS_DESC;

        try {
            motorSQL.connect();
            System.out.println(sql);
            ResultSet rs = motorSQL.executeQuery(sql);

            while (rs.next()) {
                Relevo relevo = new Relevo();
                relevo.setNombre(rs.getString(1));
                relevo.setEmpleo(rs.getString(2));
                relevo.setFechaRelevo(rs.getString(3));
                relevo.setNovedades(rs.getString(4));
                listRelevo.add(relevo);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }
        return listRelevo;
    }

    // SELECT novedades, nombre, empleo, fecha_relevo, autobomba.matricula FROM relevo 
           // JOIN autobomba on relevo.id_veh_pesado=autobomba.id_autobomba 
            //  "WHERE autobomba.matricula= 
    public ArrayList<Relevo> ultimoRelevoAutobomba(Autobomba autobomba) {
        ArrayList<Relevo> listRelevo = new ArrayList<>();
        String sql = SQL_ULTIMO_RELEVO_AUTOBOMBA;

        try {
            motorSQL.connect();
            if (autobomba != null && autobomba.getMatricula() != null) {
                sql += "'" + autobomba.getMatricula() + "'" + " ORDER BY id_relevo DESC LIMIT 1";
                System.out.println(sql);

                ResultSet rs = motorSQL.executeQuery(sql);

                while (rs.next()) {
                    Relevo relevo = new Relevo();
                    relevo.setNovedades(rs.getString(1));
                    relevo.setNombre(rs.getString(2));
                    relevo.setEmpleo(rs.getString(3));
                    relevo.setFechaRelevo(rs.getString(4));

                    Autobomba autobombaMatricula = new Autobomba();
                    autobombaMatricula.setMatricula(rs.getString(5));

                    relevo.setAutobomba(autobomba);

                    listRelevo.add(relevo);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }

        return listRelevo;
    }

    // SELECT  novedades, nombre, empleo, fecha_relevo, vehiculo.matricula FROM relevo 
            // JOIN vehiculo on relevo.id_vehiculo=vehiculo.id_vehiculo 
            // WHERE vehiculo.matricula= 
    
    // SELECT  novedades, nombre, empleo, fecha_relevo, autobomba.matricula FROM relevo 
           //  JOIN autobomba on relevo.id_veh_pesado=autobomba.id_autobomba 
           // WHERE autobomba.matricula= 
    public ArrayList<Relevo> ultimoRelevoVehiculo(Vehiculo vehiculo) {
        ArrayList<Relevo> listRelevo = new ArrayList<>();
        String sql = SQL_ULTIMO_RELEVO_VEHICULO;
        String sqlAuto = SQL_ULTIMO_RELEVO_AUTOBOMBA;
        try {
            motorSQL.connect();
            if (vehiculo != null && vehiculo.getMatricula() != null && vehiculo.getUrl().equals("Amarok")) {
                sql += "'" + vehiculo.getMatricula() + "'" + " ORDER BY id_relevo DESC LIMIT 1";
                System.out.println(sql);

                ResultSet rs = motorSQL.executeQuery(sql);

                while (rs.next()) {
                    Relevo relevo = new Relevo();
                    relevo.setNovedades(rs.getString(1));
                    relevo.setNombre(rs.getString(2));
                    relevo.setEmpleo(rs.getString(3));
                    relevo.setFechaRelevo(rs.getString(4));

                    Vehiculo vehiculoMatricula = new Vehiculo();
                    vehiculoMatricula.setMatricula(rs.getString(5));

                    relevo.setVehiculo(vehiculo);

                    listRelevo.add(relevo);

                }
            } else {
                sqlAuto += "'" + vehiculo.getMatricula() + "'" + " ORDER BY id_relevo DESC LIMIT 1";
                System.out.println(sqlAuto);

                ResultSet rs = motorSQL.executeQuery(sqlAuto);

                while (rs.next()) {
                    Relevo relevo = new Relevo();
                    relevo.setNovedades(rs.getString(1));
                    relevo.setNombre(rs.getString(2));
                    relevo.setEmpleo(rs.getString(3));
                    relevo.setFechaRelevo(rs.getString(4));

                    Vehiculo vehiculoMatricula = new Vehiculo();
                    vehiculoMatricula.setMatricula(rs.getString(5));

                    relevo.setVehiculo(vehiculo);

                    listRelevo.add(relevo);

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }

        return listRelevo;

    }

    //INSERT INTO relevo (novedades, nombre, empleo, fecha_relevo, id_vehiculo, id_veh_pesado) 
           // VALUES (
    //UPDATE vehiculo SET kilometros =  WHERE matricula ='
    public int insertarRelevo(Relevo relevo) {
        int resp = 0;
        int resp2 = 0;
        try {
            motorSQL.connect();

            if (relevo != null) {

                if (relevo.getVehiculo() != null && relevo.getVehiculo().getIdVehiculo() > 0) {
                    String sql = SQL_INSERT_RELEVO
                            + relevo.getNovedades() + "', '"
                            + relevo.getNombre() + "', '"
                            + relevo.getEmpleo() + "', '"
                            + relevo.getFechaRelevo() + "', "
                            + relevo.getVehiculo().getIdVehiculo() + ", "
                            + "null);";
                    String sqlUpdate = SQL_UPDATE_VEHICULO_MATRICULA + relevo.getKilometros()
                            + " WHERE id_vehiculo =" + relevo.getVehiculo().getIdVehiculo() + ";";
                    System.out.println(sql);
                    System.out.println(sqlUpdate);
                    resp = motorSQL.execute(sql);
                    resp2 = motorSQL.execute(sqlUpdate);
                }

                if (relevo.getAutobomba().getIdAutobomba() > 0) {
                    String sql = SQL_INSERT_RELEVO
                            + relevo.getNovedades() + "', '"
                            + relevo.getNombre() + "', '"
                            + relevo.getEmpleo() + "', '"
                            + relevo.getFechaRelevo() + "', "
                            + "null " + ", "
                            + relevo.getAutobomba().getIdAutobomba() + ");";

                    String sqlUpdate = SQL_UPDATE_AUTOBOMBA_MATRICUAL + relevo.getKilometros()
                            + " WHERE id_autobomba =" + relevo.getAutobomba().getIdAutobomba() + ";";
                    System.out.println(sql);
                    System.out.println(sqlUpdate);
                    resp = motorSQL.execute(sql);
                    resp2 = motorSQL.execute(sqlUpdate);

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }

        if (resp > 0 && resp2 > 0) {

            System.out.println("Relevo guardado con éxito con éxito");
        }

        return resp;

    }

    //SELECT novedades, fecha_relevo, empleo, nombre, vehiculo.matricula FROM relevo 
          //  JOIN vehiculo ON relevo.id_vehiculo=vehiculo.id_vehiculo 
    public ArrayList<Relevo> listaRelevoVehiculo() {
        ArrayList<Relevo> listRelevo = new ArrayList<>();
        String sql = SQL_RELEVO_VEHICULO;

        try {
            motorSQL.connect();

            ResultSet rs = motorSQL.executeQuery(sql);

            while (rs.next()) {
                Relevo relevo = new Relevo();
                relevo.setNovedades(rs.getString(1));
                relevo.setFechaRelevo(rs.getString(2));
                relevo.setEmpleo(rs.getString(3));
                relevo.setNombre(rs.getString(4));

                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setMatricula(rs.getString(5));

                relevo.setVehiculo(vehiculo);

                listRelevo.add(relevo);
            }

            System.out.println(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSQL.disconnect();
        }

        return listRelevo;
    }

}
