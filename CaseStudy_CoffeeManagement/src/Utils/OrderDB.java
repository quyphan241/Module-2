package Utils;

import Model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDB {
    private static String
            getBill = "SELECT id_bill,time_enter,id_employee,id_table " +
                "FROM bill " +
                "WHERE time_out IS NULL AND id_bill = ?;";
    private static  String
            insertBill = "INSERT INTO bill (id_employee, id_table) VALUES (?, ?);";
    private static String
            checkBillDetail = "SELECT quantity " +
            "FROM bill_detail " +
            "WHERE Product_id_product = ? AND Bill_id_bill = ?;";
    private static String
            insertBillDetail = "INSERT INTO bill_detail (Bill_id_bill,Product_id_product,price,quantity) " +
            "VALUES (?,?,?,1);";
    private static String
            updateBillDetail ="UPDATE bill_detail SET price = ?, quantity = ? " +
                "WHERE Product_id_product = ? AND Bill_id_bill = ?;";
    private static String
            updateQuantity = "UPDATE bill_detail SET quantity = ? " +
            "WHERE Bill_id_bill = ? AND Product_id_product = ?;";
    private static String
            payBill = "UPDATE bill SET time_out = current_timestamp WHERE id_bill = ?;";
    private static String
            payTable = "UPDATE table_coffee SET is_available = ? WHERE id_table =?;";
    public static Bill getBillNotCheckout(int idBill) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(getBill);
        preparedStatement.setInt(1, idBill);
        ResultSet resultSet = preparedStatement.executeQuery();
        Bill bill = null;
        if (resultSet.next()){
            bill = new Bill();
            bill.setId_bill(resultSet.getInt("id_bill"));
            bill.setTime_enter(resultSet.getString("time_enter"));
            bill.setId_employee(resultSet.getInt("id_employee"));
            bill.setId_table(resultSet.getInt("id_table"));
        }
        connection.close();
        return bill;
    }

    public static boolean createBill(int idEmployee, int idTable) throws SQLException, ClassNotFoundException{
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertBill);
        preparedStatement.setInt(1, idEmployee);
        preparedStatement.setInt(2, idTable);
        boolean check = preparedStatement.execute();
        check = OrderDB.changeTableAvailableStatus(idTable, 0, connection);
        connection.close();
        return check;
    }

    public static boolean createBillDetail(int idBill, int idProduct, int price) throws SQLException, ClassNotFoundException{
        boolean check = false;
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(checkBillDetail);
        preparedStatement.setInt(1, idProduct);
        preparedStatement.setInt(2, idBill);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int quantity = resultSet.getInt("quantity") + 1;
            preparedStatement = connection.prepareStatement(updateBillDetail);
            preparedStatement.setInt(1, price);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, idProduct);
            preparedStatement.setInt(4, idBill);
            check = preparedStatement.execute();
        }else{
            preparedStatement = connection.prepareStatement(insertBillDetail);
            preparedStatement.setInt(1, idBill);
            preparedStatement.setInt(2, idProduct);
            preparedStatement.setInt(3, price);
            check = preparedStatement.execute();
        }
        connection.close();
        return check;
    }

    public static boolean changeQuantity(int idBill, int idProduct, int value) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuantity);
        preparedStatement.setInt(1, value);
        preparedStatement.setInt(2, idBill);
        preparedStatement.setInt(3,idProduct);
        boolean check = preparedStatement.execute();
        connection.close();
        return check;
    }

    public static boolean checkOutBill(int idBill, int idTable) throws SQLException, ClassNotFoundException{
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(payBill);
        preparedStatement.setInt(1, idBill);
        boolean check = preparedStatement.execute();

        check = OrderDB.changeTableAvailableStatus(idTable, 1, connection);

        connection.close();
        return check;
    }

    private static boolean changeTableAvailableStatus(int idTable, int status, Connection connection) throws SQLException, ClassNotFoundException{
        PreparedStatement preparedStatement = connection.prepareStatement(payTable);
        preparedStatement.setInt(1, status);
        preparedStatement.setInt(2, idTable);
        boolean check = preparedStatement.execute();
        return check;
    }
}
