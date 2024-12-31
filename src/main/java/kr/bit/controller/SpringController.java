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

    @PostMapping("/t1")
    public String t1(@ModelAttribute Data data){


        return "/test1";
    }

    @PostMapping("t2")
    public String t2(@ModelAttribute("test") Data data){
        return "test2";
    }
}
