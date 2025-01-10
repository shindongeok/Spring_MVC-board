package kr.bit.service;

import kr.bit.beans.Content;
import kr.bit.beans.Page;
import kr.bit.beans.User;
import kr.bit.dao.BoardDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

    @Value("${page.pa}")
    private int page_pa;

    @Value("${page.listcount}")
    private int page_listcount;

    @Autowired
    private BoardDao boardDao;

    @Resource(name = "loginBean")
    private User loginBean;

    public void addContent(Content writeContentBean){
        //로그인한 사람의 idx값 가져와서 글자성자 idx값에 세팅
        //
        writeContentBean.setContent_writer_idx(loginBean.getUser_idx());
        boardDao.addContent(writeContentBean);
    }

    //게시판의 게시판이름 조회
    public String getBoardInfoName(int board_info_idx){
        return boardDao.getBoardInfoName(board_info_idx);
    }

    //게시판 리스트조회
    public List<Content> getContent(int board_info_idx, int page){

        //페이징 처리작업
        int start = (page-1)* page_listcount;
        System.out.println("start1234: " + start);  // 확인용 로그

        RowBounds rowBounds = new RowBounds(start, page_listcount);

        return boardDao.getContent(board_info_idx, rowBounds);
    }

    //게시글 상세조회
    public Content getInfo(int content_idx){
        return boardDao.getInfo(content_idx);
    }

    //게시글 수정(업데이트)
    public void modifyInfo(Content modifyBean){
        boardDao.modifyInfo(modifyBean);
    }

    //특정 게시글 삭제
    public void deleteInfo(int content_idx){
        boardDao.deleteInfo(content_idx);
    }
//=================================================================================
    //*페이징
    //페이지 처리를 위해 특정 게시판의 리스트 수 조회하기
    public Page getCnt(int content_board_idx, int currentPage){

        int content_cnt=boardDao.getCnt(content_board_idx);

        Page page = new Page(content_cnt, currentPage, page_listcount, page_pa);
        return page;
    }



//======================================================================================


}
