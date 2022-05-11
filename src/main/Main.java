package main;

import file.FileAccountCSV;
import file.FileComputerCSV;
import manage.ManageAccount;
import manage.ManageComputer;
import manage.ManageService;
import model.Account;
import model.Computer;
import model.Service;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        ManageComputer manageComputer = new ManageComputer();
        ManageAccount manageAccount = new ManageAccount();
        ManageService manageService = new ManageService();
        int choice;
        while (true) {
            System.out.println(">>>>>>>>Menu<<<<<<<<<");
            System.out.println("|   1. Đăng nhập!   |");
            System.out.println("|    2. Đăng ký!    |");
            System.out.println("|     0. Thoát      |");
            System.out.println("---------------------");
            System.out.println("Nhập vào lựa chọn!");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Đăng nhập");
                    System.out.println("Nhập vào usn: ");
                    String usn = scanner.nextLine();
                    System.out.println("Nhập vào pass: ");
                    String pass = scanner.nextLine();
                    if (manageAccount.login(usn, pass) == 1) {
                        System.out.println("Đăng nhập thành công!");
                        System.out.println("--------------------------------------------------------");
                        int choice1 = -1;
                        while (choice1 != 0) {
                            System.out.println(">>>>>>>>>>>>>>>>>Menu Customer<<<<<<<<<<<<<<<<<<");
                            System.out.println("|              1. Xem thông tin                |\n"+
                                               "|                 2. Đổi pass                  |\n"+
                                               "|    3.Hiển thị danh sách máy có trong quán    |\n"+
                                               "|       4. Thêm 1 máy mới vào danh sách        |\n"+
                                               "|        5. Sửa đổi thông tin của máy          |\n"+
                                               "|         6. Xóa 1 máy khỏi danh sách          |\n"+
                                               "|                   7. Mở máy                  |\n"+
                                               "|               8. Thêm dịch vụ                |\n"+
                                               "|                  9. Tính Tiền                |\n"+
                                               "|          10. Xóa tài khoản đăng nhập         |\n"+
                                               "|                  0. Log out                  |\n"+
                                               "------------------------------------------------");
                            System.out.println("Nhập vào lựa chọn!");
                            choice1 = sc.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println("1. Xem thông tin");
                                    break;
                                case 2:
                                    System.out.println("Nhập pass mới");
                                    scanner.nextLine();
                                    String newPass = scanner.nextLine();
                                    ManageAccount.currentAccount.setPassword(newPass);
                                    FileAccountCSV.writeToFile(manageAccount.getAccountList());
                                    break;
                                case 3:
                                    manageComputer.print();
                                    System.out.print("Bạn có muốn xem chi tiết máy không (y/n): ");
                                    String check = scanner.nextLine().toLowerCase();
                                    if(check.equals("y")) {
                                        System.out.println("Nhập id máy muốn xem: ");
                                        int choice2 = sc.nextInt();
                                        manageComputer.getComputerList().get(manageComputer.findById(choice2)).showDetail();
                                    }
                                    break;
                                case 4:
                                    System.out.println("Nhập id máy muốn thêm: ");
                                    int idAdd = sc.nextInt();
                                    if(manageComputer.findById(idAdd) == -1) {
                                        System.out.println("Nhập trạng thái máy muốn thêm: ");
                                        String status = scanner.nextLine();
                                        System.out.println("Nhập giá máy muốn thêm: ");
                                        int price = sc.nextInt();
                                        manageComputer.add(new Computer(idAdd, status, price));
                                        FileComputerCSV.writeToFile(manageComputer.getComputerList());
                                        System.out.println("Thêm thành công!");
                                    }
                                    else {
                                        System.out.println("Máy đã có trong danh sách. Không thể thêm!");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Nhập id máy muốn sửa: ");
                                    int idUpdate = sc.nextInt();
                                    if(manageComputer.findById(idUpdate) != -1) {
                                        System.out.println("Nhập trạng thái máy muốn sửa: ");
                                        String statusUpdate = scanner.nextLine();
                                        System.out.println("Nhập giá máy muốn sửa: ");
                                        int priceUpdate = sc.nextInt();
                                        manageComputer.edit(new Computer(idUpdate, statusUpdate, priceUpdate), idUpdate);
                                        FileComputerCSV.writeToFile(manageComputer.getComputerList());
                                        System.out.println("Sửa thành công!");
                                    }
                                    else {
                                        System.out.println("Máy không có trong danh sách. Không thể sửa!");
                                    }
                                    break;
                                case 6:
                                    System.out.println("Nhập id máy muốn xóa: ");
                                    int idDelete = sc.nextInt();
                                    if(manageComputer.findById(idDelete) != -1) {
                                        manageComputer.deleteById(idDelete);
                                        FileComputerCSV.writeToFile(manageComputer.getComputerList());
                                        System.out.println("Xoá thành công!");
                                    }
                                    else {
                                        System.out.println("Máy không có trong danh sách. Không thể xóa!");
                                    }
                                    break;
                                case 7:
                                    System.out.println("Nhập id máy muốn mở: ");
                                    int idOpen = sc.nextInt();
                                    if (manageComputer.findById(idOpen) != -1) {
                                        if (manageComputer.getComputerList().get(manageComputer.findById(idOpen)).getStatus().equals("Enable")) {
                                            System.out.println("Máy đã mở!");
                                        }
                                        else {
                                            manageComputer.openComputer(idOpen);
                                            System.out.println("Đã mở!");
                                        }
                                    }
                                    else {
                                        System.out.println("Máy không có trong danh sách!");
                                    }
                                    break;
                                case 8:
                                    System.out.println("Nhập id máy muốn thêm dịch vụ: ");
                                    int idOrder = sc.nextInt();
                                    if(manageComputer.findById(idOrder) != -1) {
                                        if (manageComputer.getComputerList().get(manageComputer.findById(idOrder)).getStatus().equals("Enable")) {
                                            System.out.println(">>>>>>>>>>Menu<<<<<<<<<");
                                            for (int i = 0; i < manageService.getServiceList().size(); i++) {
                                                System.out.println("---------" + (i + 1) + "." + manageService.getServiceList().get(i).getName()
                                                        + "---------");
                                            }
                                            System.out.println("Nhập lựa chọn: ");
                                            int choice3 = sc.nextInt();
                                            if (manageService.findById(choice3) == -1) {
                                                System.out.println("Không có dịch vụ!");
                                            } else {
                                                System.out.println("Nhập số lượng: ");
                                                int quantity;
                                                do {
                                                    quantity = sc.nextInt();
                                                    if (quantity <= manageService.getServiceList().get(manageService.findById(choice3)).getQuantity()) {
                                                        manageComputer.order(choice3, new Service(choice3,
                                                                manageService.getServiceList().get(manageService.findById(choice3)).getName(),
                                                                manageService.getServiceList().get(manageService.findById(choice3)).getPrice(), quantity));
                                                        System.out.println("Thêm thành công!");
                                                    } else {
                                                        System.out.println("Không đủ số lượng mời nhập lại!");
                                                    }
                                                }
                                                while (quantity >= manageService.getServiceList().get(manageService.findById(choice3)).getQuantity());
                                            }
                                        }
                                        else {
                                            System.out.println("Máy chưa mở!");
                                        }
                                    }
                                    else {
                                        System.out.println("Máy không có trong danh sách. Không thể thêm!");
                                    }
                                    break;
                                case 9:
                                    System.out.println("Nhập id máy muốn thanh toán");
                                    int idPayment = sc.nextInt();
                                    if (manageComputer.findById(idPayment) == -1) {
                                        System.out.println("Máy không có");
                                    }
                                    else if (manageComputer.getComputerList().get(manageComputer.findById(idPayment)).getStatus().equals("Disable")) {
                                        System.out.println("Máy chưa mở!");
                                    }
                                    else {
                                        float price = manageComputer.payment(idPayment);
                                        System.out.println("Gía chơi: "+ price);
                                        System.out.println(manageComputer.getComputerList().get(manageComputer.findById(idPayment)).getOrderList());
                                        System.out.println("Gía dịch vụ: " + manageComputer.paymentService(idPayment));
                                        float totalPrice = manageComputer.paymentService(idPayment)+ price;
                                        System.out.println("Tổng: " + totalPrice );
                                    }
                                    break;
                                case 10:
                                    System.out.println("Nhập id của tài khoản cần xóa: ");
                                    int idAccount = sc.nextInt();
                                    if(manageAccount.findById(idAccount) == -1) {
                                        System.out.println("Tài khoản không tồn tại!");
                                    }
                                    else if(idAccount == ManageAccount.currentAccount.getId()) {
                                        System.out.println("Tài khoản đang đăng nhập không thể xóa!");
                                    }
                                    else {
                                        manageAccount.deleteById(idAccount);

                                        System.out.println("Xoá thành công!");
                                    }
                                case 0:
                                    ManageAccount.currentAccount = null;
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Đăng Ký");
                    System.out.println("Nhập vào id: ");
                    int id = sc.nextInt();
                    System.out.println("Nhập vào usn: ");
                    String username = scanner.nextLine();
                    System.out.println("Nhập vào pass: ");
                    String password = scanner.nextLine();
                    Account account = new Account(id, username, password);
                    manageAccount.add(account);
                    FileAccountCSV.writeToFile(manageAccount.getAccountList());
                    System.out.println("Đăng kí thành công!");
                case 0:
                    System.exit(0);
            }
        }
    }
}