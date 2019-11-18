package Controller;

import Model.Employee;
import Service.EmployeeService;
import Service.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.lang.String.valueOf;

@WebServlet(name = "EmployeeServlet",urlPatterns ="/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                try {
                    searchProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServlet.hadLogin(request,response);
        boolean check = LoginServlet.checkAuthority(request,response);
        if (check) {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    try {
                        showEditForm(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "delete":
                    try {
                        showDeleteForm(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "view":
                    try {
                        viewProducts(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "search":
                    try {
                        searchProduct(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                default:
                    try {
                        listEmployees(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
        String search = request.getParameter("search");
        List<Employee> employees = this.employeeService.findByName(search);
        RequestDispatcher dispatcher;
        request.setAttribute("employees", employees);
        dispatcher = request.getRequestDispatcher("Employees/employeeslist.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
//        response.sendRedirect("search.jsp");

    }

    private void viewProducts(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee", employee);
            dispatcher = request.getRequestDispatcher("Employees/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;

        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {

            this.employeeService.remove(id);
            try {
                response.sendRedirect("employees");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee", employee);
            dispatcher = request.getRequestDispatcher("Employees/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("birthday"));
        String id_card_number = request.getParameter("id_card_number");
        String gender = request.getParameter("gender");
        String authority = request.getParameter("authority");
        String password = request.getParameter("password");

        Employee employees = this.employeeService.findById(id);
        RequestDispatcher dispatcher;
        if(employees == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            employees.setName(name);
            employees.setPassword(password);
            employees.setBirthday(date);
            employees.setIdEmployee(id_card_number);
            employees.setId(id);
            employees.setGender(gender.equals("true"));
            employees.setAuthority(authority.equals("true"));
            this.employeeService.update(id, employees);
            request.setAttribute("employee", employees);
            request.setAttribute("message", "Employee was edited");
            dispatcher = request.getRequestDispatcher("Employees/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = this.employeeService.findById(id);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee", employee);
            dispatcher = request.getRequestDispatcher("Employees/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("birthday"));
        String id_card_number = request.getParameter("id_card_number");
        boolean gender = request.getParameter("gender").equals("true");
        boolean authority = request.getParameter("authority").equals("true");
        String password = request.getParameter("password");
        Employee employee = new Employee(password,name,date,id_card_number,gender,authority);
        this.employeeService.save(employee);
//        Products products = new Products(id, name, price, description,HSD, new Type());
//        this.productService.save(products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Employees/create.jsp");
        request.setAttribute("message", "New employee was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Employees/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        List<Employee> employees = this.employeeService.findAll();
        request.setAttribute("employees", employees);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Employees/employeeslist.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
