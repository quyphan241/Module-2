package Controllers;

import Model.Product;
import Service.ProductService;
import Service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();
    @GetMapping("/products")
    public ModelAndView list(){
        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("productslist");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}