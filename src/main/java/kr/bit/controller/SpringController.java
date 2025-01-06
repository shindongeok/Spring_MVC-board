package kr.bit.controller;

import kr.bit.beans.Data;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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


}
