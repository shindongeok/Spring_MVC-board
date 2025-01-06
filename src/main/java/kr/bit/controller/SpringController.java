package kr.bit.controller;

import kr.bit.beans.Data;
import kr.bit.vaildator.DataValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SpringController {

    @GetMapping("/t1")
    public String t1(Data data){
        return "test1";
    }

    @PostMapping("/test_proc")
    public String test_proc(@Valid Data data, BindingResult result){
        if(result.hasErrors()){
            return "test1";
        }
        return "test2";
    }


    //커스텀 유효성 검사 컨트롤러에 설정
    //컨트롤러에 속한 요청 처리 메소드가 실행되기 전에 호출 됨
    @InitBinder
    public void initBinder(WebDataBinder binder){   //2. 컨트롤러에 인터페이스 등록
        DataValidator validator = new DataValidator();

        binder.addValidators(validator);    //자동으로 데이터 유효성 검사 수행하도록 설정
    }

}
