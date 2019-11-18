package Controller;

import Model.*;
import Service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private TableService tableService = new TableServiceImpl();
    private BillService billService = new BillServiceImpl();
    private BillDetailService billDetailService = new BillDetailServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doing = request.getParameter("doing");
        int idBill = Integer.parseInt(request.getParameter("billID"));
        int idTable = Integer.parseInt(request.getParameter("tableId"));

        switch (doing){
            case "changeQuantity":
                String requestQuantity = request.getParameter("quantity");
                if (!requestQuantity.equals("")){
                    int quantity = Integer.parseInt(requestQuantity);
                    int idProduct = Integer.parseInt(request.getParameter("productId"));
                    try {
                        orderService.changeBillDetailQuantity(idBill, idProduct, quantity);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                backBillDetail(request,response, idTable);
                break;
            case "addProduct":
                int idProduct = Integer.parseInt(request.getParameter("productSelect"));
                Product product = null;
                try {
                    product = productService.findById(idProduct);
                    orderService.addBillDetail(idBill,idProduct, product.getPrice());
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                backBillDetail(request,response, idTable);
                break;
            case "checkOutProduct":
                try {
                    boolean check = orderService.payBill(idBill,idTable);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                backTableManage(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServlet.hadLogin(request,response);
        String requestIdTable = request.getParameter("idTable");
        if ((requestIdTable==null) || (requestIdTable.equals(""))){
            backTableManage(request,response);
        }
        else {
            int idTable = Integer.parseInt(requestIdTable);
            HttpSession session = request.getSession();
            Login login = (Login) session.getAttribute("login_info");
            Table table = tableService.findById(idTable);
            if (table.getIs_available()==1){
                try {
                    boolean check = orderService.createBill(login.getId(),idTable);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            Bill bill = null;
            List<Product> productList = null;
            List<BillDetail> billDetailList = null;
            try {
                bill = billService.findByIdTable(idTable);
                productList = productService.findAll();
                billDetailList = billDetailService.findAll(bill.getId_bill());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("Bill/order.jsp");
            request.setAttribute("bill", bill);
            request.setAttribute("table", table);
            request.setAttribute("productList", productList);
            request.setAttribute("billDetailList", billDetailList);
            try {
                dispatcher.forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void backBillDetail(HttpServletRequest request, HttpServletResponse response, int idTable) throws ServletException, IOException {
        try {
            response.sendRedirect("order_manager?idTable=" + idTable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backTableManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.sendRedirect("table_manager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
