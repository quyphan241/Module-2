package Controller;

import Model.Table;
import Service.TableService;
import Service.TableServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TableListServlet")
public class TableListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServlet.hadLogin(request,response);
        TableService tableService = new TableServiceImpl();
        List<Table> tables = tableService.findAll();
        request.setAttribute("tables", tables);

        RequestDispatcher dispatcher = request.getRequestDispatcher("table/table_list.jsp");

        try {
            dispatcher.forward(request, response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
