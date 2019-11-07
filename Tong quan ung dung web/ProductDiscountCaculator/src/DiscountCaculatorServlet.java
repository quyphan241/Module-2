import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountCaculatorServlet", urlPatterns = "/caculate")
public class DiscountCaculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String description = request.getParameter("percent");
        float discountPercent = Float.parseFloat(request.getParameter("percent"));
        float price = Float.parseFloat(request.getParameter("price"));
        float discountAmount = price*discountPercent/100;
        float discountPrice = price - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Discount Calculator </h1>");
        writer.println("<br>Description: "+description);
        writer.println("<br>Price: $" + price);
        writer.println("<br>Discount percent: "+discountPercent+"%");
        writer.println("<br>Discount amount: $"+discountAmount);
        writer.println("<br>Discount Price: $"+discountPrice);
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
