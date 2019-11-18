package Service;

import Model.Bill;

import java.sql.SQLException;
import java.util.List;

public interface BillService {
    List<Bill> findAll() throws SQLException, ClassNotFoundException;

    void save(Bill bill);

    Bill findByIdTable(int idTable) throws SQLException, ClassNotFoundException;

    void update(int id, Bill bill);

    void remove(int id);
}
