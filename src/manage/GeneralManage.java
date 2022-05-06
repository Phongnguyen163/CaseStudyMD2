package manage;

public interface GeneralManage <T>{
    int findById(int id);

    void add(T t);

    void edit(T t, int id);

    void deleteById(int id);

    void print();
}
