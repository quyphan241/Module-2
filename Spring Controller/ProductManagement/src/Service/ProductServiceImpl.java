package Service;

import Model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "John", "john@codegym.vn", "Hanoi"));
        products.put(2, new Product(2, "Bill", "bill@codegym.vn", "Danang"));
        products.put(3, new Product(3, "Alex", "alex@codegym.vn", "Saigon"));
        products.put(4, new Product(4, "Adam", "adam@codegym.vn", "Beijin"));
        products.put(5, new Product(5, "Sophia", "sophia@codegym.vn", "Miami"));
        products.put(6, new Product(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void remove(int id) {

    }

}
