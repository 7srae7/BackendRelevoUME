package utils;

public class ConnectionFactory {

    public static final int db = 2;

    public static final int MYSQL_DB = 2;

    public static MotorSQL selectDb() {
        MotorSQL motorSQL = null;
        switch (db) {
            case MYSQL_DB:
                motorSQL = new MotorMySQL();
                break;

        }
        return motorSQL;
    }
}
