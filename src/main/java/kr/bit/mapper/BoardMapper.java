package kr.bit.mapper;


import kr.bit.beans.BoardInfo;
import kr.bit.beans.Content;
import kr.bit.beans.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface BoardMapper {

    //MyBatis 에서 사용되는 어노테이션은 주로 자동 생성된 키 값을 객체의 속성에 매핑할 때 사용
    //글이 들어가기(@insert 어노테이션) 실행전에 키를 가져온다. keyProperty 이용해서..
    //addContent 메소드가 실행되면 숫자가 1씩 증가하고 그 숫자가 게시글 번호로 대입한다.
    //useGeneratedKeys = true : 자동으로 생성하는 키 값을 MyBatis가 사용할 수 있도록 허용하겠다는 뜻.
    @Options(useGeneratedKeys = true, keyProperty = "content_idx")
    @Insert("INSERT INTO content_table (content_subject, content_text, content_writer_idx, content_board_idx, content_date) " +
            "VALUES (#{content_subject}, #{content_text}, #{content_writer_idx}, #{content_board_idx}, current_date())")    //current_data() -> 현재 날짜 반환
    void addContent(Content writeContentBean);

    // 게시판의 게시판이름 조회
    @Select("select board_info_name from board_info_table where board_info_idx=#{board_info_idx}")
    String getBoardInfoName(int board_info_idx);

    // 게시판의 게시글 리스트 조회
    @Select("select a1.content_idx, a1.content_subject, a2.user_name as content_writer_name, " +
            "date_format(a1.content_date, '%Y-%m-%d') as content_date " +
            "from content_table a1 join user_table a2 " +
            "on a1.content_writer_idx = a2.user_idx " +
            "where a1.content_board_idx = #{board_info_idx} " +
            "order by a1.content_idx desc " +
            "limit #{offset}, #{limit}")
    List<Content> getContent(@Param("board_info_idx") int board_info_idx,
                             @Param("offset") int offset,@Param("limit") int limit);

    //content_writer_idx = user_name랑 비교하기위해 조회했다.
    //특정 게시글 조회
    @Select("select a2.user_name as content_writer_name," +
            "date_format(a1.content_date, '%Y-%m-%d') as content_date," +
            "a1.content_subject, a1.content_text, a1.content_writer_idx " +
            "from content_table a1 join user_table a2 " +
            "on a1.content_writer_idx = a2.user_idx " +
            "where a1.content_idx =#{content_idx}")
    Content getInfo(int content_idx);

////    //특정 게시글 수정 업데이트!!
//    @Update("UPDATE content_table" +
//            "SET content_subject = #{content_subject}, content_text = #{content_text}" +
//            "WHERE content_idx = #{content_idx}")
//    void modifyInfo(Content modifyBean);    //컨텐트를 업데이트하는거라 객체로 메개변수?

    @Update("UPDATE content_table " +
            "SET content_subject = #{content_subject}, content_text = #{content_text} " +
            "WHERE content_idx = #{content_idx}")
    void modifyInfo(Content modifyBean);


    //특정 게시글 삭제
    @Delete("delete from content_table " +
            "where content_idx=#{content_idx}")
    void deleteInfo(int content_idx);

    //*페이징================================================================================
    //페이지 처리를 위해 특정 게시판의 리스트 수 조회하기
    @Select("select COUNT(*) " +
            "from content_table " +
            "where content_board_idx = #{content_board_idx}")
    int getCnt(int content_board_idx);

    //전체 게시글 수 조회
}
