package ua.com.orders;

import ua.com.orders.tables.Goods;

import java.sql.Connection;

public class ImplemetsGoodsDAO extends AbstractDAO<Integer, Goods> {
    public ImplemetsGoodsDAO(Connection conn, String table) { super(conn, table); }
}
