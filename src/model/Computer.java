package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int id;
    private String name;
    private String status = "Disable";
    private int price;
    LocalDateTime timeStart;
    LocalDateTime timeClose;
    List<Service> orderList = new ArrayList<>();

    public List<Service> getOrderList() {
        return orderList;
    }

    public Computer(){
    }

    public Computer(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(LocalDateTime timeClose) {
        this.timeClose = timeClose;
    }

    @Override
    public String toString() {
        return id + ","+ name +","+ price+ "\n";
    }


    public void showDetail() {
        System.out.println("Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", timeStart=" + timeStart +
                ", timeClose=" + timeClose +
                '}');
    }
}
