package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//사용자 요청이 들어오면(/spring1, get 방식))
@Controller
public class SpringController {
    // 클라이언트가 요청하는 경로
    @RequestMapping(value="/spring1", method = RequestMethod.GET)
    public String spring1(){
        //뷰로 보여줄 주소
        return "spring1";
    }

    @RequestMapping(value="/spring2", method = RequestMethod.GET)
    public String spring2(){
        return "spring2";
    }

    @RequestMapping(value = "/sub1/spring3", method = RequestMethod.GET)
    public String spring3(){
        return "/sub1/spring3";
    }
    @RequestMapping(value = "/sub1/spring4", method = RequestMethod.GET)
    public String spring4(){
        return "/sub1/spring4";
    }
}
