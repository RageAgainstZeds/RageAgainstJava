package FlatApp;

import java.util.Scanner;

public class InitParams {
    private static String DB_USER;
    private static String DB_PASS;
    private static String DB_CONN;

    public InitParams() {
    }

    public static void SetParams() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter DB name:");
        DB_CONN = sc.nextLine();
        System.out.println("Enter User name:");
        DB_USER = sc.nextLine();
        System.out.println("Enter password:");
        DB_PASS = sc.nextLine();
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPass() {
        return DB_PASS;
    }

    public static String getDbConn() {
        return DB_CONN;
    }
}
