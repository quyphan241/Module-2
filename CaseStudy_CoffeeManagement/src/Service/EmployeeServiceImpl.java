package Service;

import Model.Employee;
import Utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public List<Employee> findAll() throws SQLException, ClassNotFoundException {
        String sql = "select id_employee,password,employee_name,id_card_number,birthday,gender,authority from employee where is_delete = 0";
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        ResultSet rs =preparedStatement.executeQuery();
        List<Employee> employeeList = new ArrayList<>();
        while (rs.next()){
            int id =rs.getInt("id_employee");
            String password = rs.getString("password");
            String name = rs.getString("employee_name");
            String idCardNumber = rs.getString("id_card_number");
            Date birthdate = rs.getDate("birthday");
            boolean gender= rs.getBoolean("gender");

            boolean authority=rs.getBoolean("authority");
            employeeList.add(new Employee(id,password,name,idCardNumber,birthdate,gender,authority));
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "insert into  employee (password,employee_name,id_card_number,birthday,gender,authority,is_delete)values ( ?,?,?,?,?,?,0) ";
        PreparedStatement ps = MySQLConnUtils.getSqlConnection().prepareStatement(sql);
        ps.setString(1,employee.getPassword());
        ps.setString(2,employee.getName());
        ps.setString(3,employee.getIdEmployee());
        ps.setDate(4, (java.sql.Date) employee.getBirthday());
        ps.setBoolean(5, employee.getGender());
        ps.setBoolean(6,employee.getAuthority());

        ps.executeUpdate();
    }

    @Override
    public Employee findById(int id) throws SQLException, ClassNotFoundException {
       String sql = "select * from employee where id_employee = ?";
       PreparedStatement ps = MySQLConnUtils.getSqlConnection().prepareStatement(sql);
       ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Employee employee = null;
        while (rs.next()){
            int idEmployee = rs.getInt("id_employee");
            String password = rs.getString("password");
            String name = rs.getString("employee_name");
            String idCardNumber = rs.getString("id_card_number");
            Date birthday = rs.getDate("birthday");
            boolean gender = rs.getBoolean("gender");
            boolean authority = rs.getBoolean("authority");
            employee = new Employee(idEmployee,password,name,idCardNumber,birthday,gender,authority);
        }
        return employee;
    }

    @Override
    public void update(int id, Employee employee) throws SQLException, ClassNotFoundException {
        String sql  = "update employee set password = ?, employee_name = ?, id_card_number=?, birthday = ?, gender=?, authority =? where id_employee = ?";
        PreparedStatement ps = MySQLConnUtils.getSqlConnection().prepareStatement(sql);
        ps.setString(1, employee.getPassword());
        ps.setString(2, employee.getName());
        ps.setString(3,  employee.getIdEmployee());
        ps.setDate(4,  employee.getBirthday());
        ps.setBoolean(5,employee.getGender());
        ps.setBoolean(6,employee.getAuthority());
        ps.setInt(7,id);
        ps.executeUpdate();

    }

    @Override
    public void remove(int id) throws SQLException, ClassNotFoundException {
        String sql = "update employee set is_delete =? where id_employee = ?";
        PreparedStatement ps = MySQLConnUtils.getSqlConnection().prepareStatement(sql);
        ps.setInt(1,1);
        ps.setInt(2,id);
        ps.executeUpdate();
    }

    @Override
    public List<Employee> findByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "select * FROM employee where employee_name like ?" ;
        PreparedStatement ps = MySQLConnUtils.getSqlConnection().prepareStatement(sql);
        ps.setString(1, "%" + name + "%");
        ResultSet rs = ps.executeQuery();
        List<Employee> employees = new ArrayList<>();
        while (rs.next()){
            int id =rs.getInt("id_employee");
            String password = rs.getString("password");
            String names = rs.getString("employee_name");
            String idCardNumber = rs.getString("id_card_number");
            Date birthdate = rs.getDate("birthday");
            boolean gender= rs.getBoolean("gender");

            boolean authority=rs.getBoolean("authority");
            employees.add(new Employee(id,password,names,idCardNumber,birthdate,gender,authority));

        }return  employees;

    }
}
