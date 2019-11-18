package Model;

import java.util.Date;

public class Employee {
    private int id;
    private String password;
    private String name;
    private String idEmployee ;
    private Date birthday;
    private boolean gender;
    private boolean authority;

    public Employee(int id, String password, String name,String idEmployee , Date birthday, boolean gender, boolean authority) {
        this.idEmployee = idEmployee;
        this.password = password;
        this.name = name;
        this.id = id;
        this.birthday = birthday;
        this.gender = gender;
        this.authority = authority;
    }

    public Employee(String password, String name, java.sql.Date date, String id_card_number, boolean gender, boolean authority) {
        this.password= password;
        this.name=name;
        this.birthday = date;
        this.idEmployee = id_card_number;
        this.gender = gender;
        this.authority = authority;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getBirthday() {
        return (java.sql.Date) birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean getAuthority() {
        return authority;
    }

    public void setAuthority(boolean authority) {
        this.authority = authority;
    }
}
