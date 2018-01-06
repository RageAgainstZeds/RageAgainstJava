package ua.com.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Bios on 29.11.2017.
 */
public class ConnectThis {
    private String url;
    private String login;
    private String password;

    public ConnectThis(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}