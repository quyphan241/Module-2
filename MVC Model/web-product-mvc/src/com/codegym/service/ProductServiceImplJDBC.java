package com.codegym.service;
import com.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImplJDBC implements ProductService{
    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "products";
        String userName = "root";
        String password = "123456";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException {
        // Khai báo class Driver cho DB MySQL
        Class.forName("com.mysql.jdbc.Driver");
        // Cấu trúc URL Connection dành cho Oracle
        // Ví dụ: jdbc:mysql://localhost:3306/simplehr
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM products";
        Connection conn= getMySQLConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String description = rs.getString("description");
            String manufactor = rs.getString("manufactor");
            products.add(new Product(id,name,price,description,manufactor));
        }
        return products;
    }

    @Override
    public void save(Product product) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO products(id,name,price,description,manufactor) values (?,?,?,?,?)";
        Connection conn = getMySQLConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setInt(3,product.getPrice());
        preparedStatement.setString(4,product.getDescription());
        preparedStatement.setString(5,product.getManufactor());
        preparedStatement.executeUpdate();
    }

    @Override
    public Product findById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT p.id, p.name,p.price,p.description,p.manufactor FROM products as p WHERE id=?";
        Connection conn = getMySQLConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        Product product = null;
        while (rs.next()){
            int idProduct = rs.getInt("p.id");
            String name = rs.getString("p.name");
            int price = rs.getInt("p.price");
            String description = rs.getString("p.description");
            String manufactor = rs.getString("p.manufactor");
            product = new Product(idProduct,name,price,description,manufactor);
        }
        return product;
    }

    @Override
    public void update(int id, Product product) throws SQLException, ClassNotFoundException {
        String sql="UPDATE  products SET id=?, name=?, price =?, description=?, manufactor=? WHERE id=?";
        Connection conn = getMySQLConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setInt(3,product.getPrice());
        preparedStatement.setString(4,product.getDescription());
        preparedStatement.setString(5,product.getManufactor());
        preparedStatement.setInt(6,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void remove(int id) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM products WHERE id=?";
        Connection conn = getMySQLConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}