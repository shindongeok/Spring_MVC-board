package kr.bit.controller;

import kr.bit.beans.BoardInfo;
import kr.bit.service.TopMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
