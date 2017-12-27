package FlatApp;

import com.sun.org.apache.xml.internal.security.Init;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InitParams.SetParams();
        Connect connect = new Connect(InitParams.getDbUser(), InitParams.getDbPass(), InitParams.getDbConn());
        Connection conn = connect.GetConnect();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1: show all offers");
            System.out.println("2: more specific search");
            System.out.println("end: close program");
            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    try {
                        DBCommands.viewFlats(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        DBCommands.askParam(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "end":
                    return;
                default:
                    return;
            }
        }
    }
}
