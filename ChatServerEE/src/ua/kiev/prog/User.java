package ua.kiev.prog;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Integer> rooms;
    private String status;

    public User(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        rooms.add(0); // 0 - no room
        this.status = "Online";
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Integer> rooms) {
        this.rooms = rooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
