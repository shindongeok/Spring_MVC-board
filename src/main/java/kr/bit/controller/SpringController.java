package kr.bit.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringController {

    @GetMapping("/t1")
    public String t1(HttpServletRequest request){
        String data1=request.getParameter("data1");
        String data2=request.getParameter("data2");
        String data3[]=request.getParameterValues("data3");

        System.out.println(data1);
        System.out.println(data2);
        for(String str : data3){
            System.out.println(str);
        }

        return "final";
    }

}
