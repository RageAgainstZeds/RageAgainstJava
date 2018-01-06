package ua.com.orders;

import ua.com.orders.tables.Clients;
import ua.com.orders.tables.Goods;
import ua.com.orders.tables.Orders;
import ua.com.orders.tables.OrdersDetailed;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/orders_db";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "1111";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConnectThis connectThis = new ConnectThis(
                DB_CONNECTION, DB_USER, DB_PASSWORD
        );


        try(Connection conn = connectThis.getConnection()) {

            Boolean menu = true;
            while (menu == true) {
                //menu
                System.out.println("1 - add new client\n" +
                        "2 - add new item to shop\n" +
                        "3 - add new order\n" +
                        "4 - show all orders\n" +
                        "5 - exit");
                int command = sc.nextInt();
                ImplemetsClientsDAO cDao = new ImplemetsClientsDAO(conn, "clients");
                ImplemetsGoodsDAO gDao = new ImplemetsGoodsDAO(conn, "goods");
                ImplemetsOrdersDAO oDao = new ImplemetsOrdersDAO(conn, "orders");
                ImplemetsOrdersDetailDAO odDao = new ImplemetsOrdersDetailDAO(conn, "");
                switch (command) {
                    case 1:
                        //add client
                        System.out.println("Enter client name: ");
                        String name = sc.next();
                        System.out.println("Enter client second name: ");
                        String surname = sc.next();
                        System.out.println("Enter client address: ");
                        String address = sc.next();
                        System.out.println("Enter client pno number: ");
                        String phone = sc.next();

                        Clients cl = new Clients(name, surname, address, Integer.parseInt(phone));
                        cDao.add(cl);
                        break;
                    case 2:
                        //add item
                        System.out.println("Enter item name: ");
                        String gName = sc.next();
                        System.out.println("Enter item weight: ");
                        double gWeight = sc.nextDouble();
                        System.out.println("Enter item price: ");
                        double gPrice = sc.nextDouble();

                        Goods stolenGoods = new Goods(gName, gWeight, gPrice);
                        gDao.add(stolenGoods);

                        break;
                    case 3:
                        //add order

                        System.out.println("Enter item ID: ");
                        String oItemID = sc.next();
                        System.out.println("Enter client ID: ");
                        String oClientID = sc.next();

                        Orders ord = new Orders(oItemID, oClientID);
                        oDao.add(ord);
                        break;
                    case 4:
                        //show all detailed orders

                        /*List<Orders> oList = oDao.getAll(Orders.class);
                        for (Orders ordrs : oList) {
                            System.out.println(ordrs.toString());
                        }*/

                        List<OrdersDetailed> odList = odDao.joinAll(OrdersDetailed.class);
                        for (OrdersDetailed ordersDetailed : odList) {
                            System.out.println(ordersDetailed.toString());
                        }
                        break;
                    case 5:
                        //exit
                        menu = false;
                        break;
                    default:
                        break;
                }
            }

        } catch (IllegalAccessException | SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}