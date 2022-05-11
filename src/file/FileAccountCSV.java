package file;

import model.Account;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAccountCSV {
    public static List<Account> readFromFile() throws FileNotFoundException {
        File accountFile = new File("account.csv");
        List<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(accountFile);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            else {
                String[] arr = line.split(",");
                accounts.add(new Account(Integer.parseInt(arr[0]), arr[1],arr[2]));
            }
        }
        return accounts;
    }

    public static void writeToFile(List<Account> accountList) throws FileNotFoundException {
        File accountFile = new File("account.csv");
        PrintWriter printWriter = new PrintWriter(accountFile);
        for (Account account : accountList) {
            printWriter.print(account);
        }
        printWriter.close();
    }
}
