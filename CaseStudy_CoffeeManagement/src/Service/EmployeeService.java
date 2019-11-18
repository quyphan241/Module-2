package Service;

import Model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll() throws SQLException, ClassNotFoundException;

    void save(Employee employee) throws SQLException, ClassNotFoundException;

    Employee findById(int id) throws SQLException, ClassNotFoundException;

    void update(int id, Employee employee) throws SQLException, ClassNotFoundException;

    void remove(int id) throws SQLException, ClassNotFoundException;
    List<Employee> findByName(String name) throws SQLException, ClassNotFoundException;
}
