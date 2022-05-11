package file;

import model.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceCSV {
    public static List<Service> readFromFile() throws FileNotFoundException {
        File serviceFile = new File("service.csv");
        List<Service> services = new ArrayList<>();
        Scanner scanner = new Scanner(serviceFile);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            else {
                String[] arr = line.split(",");
                services.add(new Service(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
            }
        }
        return services;
    }

    public static void writeToFile(List<Service> serviceList) throws FileNotFoundException {
        File computerFile = new File("service.csv");
        PrintWriter printWriter = new PrintWriter(computerFile);
        for (Service service : serviceList) {
            printWriter.print(service);
        }
        printWriter.close();
    }
}
