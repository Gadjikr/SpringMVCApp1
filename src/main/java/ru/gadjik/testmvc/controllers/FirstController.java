package ru.gadjik.testmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gadjikr
 */

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello " + name + " " + surname + " !");
        return "/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(
            @RequestParam(value = "name", required = false)  String name,
            @RequestParam(value = "surname",required = false) String surname){
        // It will be error if GET parameters doesn't exist, "required = false" solve this problem
        System.out.println("Bye  " + name + " " + surname + " !");
        return "/first/goodbye";
    }


}
