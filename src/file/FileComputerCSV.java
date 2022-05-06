package file;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileComputerCSV {
    public static List<Computer> readFromFile() {
        List<Computer> computers = new ArrayList<>();
        try {
            FileOutputStream fos = new FileOutputStream("computer.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(computers);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return computers;
    }

    public static void writeToFile(List<Computer> computerList){
        try {
            FileOutputStream fos = new FileOutputStream("computer.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(computerList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
