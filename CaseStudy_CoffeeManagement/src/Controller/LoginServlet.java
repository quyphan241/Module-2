package Controller;

import Model.Login;
import Service.LoginService;
import Service.LoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService login = new LoginServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String doing =request.getParameter("doing");
//        switch (doing){
//            case "login":
        checkLogin(request,response);
        //}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doing = request.getParameter("doing");
        if (doing==null)
            doing = "";
        switch (doing){
            case "logout":
                logOut(request, response);
                break;
            default:
                goToLoginPage(request,response);
        }
    }

    public static void hadLogin(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        if (session.getAttribute("login_info") == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkAuthority(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute("login_info");
        if (login.getAuthority() < 1){
            try {
                response.sendRedirect("table_manager");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
    private void goToLoginPage(HttpServletRequest request, HttpServletResponse response){
        LoginServlet.hadLogin(request, response);
        try {
            response.sendRedirect("table_manager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response){
        String id_employee = request.getParameter("id_employee");
        String password_id_employee = request.getParameter("password_id_employee");
        String messenger = "";
        if ((!id_employee.equals("")) && (!password_id_employee.equals(""))){
            int id = Integer.parseInt(id_employee);
            try {
                if (login.checkLogin(id, password_id_employee)){
                    HttpSession session = request.getSession();
                    session.setAttribute("login_info", login.getInformation());
                }
                else {
                    messenger = "Login fail!";
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            messenger = "Input missing id or password";
        }
        if (!messenger.equals(""))
            request.setAttribute("messenger", messenger);
        goToLoginPage(request,response);
    }
    private void logOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("login_info");
        LoginServlet.hadLogin(request, response);
    }
}

