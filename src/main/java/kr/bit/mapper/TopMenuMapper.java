package kr.bit.mapper;

import kr.bit.beans.BoardInfo;
import org.apache.ibatis.annotations.Select;

public interface TopMenuMapper {

    //sql문 헤더에 board_idx값 갸져오려고 조회
    @Select("select board_info_idx, board_info_name from board_info_table ")
    BoardInfo getTopMenu();
    //함수호출 시 위 쿼리문이 실행된다 -> 쿼리문 결과값이 BoardInfo에 저장된다.

}
