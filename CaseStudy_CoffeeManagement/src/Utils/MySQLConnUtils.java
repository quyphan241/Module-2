package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
    private static final String host= "localhost:3306/";
    private static final String databaseName = "coffee";
    private static final String user = "root";
    private static final String password = "123456";
    private static final String urlConnection = "jdbc:mysql://" + host + databaseName;

    public static Connection getSqlConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(urlConnection, user, password);
    }
//    public static Connection getSqlConnection()
//            throws ClassNotFoundException, SQLException {
//        String hostName = "localhost";
//        String dbName = "coffee";
//        String userName = "root";
//        String password = "Ryan_25121997";
//        return getSqlConnection(hostName, dbName, userName, password);
//    }
//
//    public static Connection getSqlConnection(String hostName, String dbName,
//                                                String userName, String password) throws SQLException,
//            ClassNotFoundException {
//        // Khai báo class Driver cho DB MySQL
//        // Việc này cần thiết với Java 5
//        // Java6 trở lên tự động tìm kiếm Driver thích hợp.
//        // Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
//        Class.forName("com.mysql.jdbc.Driver");
//
//        // Cấu trúc URL Connection dành cho MySQL
//        // Ví dụ: jdbc:mysql://localhost:3306/simplehr
//        //jdbc:mysql://localhost:3306/product
//        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
//
//        Connection conn = DriverManager.getConnection(connectionURL, userName,
//                password);
//        return conn;
//    }
}
