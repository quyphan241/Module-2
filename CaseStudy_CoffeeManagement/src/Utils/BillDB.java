package Utils;

import Model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDB {
    public static List<Bill> findAll() throws SQLException, ClassNotFoundException {
//        String sql = "select * " +
//                "from bill " +
//                "inner join employee on bill.id_employee = employee.id_employee " +
//                "inner join table_coffee on bill.id_table = table_coffee.id_table";
        String sql = "select bill.id_bill, bill.time_enter,bill.time_out, bill.id_employee,bill.id_table,employee.employee_name,table_coffee.local " +
                "                from coffee.bill " +
                "                inner join coffee.employee on bill.id_employee = employee.id_employee " +
                "                inner join coffee.table_coffee on bill.id_table = table_coffee.id_table " +
                "                order by bill.id_bill desc";
        Connection cnn = MySQLConnUtils.getSqlConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Bill> list = new ArrayList<>();
        Bill bill = null;
        while (rs.next()){
            int id_bill = rs.getInt("id_bill");
            String time_enter = rs.getString("time_enter");
            String time_out = rs.getString("time_out");
            int id_employee = rs.getInt("id_employee");
            int id_table = rs.getInt("id_table");
            String name_employee = rs.getString("employee_name");
            String name_table = rs.getString("local");
            bill = new Bill(id_bill, time_enter, time_out, id_employee, id_table, name_employee, name_table);
            list.add(bill);
        }
        return list;
    }

    public static Bill findByIdTable(int idTable) throws SQLException, ClassNotFoundException {
        String getBillByTable = "SELECT id_bill,time_enter,time_out,bill.id_employee,employee_name,table_coffee.id_table " +
                "FROM bill " +
                "inner join employee on bill.id_employee = employee.id_employee " +
                "inner join table_coffee on bill.id_table = table_coffee.id_table " +
                "WHERE table_coffee.id_table = ? AND time_out IS NULL";
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(getBillByTable);
        preparedStatement.setInt(1, idTable);
        ResultSet rs = preparedStatement.executeQuery();
        Bill bill = null;
        if (rs.next()){
            int id_bill = rs.getInt("id_bill");
            String time_enter = rs.getString("time_enter");
            String time_out = rs.getString("time_out");
            int id_employee = rs.getInt("id_employee");
            int id_table = rs.getInt("id_table");
            String name_employee = rs.getString("employee_name");
            bill = new Bill(id_bill, time_enter, time_out, id_employee, id_table, name_employee, null);
        }
        return bill;
    }
}
