package ru.gadjik.testmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gadjikr
 */

@Controller
public class ThirdController {

    @GetMapping("/calculator")
    public String CalculatorPage(
            @RequestParam(value = "a", required = false) Integer a,
            @RequestParam(value = "b", required = false) Integer b,
            @RequestParam(value = "action", required = false) String action,
            Model model) {
        String message;
        // no checking "a" and "b"
        if (a != null & b != null & action != null) {
            if (action.equals("multiplication")) {
                message = "a() * b() = " + (a * b);
            }else
            if (action.equals("addition")) {
                message = "a() + b() = " + (a + b);
            } else
            if (action.equals("subtraction")) {
                message = "a() - b() = " + (a - b);
            } else
            if (action.equals("division")) {
                message = "a() / b() = " + (a / b);
            } else {
                message = "unknown action";
            }

        } else
            message = "wrong parameters ! " + "a = " + a + ", b = " + b + ", action : " + action;
        model.addAttribute("message", "Result: " + message);
        return "/third/calculator";
    }
}
