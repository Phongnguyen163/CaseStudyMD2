package file;

import model.Account;
import model.Computer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileAccountCSV {
    public static List<Account> readFromFile() {
        List<Account> accounts = new ArrayList<>();
        try {
            FileOutputStream fos = new FileOutputStream("account.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accounts);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public static void writeToFile(List<Account> accountList){
        try {
            FileOutputStream fos = new FileOutputStream("account.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accountList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
