package ua.com.orders.tables;

public class OrdersDetailed {
    @Id
    private int id;

    private String client_name;
    private String address;
    private String name;
    private double price;

    public OrdersDetailed(String client_name, String client_address, String item_name, double item_price) {
        this.client_name = client_name;
        this.address = client_address;
        this.name = item_name;
        this.price = item_price;
    }

    public OrdersDetailed() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrdersDetailed{" +
                "id=" + id +
                ", client_name='" + client_name + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
