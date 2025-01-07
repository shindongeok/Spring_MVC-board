package kr.bit.controller;

import com.mysql.cj.Session;
import kr.bit.beans.User;
import kr.bit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;    //컨트롤러 전후단계 - 비즈니스로직(service)

    @GetMapping("/join")
    public String join(@ModelAttribute("joinBean") User joinBean){
        return "user/join";
    }

    @PostMapping("/join_pro")
    public String join_pro(@Valid @ModelAttribute("joinBean") User joinBean, BindingResult result){

        if(result.hasErrors()){
            return "user/join";
            //에러 있으면 원래 회원가입 폼
        }
        userService.addUser(joinBean);  //db 사입(insert)
        return "user/join_success";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginProBean") User loginProBean, Model model,
                        @RequestParam(value="fail", defaultValue = "false") boolean fail){
        model.addAttribute("fail",fail);

        return "user/login";
    }

    @PostMapping("/login_pro")
    public String login_pro(@Valid @ModelAttribute("loginProBean") User loginProBean,
                            BindingResult result){

        if(result.hasErrors()){
            return "user/login";
        }
        // 로그인 성공하면
        return "user/login_success";
    }
}
