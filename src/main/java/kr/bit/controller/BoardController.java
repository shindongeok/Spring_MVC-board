package kr.bit.controller;

import kr.bit.beans.Content;

import kr.bit.beans.User;
import kr.bit.service.BoardService;
import kr.bit.service.TopMenuService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private TopMenuService topMenuService;


    @Autowired
    private BoardService boardService;

    @Resource(name = "loginBean")
    private User loginBean;

    @GetMapping("/main")    //1
    public String main(@RequestParam("board_info_idx") int board_info_idx, Model model){
        String boardName = boardService.getBoardInfoName(board_info_idx);
        model.addAttribute("boardName",boardName);

        model.addAttribute("board_info_idx", board_info_idx);   //1

        List<Content> contentList= boardService.getContent(board_info_idx, new RowBounds(0,5));
        model.addAttribute("contentList", contentList);

        return "board/main";
    }

    @GetMapping("/write")
    public String write(@ModelAttribute("writeBean") Content writeBean,
                        @RequestParam("board_info_idx") int board_info_idx){

        writeBean.setContent_board_idx(board_info_idx); //

        return "board/write";
    }

    //writeBean : Content클래스
    @PostMapping("/write_pro")  //입력한 제목, 내용을 Context필드에 주입
    public String write_pro(@Valid @ModelAttribute("writeBean")Content writeBean,
                            BindingResult result){
        //에러나면..
        if(result.hasErrors()){
            return "board/write";
        }
        // 성공하면.. db에 저장
        //작성하기 누르면 DB에 삽입(글제목, 내용)
        boardService.addContent(writeBean);
        return "write_success";
    }

    // 특정 게시글 보기
    @GetMapping("/read")
    public String read(@RequestParam("board_info_idx") int board_info_idx,
                       @RequestParam("content_idx") int content_idx,
                       @RequestParam("page") int page, Model model){
        model.addAttribute("board_info_idx", board_info_idx);
        model.addAttribute("content_idx", content_idx);
        model.addAttribute("page",page);

        //
        Content readContent= boardService.getInfo(content_idx);
        model.addAttribute("readContent",readContent);

        model.addAttribute("loginBean", loginBean);



        return "board/read";
    }

    @GetMapping("/not_writer")
    public String not_writer(){
        return "board/not_writer";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("board_info_idx") int board_info_idx,
                         @RequestParam("content_idx") int content_idx,
                         @RequestParam("page") int page, Model model,
                         @ModelAttribute("modifyBean") Content modifyBean){
        model.addAttribute("board_info_idx",board_info_idx);
        model.addAttribute("content_idx",content_idx);
        model.addAttribute("page",page);

        //수정할 글정보(글쓴이, 제목, 내용)..를 가져와서 업데이트 시킨 후 뿌린다.
        //수정하려는 게시글 정보를 db에서 가져와서
        Content temp = boardService.getInfo(content_idx);

        //수정페이지에서 필요한 값을 넣기위한 세팅을 함
        //게시글 정보를 content 에 담아서 modify.jsp 로 이동
        modifyBean.setContent_writer_name(temp.getContent_writer_name());
        modifyBean.setContent_date(temp.getContent_date());
        modifyBean.setContent_subject(temp.getContent_subject());
        modifyBean.setContent_text(temp.getContent_text());
        modifyBean.setContent_writer_idx(temp.getContent_writer_idx());
        modifyBean.setContent_board_idx(temp.getContent_board_idx());
        modifyBean.setContent_idx(temp.getContent_idx());


        return "board/modify";
    }

    @PostMapping("/modify_pro")
    public String modify_pro(@Valid @ModelAttribute("modifyBean") Content modifyBean,
                             BindingResult result,
                             @RequestParam("page") int page,
                             Model model){
        model.addAttribute("page",page);

        if(result.hasErrors()){
            return "board/modify";
        }

        //업데이트 시켜줘야함 (db삽입 글수정 완료)
        boardService.modifyInfo(modifyBean);
        return "board/modify_success";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("board_info_idx") int board_info_idx,
                         @RequestParam("content_idx") int content_idx, Model model){

        boardService.deleteInfo(content_idx);
        //예) 게시글2에 있는 글 삭제했다면 글 삭제 후 게시판2로 돌아오기 위해
        model.addAttribute("board_info_idx",board_info_idx);
        //모델에 board_info_idx 넣어둠.
        return "board/delete";
    }



}
