package kr.bit.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

    @GetMapping("/t1")
    public String t1(){
        return "test1";
    }

    @GetMapping("/t2")
    public String t2(){
        return "test2";
    }

    @GetMapping("/s1/t3")
    public String t3(){
        return "test3";
    }

    @GetMapping("/s1/t4")
    public String t4(){
        return "test4";
    }
}
