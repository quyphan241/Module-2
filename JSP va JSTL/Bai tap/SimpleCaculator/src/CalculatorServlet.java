import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand=Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperand=Float.parseFloat(request.getParameter("secondOperand"));
        String operator=request.getParameter("operator");
        float result = Calculator.calculate(firstOperand,secondOperand,operator);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result: </h1><br>");
        writer.println(firstOperand+operator+secondOperand+"="+result);
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
