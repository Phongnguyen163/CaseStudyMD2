package model;

import manage.ManageService;

import java.time.LocalDateTime;

public class Computer {
    private int id;
    private String status;
    private int price;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    ManageService manageService = new ManageService();

    public Computer() {
    }

    public Computer(int id, String status,int price, LocalDateTime openTime, LocalDateTime closeTime) {
        this.id = id;
        this.status = status;
        this.openTime = openTime;
        this.closeTime = closeTime;
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

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Id=" + id +
                ", status='" + status + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}
