package ua.com.orders;


import ua.com.orders.tables.Orders;

import java.sql.Connection;

public class ImplemetsOrdersDAO extends AbstractDAO<Integer, Orders> {
    public ImplemetsOrdersDAO(Connection conn, String table) { super(conn, table); }
}
