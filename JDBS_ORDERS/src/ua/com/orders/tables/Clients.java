package ua.com.orders.tables;

public class Clients {
    @Id
    private int id;

    private String first_name;
    private String sur_name;
    private String address;
    private int phone;

    public Clients(String first_name, String sur_name, String address, int phone) {
        this.first_name = first_name;
        this.sur_name = sur_name;
        this.address = address;
        this.phone = phone;
    }

    public Clients() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSur_name() {
        return sur_name;
    }

    public void setSur_name(String sur_name) {
        this.sur_name = sur_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String  toString() {
        return "Clients{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", sur_name='" + sur_name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
