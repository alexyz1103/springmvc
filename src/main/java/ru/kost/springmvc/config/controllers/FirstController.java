package ru.kost.springmvc.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller

public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println("Parameters of Getrequest = "+ name+" "+ surname);
        model.addAttribute("massage", "Hello, "+ name+" "+surname);

        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        double rezult;
        switch (action){
            case "multiplication":
                rezult = a*b;
                break;
            case "division":
                rezult = a/ (double) b;
                break;
            case "subtraction":
                rezult = a-b;
                break;
            case "addition":
                rezult = a+b;
                break;
            default:
                rezult = 0;
                break;
        }
        model.addAttribute("rezult", rezult);
        return "first/calculator";
    }
}
