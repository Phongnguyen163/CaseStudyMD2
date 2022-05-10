package file;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileComputerCSV {
    public static List<Computer> readFromFile() throws FileNotFoundException {
        File computerFile = new File("computer.csv");
        List<Computer> computers = new ArrayList<>();
        Scanner scanner = new Scanner(computerFile);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            else {
                String[] arr = line.split(",");
                computers.add(new Computer(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2])));
            }
        }
        return computers;
    }

    public static void writeToFile(List<Computer> computerList) throws FileNotFoundException {
        File accountFile = new File("computer.csv");
        PrintWriter printWriter = new PrintWriter(accountFile);
        for (Computer computer : computerList) {
            printWriter.print(computer);
        }
        printWriter.close();
    }
}
