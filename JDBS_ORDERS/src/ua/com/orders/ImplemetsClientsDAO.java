package ua.com.orders;

import ua.com.orders.tables.Clients;

import java.sql.Connection;

public class ImplemetsClientsDAO extends AbstractDAO<Integer, Clients> {
    public ImplemetsClientsDAO(Connection conn, String table) { super(conn, table); }
}
