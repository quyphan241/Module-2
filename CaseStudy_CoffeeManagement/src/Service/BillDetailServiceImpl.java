package Service;

import Model.Bill;
import Model.BillDetail;
import Utils.BillDetailDB;
import Utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDetailServiceImpl implements BillDetailService {
    @Override
    public List<BillDetail> findAll(int id_bill_) throws SQLException, ClassNotFoundException {
       return BillDetailDB.findAll(id_bill_);
    }

    @Override
    public void save(BillDetail billDetail) {

    }

    @Override
    public BillDetail findById(int id) {
        return null;
    }

    @Override
    public void update(int id, BillDetail billDetail) {

    }

    @Override
    public void remove(int id) {

    }
}
