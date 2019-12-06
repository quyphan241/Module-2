package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/cal")
    String getIndex() {
        return "cal/index";
    }
    @PostMapping("/add")
    String add(@RequestParam String input1, String input2, Model model) {
        Float result= Float.parseFloat(input1)+Float.parseFloat(input2);
        model.addAttribute("result",result);
        String message = "Result Addition: " +result;
        model.addAttribute("message", message);
        model.addAttribute("input1", input1);
        model.addAttribute("input2", input2);
        return "cal/index";
    }
    @PostMapping("/sub")
    String sub(@RequestParam String input1, String input2, Model model) {
        Float result= Float.parseFloat(input1)-Float.parseFloat(input2);
        model.addAttribute("result",result);
        String message = "Result Subtraction: " +result;
        model.addAttribute("message", message);
        model.addAttribute("input1", input1);
        model.addAttribute("input2", input2);
        return "cal/index";
    }
    @PostMapping("/multi")
    String multi(@RequestParam String input1, String input2, Model model) {
        Float result= Float.parseFloat(input1)*Float.parseFloat(input2);
        model.addAttribute("result",result);
        String message = "Result Multiplication: " +result;
        model.addAttribute("message", message);
        model.addAttribute("input1", input1);
        model.addAttribute("input2", input2);
        return "cal/index";
    }
    @PostMapping("/div")
    String caculate(@RequestParam String input1, String input2, Model model) {
        float result= Float.parseFloat(input1)/Float.parseFloat(input2);
        model.addAttribute("result",result);
        String message = "Result Division: " +result;
        model.addAttribute("message", message);
        model.addAttribute("input1", input1);
        model.addAttribute("input2", input2);
        return "cal/index";
    }

}
