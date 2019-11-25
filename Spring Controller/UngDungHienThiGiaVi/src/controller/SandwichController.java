package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        String check = "on";
        model.addAttribute("condiment", condiment);
        model.addAttribute("check", check);
        return "save";
    }
}