package manage;

import file.FileComputerCSV;
import model.Computer;
import model.Service;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ManageComputer implements GeneralManage<Computer>{
    List<Computer> computerList;

    public ManageComputer() throws FileNotFoundException {
        computerList = FileComputerCSV.readFromFile();
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void openComputer(int id) {
        computerList.get(findById(id)).setStatus("Enable");
        LocalDateTime startTime = LocalDateTime.now();
        computerList.get(findById(id)).setTimeStart(startTime);
    }

    public float payment(int id) {
        computerList.get(findById(id)).setStatus("Disable");
        LocalDateTime closeTime = LocalDateTime.now();
        computerList.get(findById(id)).setTimeClose(closeTime);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd:MM:yyyy:HH:mm:ss");
        Duration amount = Duration.between(computerList.get(findById(id)).getTimeStart(), computerList.get(findById(id)).getTimeClose());
        LocalDateTime localDateTime = LocalDateTime.of(1,1,1,0,0,0);
        LocalDateTime timePlus = localDateTime.plus(amount);
        String timeUse = timePlus.format(fmt);
        String[] arr = timeUse.split(":");
        System.out.println("Số giờ đã chơi: " + (Integer.parseInt(arr[0])-1) +" Ngày" + (Integer.parseInt(arr[3]))+ " Giờ"+
                Integer.parseInt(arr[4]) + " Phút" + Integer.parseInt(arr[5]) + " Giây");
        return (Integer.parseInt(arr[0])-1)*86400*computerList.get(findById(id)).getPrice()+
                Integer.parseInt(arr[3])*3600*computerList.get(findById(id)).getPrice()+
                Integer.parseInt(arr[4])*60*computerList.get(findById(id)).getPrice()+
                Integer.parseInt(arr[5])*computerList.get(findById(id)).getPrice();
    }

    public int paymentService(int id) {
        int priceService = 0;
        for (int i = 0; i < computerList.get(findById(id)).getOrderList().size(); i++) {
            priceService += computerList.get(findById(id)).getOrderList().get(i).getPrice() *
                    computerList.get(findById(id)).getOrderList().get(i).getQuantity();
        }
        return priceService;
    }

    public void order(int id, Service service) {
        computerList.get(findById(id)).getOrderList().add(service);
    }

    public int findById(int id) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(Computer computer) {
        computerList.add(computer);
    }

    @Override
    public void edit(Computer computer, int id) {
        computerList.set(findById(id), computer);
    }

    @Override
    public void deleteById(int id) {
        computerList.remove(findById(id));
    }

    @Override
    public void print() {
        for (Computer computer: computerList) {
            System.out.println(computer);
        }
    }
}
