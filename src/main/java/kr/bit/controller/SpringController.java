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


    @GetMapping("/t1")
    public String t1(Data data){ //경로
        data.setId("123");
        data.setName("신동억");
        data.setPw("123");
        data.setAdr1("우리");
        data.setAdr2("너네");
        return "test1";
    }

    @GetMapping("/t2")
    public String t2(Data data){
        data.setId("1234");
        data.setName("신동웩");
        data.setPw("1234");
        data.setAdr1("서울");
        data.setAdr2("강남");
        return "test2";
    }

    @GetMapping("/t3")
    public String t3(@ModelAttribute("modelBean") Data data){
        data.setId("댕");
        data.setName("김동익");
        data.setPw("12");
        data.setAdr1("서울");
        data.setAdr2("노랑진");
        return "test3";
    }

    @GetMapping("/t4")
    public String t4(Model model){
        Data data = new Data();
        data.setId("sd");
        data.setName("김동s익");
        data.setPw("12sd");
        data.setAdr1("서울");
        data.setAdr2("노랑진");
        model.addAttribute("modelBean",data);
        return "test4";
    }


}
