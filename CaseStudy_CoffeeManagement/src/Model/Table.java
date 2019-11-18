package Model;

public class Table {
    private int id_table;
    private String local;
    private int capacity;
    private int is_available;
    public Table(){

    }
    public Table(String local,int capacity){
        this.local=local;
        this.capacity=capacity;
    }
    public Table(int id_table,String local,int capacity,int is_available){
        this.id_table=id_table;
        this.local=local;
        this.capacity=capacity;
        this.is_available=is_available;
    }
    public Table(String local,int capacity,int is_available){
        this.local=local;
        this.capacity=capacity;
        this.is_available=is_available;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getIs_available() {
        return is_available;
    }

    public void setIs_available(int is_available) {
        this.is_available = is_available;
    }
}
