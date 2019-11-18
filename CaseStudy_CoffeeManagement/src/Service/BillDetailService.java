package Service;

import Model.Bill;
import Model.BillDetail;

import java.sql.SQLException;
import java.util.List;

public interface BillDetailService {
    List<BillDetail> findAll(int id_bill) throws SQLException, ClassNotFoundException;

    void save(BillDetail billDetail);

    BillDetail findById(int id);

    void update(int id, BillDetail billDetail);

    void remove(int id);
}
