package main;

import file.FileAccountCSV;
import manage.ManageAccount;
import manage.ManageComputer;
import model.Account;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        ManageComputer manageComputer = new ManageComputer();
        ManageAccount manageAccount = new ManageAccount();
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Đăng nhập!");
            System.out.println("2. Đăng ký!");
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
                            System.out.println("Menu Customer");
                            System.out.println("0. Log out");
                            System.out.println("1. Xem thông tin");
                            System.out.println("2. Đổi pass");
                            System.out.println("Nhập vào lựa chọn!");
                            choice1 = scanner.nextInt();
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