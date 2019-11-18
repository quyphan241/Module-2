package Service;

import Model.Product;
import Utils.MySQLConnUtils;
import Utils.ProductDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        ProductDb productDb = new ProductDb();
        return productDb.findAll();
    }

    @Override
    public void save(Product product) throws SQLException, ClassNotFoundException {
        ProductDb productDb = new ProductDb();
        productDb.save(product);
    }

    @Override
    public void remove(int id) throws SQLException, ClassNotFoundException {
        ProductDb productDb = new ProductDb();
        productDb.remove(id);
    }

    @Override
    public void update(int id, Product product) throws SQLException, ClassNotFoundException {
        ProductDb productDb = new ProductDb();
        productDb.update(id,product);
    }

    @Override
    public Product findById(int id) throws SQLException, ClassNotFoundException {
        ProductDb productDb = new ProductDb();
        return productDb.findById(id);
    }

    @Override
    public List<Product> findByName(String name) throws SQLException, ClassNotFoundException {
        ProductDb productDb = new ProductDb();
        return productDb.findByName(name);
    }
}
