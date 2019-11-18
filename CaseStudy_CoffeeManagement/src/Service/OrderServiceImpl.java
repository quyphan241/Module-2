package Service;

import Model.Bill;
import Model.BillDetail;
import Utils.OrderDB;
import Utils.BillDetailDB;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public Bill getBillNotCheckout(int idBill) throws SQLException, ClassNotFoundException {
        return OrderDB.getBillNotCheckout(idBill);
    }

    @Override
    public List<BillDetail> getAllDetailOfBill(int idBill) throws SQLException, ClassNotFoundException {
        return BillDetailDB.findAll(idBill);
    }

    @Override
    public boolean createBill(int idEmployee, int idTable) throws SQLException, ClassNotFoundException {
        return OrderDB.createBill(idEmployee, idTable);
    }

    @Override
    public boolean addBillDetail(int idBill, int idProduct, int price) throws SQLException, ClassNotFoundException {
        return OrderDB.createBillDetail(idBill, idProduct, price);
    }

    @Override
    public boolean changeBillDetailQuantity(int idBill, int idProduct, int value) throws SQLException, ClassNotFoundException {
        return OrderDB.changeQuantity(idBill, idProduct, value);
    }

    @Override
    public boolean payBill(int idBill, int idTable) throws SQLException, ClassNotFoundException {
        return OrderDB.checkOutBill(idBill, idTable);
    }
}
