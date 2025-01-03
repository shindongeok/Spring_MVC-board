package kr.bit.controller;


import kr.bit.beans.Data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class SpringController {


    @GetMapping("t1")
    public String t1(Data data){
        data.setStr1("str1");
        data.setStr2("str2");
        data.setStr3("str3");
        data.setStr4("str4");
        return "test1";
    }

}
