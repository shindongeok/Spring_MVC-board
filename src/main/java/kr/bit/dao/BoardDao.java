package kr.bit.dao;

import kr.bit.beans.BoardInfo;
import kr.bit.beans.Content;
import kr.bit.mapper.BoardMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    private BoardMapper boardMapper;

    public void addContent(Content writeContentBean){
        boardMapper.addContent(writeContentBean);
    }

    public String getBoardInfoName(int board_info_idx){
        return boardMapper.getBoardInfoName(board_info_idx);
    }

    //RowBounds 클래스에 제공하는 getOffset() getLimit()
    //RowBounds : mybatis 에서 제공하는 페이징 처리 도구
    //getOffset(시작위치), getLimit(조회할 데이터 수)
    //예) RowBounds rowBounds = new RowBounds(0,5);
    public List<Content> getContent(int board_info_idx, RowBounds rowBounds){
        return boardMapper.getContent(board_info_idx,rowBounds.getOffset(), rowBounds.getLimit());
    }

    // 게시글 상세조회
    public Content getInfo(int content_idx){
        return boardMapper.getInfo(content_idx);
    }

    //게시글 수정(업데이트)
    public void modifyInfo(Content modifyBean){
        boardMapper.modifyInfo(modifyBean);
    }

    //특정 게시글 삭제
    public void deleteInfo(int content_idx){
        boardMapper.deleteInfo(content_idx);
    }


}
