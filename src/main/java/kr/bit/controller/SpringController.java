package kr.bit.controller;


import kr.bit.beans.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"sbean","sbean2"})  //지정한 이름을 세션 범위에 저장하도록 함
public class SpringController {


   @GetMapping("/t1")
    public String t1(HttpSession session){
       session.setAttribute("data","spring1");
       return "test1";
   }

    @GetMapping("/t2")
    public String t2(HttpSession session){
       session.setAttribute("data1", "spring2");
       return "redirect:/s1";
    }

    @GetMapping("/s1")
    public String s1(HttpSession session){
       String str = (String) session.getAttribute("data1");
        System.out.println(str);
        return "spring1";
    }

    @GetMapping("/t3")
    public String t3(HttpSession session){
       session.setAttribute("data1","spring3");
       return "forward:/s1";
    }

    @GetMapping("/t4")
    public String t4(HttpSession session){
        Data data = new Data();

        data.setStr1("spring4");
        data.setStr2("spring5");
        session.setAttribute("bean",data);
        return "test4";
    }

    // !! 주의 - @ModelAttribute를 활용해 객체를 생성해 반환하는 메소드를 작성해줘야지
    //          session영역으로 바뀐다(request -> session)
    @ModelAttribute("sbean")
    public Data data(){
       return new Data();   //session영역으로 부터 주입받을 수 있다.
    }

    @ModelAttribute("sbean2")
    public Data data2(){
        return new Data();   //session영역으로 부터 주입받을 수 있다.
    }

    @GetMapping("/t5")
    public String t5(@ModelAttribute("sbean")Data data,
                     @ModelAttribute("sbean2")Data data2){
       //"sbean,sbean2"라는 이름으로 session에서 가져온 객체를 data, data2에 바인딩
       data.setStr1("aa");
       data.setStr2("bb");

       data2.setStr1("cc");
       data2.setStr2("dd"); //session영역에 문자열 저장
       return "test5";
    }
    @GetMapping("/s5")
    public String s5(@ModelAttribute("sbean")Data data,
                     @ModelAttribute("sbean2")Data data2){
       return "spring5";
    }

    @GetMapping("/s4")  //저장
    public String s4(@SessionAttribute("bean") Data data){
       return "spring4";
    }
}
