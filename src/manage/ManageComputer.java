package manage;

import model.Computer;

import java.util.ArrayList;
import java.util.List;

public class ManageComputer implements GeneralManage<Computer>{
    List<Computer> computerList = new ArrayList<>();

    public void payment() {

    }

    public int findById(int id) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void add(Computer computer) {
        computerList.add(computer);
    }

    @Override
    public void edit(Computer computer, int id) {
        computerList.set(findById(id), computer);
    }

    @Override
    public void deleteById(int id) {
        computerList.remove(findById(id));
    }

    @Override
    public void print() {
        for (Computer computer: computerList) {
            System.out.println(computer);
        }
    }
}
