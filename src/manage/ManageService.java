package manage;

import model.Service;

import java.util.ArrayList;
import java.util.List;

public class ManageService implements GeneralManage<Service>{
    List<Service> serviceList = new ArrayList<>();

    public int findById(int id) {
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void add(Service service) {
        serviceList.add(service);
    }

    @Override
    public void edit(Service service, int id) {
        serviceList.set(findById(id), service);
    }

    @Override
    public void deleteById(int id) {
        serviceList.remove(findById(id));
    }

    @Override
    public void print() {
        for (Service service:serviceList) {
            System.out.println(service);
        }
    }
}
