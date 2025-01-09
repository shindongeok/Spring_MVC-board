package kr.bit.service;

import kr.bit.beans.Content;
import kr.bit.beans.User;
import kr.bit.dao.BoardDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardService {

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
    public List<Content> getContent(int board_info_idx, RowBounds rowBounds){


        return boardDao.getContent(board_info_idx, new RowBounds(0,5));
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
}
