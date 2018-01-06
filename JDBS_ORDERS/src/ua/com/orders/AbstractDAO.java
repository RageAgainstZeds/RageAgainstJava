package ua.com.orders;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<M, N> {

    private final Connection conn;
    private final String table;

    public AbstractDAO(Connection conn, String table) {
        this.conn = conn;
        this.table = table;
    }

    public void add(N n) throws IllegalAccessException {
        Field[] fields = n.getClass().getDeclaredFields();

        StringBuilder names = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (Field f : fields) {
            f.setAccessible(true);

            names.append(f.getName()).append(',');
            values.append('"').append(f.get(n)).append("\",");
        }
        names.deleteCharAt(names.length() - 1); // last ','
        values.deleteCharAt(values.length() - 1); // last ','

        String sql = "INSERT INTO " + table + "(" + names.toString() +
                ") VALUES(" + values.toString() + ")";

        try (Statement st = conn.createStatement()) {
            st.execute(sql.toString());
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<N> getAll(Class<N> cls) {
        List<N> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
                    ResultSetMetaData md = rs.getMetaData();

                    while (rs.next()) {
                        N order = (N) cls.newInstance();

                        for (int i = 1; i <= md.getColumnCount(); i++) {
                            String columnName = md.getColumnName(i);

                            Field field = cls.getDeclaredField(columnName);
                            field.setAccessible(true);

                            field.set(order, rs.getObject(columnName));
                        }

                        res.add(order);
                    }
                }
            }

            return res;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<N> joinAll(Class<N> cls) {
        List<N> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("Select o.id, concat(c.first_name, ' ' , c.sur_name) as client_name, c.address, g.name, g.price from orders o \n" +
                        "\n" +
                        "Join  clients c on o.client_id=c.id \n" +
                        "\n" +
                        "Join goods g on o.good_id=g.id;")) {
                    ResultSetMetaData md = rs.getMetaData();

                    while (rs.next()) {
                        N order = (N) cls.newInstance();


                        for (int i = 1; i <= md.getColumnCount(); i++) {
                            String columnName = md.getColumnName(i);
                            System.out.println(columnName);

                            Field field = cls.getDeclaredField(columnName);
                            field.setAccessible(true);

                            field.set(order, rs.getObject(columnName));
                        }

                        res.add(order);
                    }
                }
            }

            return res;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
