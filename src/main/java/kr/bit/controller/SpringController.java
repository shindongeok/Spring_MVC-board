package kr.bit.controller;


import kr.bit.beans.Data;
import kr.bit.beans.Data2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class SpringController {

    @GetMapping("/t1")
    public String t1(@RequestParam Map<String, String> map,
                     @RequestParam List<String> data3){
       String data1 = map.get("data1");
       String data2 = map.get("data2");
       System.out.println(data1);
       System.out.println(data2);

       for (String str : data3){
           System.out.println(str);
       }

       return "final";
   }

    @GetMapping("/t2") //index.jsp에서 값을 넘길때 /t2 -> Data객체 필드에 넘긴값 주입됨
    public String t2(Data data, @ModelAttribute Data2 data2){
        //spring이 자동으로 data객체의 필드에 바인딩(요청 파라미터 이름과 Data클래스의 필드명이 일치해야한다)
        //@ModelAttribute 생략 가능
        System.out.println(data.getData1());
        System.out.println(data.getData2());

        for(int n : data.getData3()){
            System.out.println(n);
        }
        System.out.println(data2.getData1());
        System.out.println(data2.getData2());

        return "final";
    }
}
