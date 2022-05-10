package file;

import model.Account;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccountCSV {
    public static List<Account> readFromFile() throws IOException {
        List<Account> accounts = new ArrayList<>();
        FileReader fr = new FileReader("account.csv");
        BufferedReader br = new BufferedReader(fr);
        while ( br.readLine() != null ) {
            String[] arr = br.readLine().split(",");
            accounts.add(new Account(Integer.parseInt(arr[0]), arr[1], arr[2]));
        }
        return accounts;
    }

    public static void writeToFile(List<Account> accountList) throws IOException {
        FileWriter pw = new FileWriter("account.csv");
        BufferedWriter bw = new BufferedWriter(pw);
        for (Account account : accountList) {
            bw.write(String.valueOf(account));
        }
        bw.close();
    }
}
