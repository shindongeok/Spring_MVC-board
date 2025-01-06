package kr.bit.controller;

import kr.bit.beans.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//메소드의 반환값이 json, xml 형식 변환되어 http 응답 본문(body)으로 전송됨
//@Controller + @ResponseBody
@RestController
public class RestTestController {

    @GetMapping("/t2")
    public ResponseEntity<ArrayList<Data>> t2(){

        Data data1= new Data("spring1", 100, 1.1, false);
        Data data2= new Data("spring2", 200, 2.2, false);
        Data data3= new Data("spring3", 300, 3.3, false);

        ArrayList<Data> li = new ArrayList<>();
        li.add(data1);
        li.add(data2);
        li.add(data3);

        ResponseEntity<ArrayList<Data>> en = new ResponseEntity<>(li, HttpStatus.OK);
        return en;
    }
}
