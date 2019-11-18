package Utils;

import Model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDb {
    private static String findEmployee = "SELECT id_employee, employee_name, authority " +
            "FROM employee " +
            "WHERE id_employee = ? and password = ? and is_delete = false";
    public static Login checkLogin(int id, String password) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(findEmployee);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, password);
        ResultSet results = preparedStatement.executeQuery();
        Login information = null;
        if (results.next()){
            information = new Login(results.getInt("id_employee"),results.getString("employee_name"), results.getByte("authority"));
        }
        connection.close();
        return information;
    }
}
