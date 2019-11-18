package Service;

import Model.Bill;
import Model.BillDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    Bill getBillNotCheckout(int idBill) throws SQLException, ClassNotFoundException;
    List<BillDetail> getAllDetailOfBill(int idBill) throws SQLException, ClassNotFoundException;
    boolean createBill(int idEmployee, int idTable) throws SQLException, ClassNotFoundException;
    boolean addBillDetail(int idBill, int idProduct, int price) throws SQLException, ClassNotFoundException;
    boolean changeBillDetailQuantity(int idBill, int idProduct, int value) throws SQLException, ClassNotFoundException;
    boolean payBill(int idBill, int idTable) throws SQLException, ClassNotFoundException;
}
