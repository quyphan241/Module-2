package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @PostMapping("/convert")
    public String convert(@RequestParam String usd, String rate, Model model){
        int vnd = Integer.parseInt(usd)*Integer.parseInt(rate);
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "convert";
    }
}
