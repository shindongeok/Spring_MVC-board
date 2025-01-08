package kr.bit.controller;

import kr.bit.beans.User;
import kr.bit.service.UserService;
import kr.bit.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;    //컨트롤러 전후단계 - 비즈니스로직(service)

    @Resource(name = "loginBean")
    private User loginBean; //로그인 여부확인하기 위해 세션영역에 담아 놓은거 주입받음.!!

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

//    @PostMapping("/login_pro")
//    public String login_pro(@Valid @ModelAttribute("loginProBean") User loginProBean,
//                            BindingResult result){
//        // 유효성검사에 위배가 다 안되면..
//        if(result.hasErrors()){
//            return "user/login";
//        }
//        userService.getLoginUser(loginProBean); // 로그인 성공하면(id, pw 일치하면) user_idx, user_name 추출
//
//        if(loginProBean.isUserLogin()==true){
//            return "user/login_success";
//        }
//        else {
//            // id, pw 안맞으면...
//            return "user/login_fail";
//        }
//
//
//    }
@PostMapping("/login_pro")
public String login_pro(@Valid @ModelAttribute("loginProBean") User loginProBean,
                        BindingResult result){
    if(result.hasErrors()){
        return "user/login";
    }
    userService.getLoginUser(loginProBean); //로그인 성공하면(id, pw 일치하면 ) user_idx, user_name 추출

    if(loginBean.isUserLogin()==true){
        return "user/login_success";
    }
    else{
        return "user/login_fail";
    }
}

    @GetMapping("/logout")
    public String logout(){
        loginBean.setUserLogin(false);  //로그인 되어있는 상태가 아님
        return "user/logout";
    }

    //커스터마이징한 것을 등록
    // 컨트롤러 클래스 내에서 특정 데이터 바인딩과 검증 로직을 정의
    @InitBinder
    public void initBinder(WebDataBinder binder){   //2. 컨트롤러에 인터페이스 등록
        UserValidator userValidator = new UserValidator();

        binder.addValidators(userValidator);    //자동으로 데이터 유효성 검사 수행하도록 설정
    }

    @GetMapping("/not_login")
    public String not_login(){
        return "user/not_login";
    }

    //
    @GetMapping("/modify")
    public String modify(@ModelAttribute("modifyBean") User modifyBean){
        userService.getModifyUser(modifyBean);
        return "user/modify";
    }

    @PostMapping("/modify_pro")
    public String modify_pro(@Valid @ModelAttribute("modifyBean") User modifyBean,
                             BindingResult result){
        if(result.hasErrors()){
            return "user/modify";
        }
        //1.error.properties -> 정보수정에 비번맞는지 확인 비번, 비번확인
        //2.db에 수정한 값 삽입 ->
        userService.modifyUser(modifyBean);
        return "user/modify_success";
    }
}
