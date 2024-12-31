package kr.bit.controller;


import kr.bit.beans.Data;
import kr.bit.beans.Data2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class SpringController {

    @GetMapping("/t1")
    public String t1(){
        return "test1";
    }

    @GetMapping("/t2")
    public String t2(HttpServletRequest request){
        request.setAttribute("data1",10);
        request.setAttribute("data2",20);
        return "test2";
    }

    @GetMapping("/t3")
    public String t3(Model model){
        model.addAttribute("data1", 40);
        model.addAttribute("data2", 50);
        model.addAttribute("data3", "안녕?");
        return "test3";
    }




}
