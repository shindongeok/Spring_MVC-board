package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//페이지 이동 경로로 사용 페이지 핸들러 역할
//클라이언트의 요청 처리, 뷰 반환
@Controller
public class HomeController {

    //http://localhost:8081/Java_Setting/
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(){   //핸들러 메소드
        return "redirect:/main"; //main.jsp를 첫 화면으로 설정
    }


}
