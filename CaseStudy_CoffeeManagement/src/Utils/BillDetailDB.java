package Utils;

import Model.Bill;
import Model.BillDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDB  {
    public static List<BillDetail> findAll(int id_bill_) throws SQLException, ClassNotFoundException {
        String sql = "select * from bill_detail " +
                "inner join product on bill_detail.Product_id_product = product.id_product " +
                "where bill_detail.Bill_id_bill = ?";
        Connection cnn = MySQLConnUtils.getSqlConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1,id_bill_);
        ResultSet rs = ps.executeQuery();

        List<BillDetail> list = new ArrayList<>();
        BillDetail billDetail = null;
        while (rs.next()){
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");
            int  Product_id_product = rs.getInt("Product_id_product");
            int Bill_id_bill = rs.getInt("Bill_id_bill");

            String name_product = rs.getString("product_name");

            billDetail = new BillDetail(price,quantity,Product_id_product,Bill_id_bill, name_product);
            list.add(billDetail);
        }
        return list;
        //return null;
    }
}
