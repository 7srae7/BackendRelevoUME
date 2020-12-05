package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MotorMySQL extends MotorSQL {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    private static final String URL
            = "jdbc:mysql://127.0.0.1:3307/relevo";

    private static final String CONTROLADOR
            = "com.mysql.jdbc.Driver";

    private static final String USER = "root";
    private static final String PASS = "root";

    public void connect() {
        try {

            Class.forName(CONTROLADOR);

            conn = DriverManager.
                    getConnection(URL, USER, PASS);

            st = conn.createStatement();
            System.out.println("conectado");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int execute(String sql) {
        int resp = 0;
        try {
            resp = st.executeUpdate(sql);
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return resp;
    }

    public ResultSet executeQuery(String sql) {
        try {

            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();

            }
            if (st != null) {
                st.close();

            }
            if (conn != null) {
                conn.close();

            }
        } catch (SQLException ex) {

        }
    }

}
