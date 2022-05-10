package file;

import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileComputerCSV {
    public static List<Computer> readFromFile() throws IOException {
        List<Computer> computers = new ArrayList<>();
        FileReader fr = new FileReader("computer.csv");
        BufferedReader br = new BufferedReader(fr);
        while ( br.readLine() != null ) {
            String[] arr = br.readLine().split(",");
            computers.add(new Computer(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2])));
        }
        return computers;
    }

    public static void writeToFile(List<Computer> computerList) throws IOException {
        FileWriter pw = new FileWriter("computer.csv");
        BufferedWriter bw = new BufferedWriter(pw);
        for (Computer computer : computerList) {
            bw.write(String.valueOf(computer));
        }
        bw.close();
    }
}
