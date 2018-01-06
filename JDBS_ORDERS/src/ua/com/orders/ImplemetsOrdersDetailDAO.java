package ua.com.orders;


import ua.com.orders.tables.Orders;
import ua.com.orders.tables.OrdersDetailed;

import java.sql.Connection;

public class ImplemetsOrdersDetailDAO extends AbstractDAO<Integer, OrdersDetailed> {
    public ImplemetsOrdersDetailDAO(Connection conn, String table) { super(conn, table); }
}
