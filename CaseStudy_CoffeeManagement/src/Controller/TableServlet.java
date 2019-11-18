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

@WebServlet(name = "TableServlet",urlPatterns = "/tables")
public class TableServlet extends HttpServlet {
    private TableService tableService=new TableServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                createTable(request,response);
                break;
            case "update":
                editTable(request,response);
                break;
            case "delete":
                deleteTable(request,response);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";

        }
        switch (action){
            case "create":
                createForm(request,response);
            case "view":
                break;
            case "update":
                editForm(request,response);
                break;
            case "delete":
                deleteForm(request,response);
                break;
            case "findEmptyTable":
                findEmptyTable(request,response);
                break;
            case "tableAction":
                findTableAction(request,response);
                break;
            default:
                listTable(request,response);
                break;
        }
    }
    protected  void findTableAction(HttpServletRequest request,HttpServletResponse response){
        List<Table> tables=this.tableService.tableAction();
        RequestDispatcher dispatcher;
        if(tables==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        else {
            request.setAttribute("tables",tables);
            dispatcher=request.getRequestDispatcher("table/list.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void findEmptyTable(HttpServletRequest request,HttpServletResponse response){
        List<Table> tables=this.tableService.findEmptyTable();
        RequestDispatcher dispatcher;
        if(tables==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        else {
            request.setAttribute("tables",tables);
            dispatcher=request.getRequestDispatcher("table/list.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void listTable(HttpServletRequest request,HttpServletResponse response){
        List<Table> tables=this.tableService.findAll();
        request.setAttribute("tables",tables);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("table/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void createForm(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("table/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void createTable(HttpServletRequest request,HttpServletResponse response){
        String local=request.getParameter("local");
        int capacity=Integer.parseInt(request.getParameter("capacity"));
        Table table=new Table(local,capacity);
        this.tableService.save(table);
        request.setAttribute("message","Table was created");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("table/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected void editForm(HttpServletRequest request,HttpServletResponse response){
        int id_table = Integer.parseInt(request.getParameter("id_table"));
        Table table=this.tableService.findById(id_table);
        request.setAttribute("table",table);
        RequestDispatcher dispatcher=request.getRequestDispatcher("table/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void editTable(HttpServletRequest request,HttpServletResponse response) {
        int id_table = Integer.parseInt(request.getParameter("id_table"));
        String local = request.getParameter("local");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String txt=request.getParameter("is_available");
        if(txt.equals("Open")){
            txt="0";
        }
        else {
            txt="1";
        }
        int is_available=Integer.parseInt(txt);
        Table table = new Table(local, capacity,is_available);
        this.tableService.findById(id_table);
        RequestDispatcher dispatcher;
        if(table==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        else {
            table.setLocal(local);
            table.setCapacity(capacity);
            table.setIs_available(is_available);
            this.tableService.update(id_table,table,is_available);
            request.setAttribute("table",table);
            request.setAttribute("message","Product information was updated");
            dispatcher=request.getRequestDispatcher("table/edit.jsp");

        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void deleteForm(HttpServletRequest request,HttpServletResponse response){
        int id_table=Integer.parseInt(request.getParameter("id_table"));
        RequestDispatcher dispatcher;
        Table table=this.tableService.findById(id_table);
        if(table==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        else{
            request.setAttribute("table",table);
            dispatcher=request.getRequestDispatcher("table/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void deleteTable(HttpServletRequest request,HttpServletResponse response){
        int id_table=Integer.parseInt(request.getParameter("id_table"));
        RequestDispatcher dispatcher;
        Table table=this.tableService.findById(id_table);
        if(table==null){
            dispatcher=request.getRequestDispatcher("error-404.jsp");
        }
        else{
            this.tableService.remove(id_table);
            dispatcher=request.getRequestDispatcher("table/delete.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
