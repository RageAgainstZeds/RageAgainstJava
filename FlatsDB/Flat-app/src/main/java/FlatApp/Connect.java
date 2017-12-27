package FlatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class Connect {

    private static String DB_USER;
    private static String DB_PASS;
    private static String DB_CONN;

    public Connect(String user, String pass, String db_name) {
        this.DB_USER = user;
        this.DB_PASS = pass;
        this.DB_CONN = "jdbc:mysql://localhost:3306/" + db_name;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static void setDbUser(String dbUser) {
        DB_USER = dbUser;
    }

    public static String getDbPass() {
        return DB_PASS;
    }

    public static void setDbPass(String dbPass) {
        DB_PASS = dbPass;
    }

    public static String getDbConn() {
        return DB_CONN;
    }

    public static void setDbConn(String dbConn) {
        DB_CONN = dbConn;
    }

    public final Connection GetConnect() {
        try {
            Connection conn = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASS);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

