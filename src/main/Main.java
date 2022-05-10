package main;

import file.FileAccountCSV;
import file.FileComputerCSV;
import manage.ManageAccount;
import manage.ManageComputer;
import model.Account;
import model.Computer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        ManageComputer manageComputer = new ManageComputer();
        ManageAccount manageAccount = new ManageAccount();
        int choice = -1;
        while (choice != 0) {
            System.out.println(">>>>>>>>Menu<<<<<<<<<");
            System.out.println("----1. Đăng nhập!----");
            System.out.println("-----2. Đăng ký!-----");
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
                        int choice1 = -1;
                        while (choice1 != 0) {
                            System.out.println(">>>>>>>>>>>>>>>>>Menu Customer<<<<<<<<<<<<<<<<<<");
                            System.out.println("--------------1. Xem thông tin----------------\n"+
                                               "-----------------2. Đổi pass------------------\n"+
                                               "----3.Hiển thị danh sách máy có trong quán----\n"+
                                               "-------4. Thêm 1 máy mới vào danh sách--------\n"+
                                               "--------5. Sửa đổi thông tin của máy.---------\n"+
                                               "---------6. Xóa 1 máy khỏi danh sách.---------\n"+
                                               "---------------7. Thêm dịch vụ----------------\n"+
                                               "--------8. Chỉnh sửa tính tiền theo giờ-------\n"+
                                               "------------------9. Tính Tiền----------------\n"+
                                               "--------10. Quản lý tài khoản đăng nhập-------\n"+
                                               "-----------------11. Doanh Thu----------------\n"+
                                               "------------------0. Log out------------------\n");
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
                                    break;
                                case 4:
                                    System.out.println("Nhập thông tin máy muốn thêm:");
                                    System.out.println("Nhập id máy muốn thêm: ");
                                    int id = sc.nextInt();
                                    System.out.println("Nhập trạng thái máy muốn thêm: ");
                                    String status = scanner.nextLine();
                                    System.out.println("Nhập giá máy: ");
                                    int price = sc.nextInt();
                                    manageComputer.add(new Computer(id, status, price));
                                    FileComputerCSV.writeToFile(manageComputer.getComputerList());
                                    break;
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
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập vào usn: ");
                    String username = scanner.nextLine();
                    System.out.println("Nhập vào pass: ");
                    String password = scanner.nextLine();
                    Account account = new Account(id, username, password);
                    manageAccount.add(account);
                    FileAccountCSV.writeToFile(manageAccount.getAccountList());
            }
        }
    }
}