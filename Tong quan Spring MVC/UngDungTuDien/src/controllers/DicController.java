package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DicController {
    @GetMapping("/dic")
    public String dictionary(){
        return "index";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam String input, Model model) {
        Map<String, String> dic = new HashMap<>();
        dic.put("One", "Mot");
        dic.put("Book", "Sach");
        dic.put("Computer","May Tinh");
        dic.put("Cat","Meo");
        dic.put("Dog","Cho");
        String trans = dic.get(input);
        model.addAttribute("input",input);
        if (trans== null) {
            trans="Not found";
        }
        model.addAttribute("result",trans);
        return "index";

    }
}
