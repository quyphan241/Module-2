package Model;

import java.util.Date;

public class Bill {
    private int id_bill;
    private String time_enter;
    private String time_out;
    private int id_employee;
    private int id_table;

    private String name_employee;
    private String name_table;

    public Bill() {
    }

    public Bill(int id_bill, String time_enter, String time_out, int id_employee, int id_table, String name_employee, String name_table) {
        this.id_bill = id_bill;
        this.time_enter = time_enter;
        this.time_out = time_out;
        this.id_employee = id_employee;
        this.id_table = id_table;

        this.name_employee = name_employee;
        this.name_table = name_table;
    }

    public String getName_employee() {
        return name_employee;
    }

    public void setName_employee(String name_employee) {
        this.name_employee = name_employee;
    }

    public String getName_table() {
        return name_table;
    }

    public void setName_table(String name_table) {
        this.name_table = name_table;
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
    }

    public String getTime_enter() {
        return time_enter;
    }

    public void setTime_enter(String time_enter) {
        this.time_enter = time_enter;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }
}
