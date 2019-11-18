package Utils;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDb {
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        String sql="SELECT id_product, product_name, price FROM product WHERE is_delete=0";
        Connection conn= MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id_product");
            String name = rs.getString("product_name");
            int price = rs.getInt("price");
            products.add(new Product(id,name,price));
        }
        return products;
    }

    public void save(Product product) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO product (product_name,price) VALUES (?,?)";
        Connection conn= MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setInt(2,product.getPrice());
        preparedStatement.executeUpdate();
    }

    public void remove(int id) throws SQLException, ClassNotFoundException {
//        String sql = "DELETE FROM product WHERE id_product=?";
        String sql = "UPDATE product SET is_delete=1 WHERE id_product=?";
        Connection conn= MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }

    public void update(int id, Product product) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE product a SET a.id_product=?, a.product_name=?, a.price=? " +
                "WHERE a.id_product=? AND a.is_delete=0";
        Connection conn= MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setInt(3,product.getPrice());
        preparedStatement.setInt(4,id);
        preparedStatement.executeUpdate();
    }

    public Product findById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM product WHERE id_product=? and is_delete=0";
        Connection conn = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        Product product = null;
        while (rs.next()){
            int idProduct = rs.getInt("id_product");
            String name = rs.getString("product_name");
            int price = rs.getInt("price");
            product = new Product(idProduct,name,price);
        }
        return product;
    }

    public List<Product> findByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id_product, product_name, price FROM product WHERE product_name LIKE ? and is_delete=0";
        Connection conn = MySQLConnUtils.getSqlConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        List<Product> products=new ArrayList<>();
        preparedStatement.setString(1,"%"+ name + "%");
        ResultSet rs = preparedStatement.executeQuery();
        Product product = null;
        while (rs.next()) {
            int idProduct = rs.getInt("id_product");
            String nameProduct = rs.getString("product_name");
            int price = rs.getInt("price");
            product = new Product(idProduct,nameProduct,price);
            products.add(product);
        }
        return products;
    }
}
