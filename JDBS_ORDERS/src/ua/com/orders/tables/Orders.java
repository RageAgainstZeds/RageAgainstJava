package ua.com.orders.tables;

public class Orders {
    @Id
    private int id;

    private String good_id;
    private String client_id;

    public Orders(String good_id, String client_id) {
        this.good_id = good_id;
        this.client_id = client_id;
    }

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", good_id=" + good_id +
                ", client_id=" + client_id +
                '}';
    }
}
