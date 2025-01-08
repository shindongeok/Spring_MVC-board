package kr.bit.controller;

import kr.bit.beans.Content;
import kr.bit.service.TopMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private TopMenuService topMenuService;

    @GetMapping("/main")    //1
    public String main(@RequestParam("board_info_idx") int board_info_idx, Model model){
        model.addAttribute("board_info_idx", board_info_idx);   //1

        return "board/main";
    }

    @GetMapping("/write")
    public String write(@ModelAttribute("writeBean") Content writeBean,
                        @RequestParam("board_info_idx") int board_info_idx){

        writeBean.setContent_board_idx(board_info_idx);
        return "board/write";
    }

    @PostMapping("/write_pro")  //입력한 제목, 내용을 Context필드에 주입
    public String write_pro(@Valid @ModelAttribute("writeBean")Content writeBean,
                            BindingResult result){
        if(result.hasErrors()){
            return "board/write";
        }
        //db에 저장
        return "write_success";
    }
}
