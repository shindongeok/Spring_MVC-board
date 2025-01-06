package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SpringController {


    @GetMapping("/t1")
    public String t1(){
       return "test1";
    }
}
