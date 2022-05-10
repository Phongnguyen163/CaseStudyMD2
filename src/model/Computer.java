package model;

import manage.ManageService;

import java.time.LocalDateTime;

public class Computer {
    private int id;
    private String status;
    private int price;
    LocalDateTime timeStart;
    LocalDateTime timeClose;
    ManageService manageService = new ManageService();

    public Computer() {
    }

    public Computer(int id, String status,int price) {
        this.id = id;
        this.status = status;
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
        return "Computer{" +
                "Id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
