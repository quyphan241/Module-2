package Service;

import Model.Bill;
import Utils.BillDB;
import Utils.MySQLConnUtils;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillServiceImpl implements BillService {
    @Override
    public List<Bill> findAll() throws SQLException, ClassNotFoundException {
       return BillDB.findAll();
    }

    @Override
    public void save(Bill bill) {

    }

    @Override
    public Bill findByIdTable(int idTable) throws SQLException, ClassNotFoundException {
        return BillDB.findByIdTable(idTable);
    }

    @Override
    public void update(int id, Bill bill) {

    }

    @Override
    public void remove(int id) {

    }
}
