package FlatApp;

import java.sql.*;
import java.util.Scanner;

public class DBCommands {
    public static void viewFlats(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM apartments");
        try {

            // table of data representing a database result set,
            ResultSet rs = ps.executeQuery(); //курсор
            try {
                // can be used to get information about the types and properties of the columns in a ResultSet object
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
    }

    public static void askParam(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many room u want?");
        String room = sc.nextLine();
        System.out.println("What minimum square u want?");
        String square = sc.nextLine();
        System.out.println("How much bloody money u ready to spent?");
        String rent = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM APARTMENTS WHERE ");
        if (room != null) {
            sb.append("ROOMS <= " + room + " ");
        }
        if (square != null) {
            sb.append("and square >= " + square + " ");
        }
        if (rent != null) {
            sb.append("and price >= " + rent + " ");
        }
        System.out.println(sb.toString());

        PreparedStatement prs = conn.prepareStatement(sb.toString());
        try {

            // table of data representing a database result set,
            ResultSet rs = prs.executeQuery(); //курсор
            try {
                // can be used to get information about the types and properties of the columns in a ResultSet object
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            prs.close();
        }
    }
}
