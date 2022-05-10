package manage;

import file.FileAccountCSV;
import model.Account;

import java.io.IOException;
import java.util.List;

public class ManageAccount implements GeneralManage <Account>{
    List<Account> accountList;

    public static Account currentAccount = null;

    public ManageAccount() throws IOException {
        accountList = FileAccountCSV.readFromFile();
    }

    public int login(String username, String password) {
        for (Account account: accountList) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                currentAccount = account ;
                return 1;
            }
        }
        return 0;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void add(Account account) {
        accountList.add(account);
    }

    @Override
    public void edit(Account account, int id) {
        accountList.set(findById(id), account);
    }

    @Override
    public void deleteById(int id) {
        accountList.remove(findById(id));
    }

    @Override
    public void print() {
        for (Account a : accountList) {
            System.out.println(a);
        }
    }
}
