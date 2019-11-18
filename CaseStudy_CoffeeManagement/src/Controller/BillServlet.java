package Controller;

import Model.Bill;
import Model.BillDetail;
import Service.BillDetailService;
import Service.BillDetailServiceImpl;
import Service.BillService;
import Service.BillServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BillServlet" , urlPatterns = "/bills")
public class BillServlet extends HttpServlet {

    private BillService billService = new BillServiceImpl();
    private BillDetailService billDetailService = new BillDetailServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServlet.hadLogin(request,response);
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
               // showCreateForm(request, response);
                break;

            case "delete":
//                try {
//                    showDeleteForm(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
                break;

            case "view":
                try {
                    showViewForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            default:
                try {
                    listProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Bill> bills = billService.findAll();
        request.setAttribute("bills", bills);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Bill/list.jsp");

        dispatcher.forward(request,response);
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        String table = request.getParameter("table");
        String name = request.getParameter("name");
        List<BillDetail> billDetailsList = billDetailService.findAll(id);

        request.setAttribute("bills", billDetailsList);
        request.setAttribute("table",table);
        request.setAttribute("name",name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Bill/view.jsp");

        dispatcher.forward(request,response);
    }
}
