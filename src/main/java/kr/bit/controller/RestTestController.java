package kr.bit.controller;

import kr.bit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//restAPI는 보통 주소로 보냄!!
@RestController
public class RestTestController {

    @Autowired
    private UserService userService;

    // 데이터만 리턴 받겠다.!!
    // 테이터를 true / false 로 출력!
    //@PathVariable -> url로 값 추출할때 사용!!!
    @GetMapping("/user/chexistId/{user_id}")
    public String existId(@PathVariable String user_id){
        boolean chk = userService.existId(user_id);
        //문자열이라 "" 이게 필요하다.
        return chk+"";
    }
}
