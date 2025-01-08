package kr.bit.mapper;

import kr.bit.beans.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {

    @Insert("insert into user_table(user_name, user_id, user_pw) values(#{user_name}, #{user_id}, #{user_pw})")
    void addUser(User joinBean);

    //id name 조회
    @Select("select user_idx, user_name from user_table where user_id=#{user_id} and user_pw=#{user_pw}")
    User getLoginUser(User loginProBean);

    @Select("select user_name from user_table where user_id=#{user_id}")
    String existId(String user_id);

    //정보수정
    @Select("select user_id, user_name from user_table where user_idx=#{user_idx}")
    User getModifyUser(int user_idx);

    //업데이트
    @Update("update user_table set user_pw=#{user_pw} where user_idx=#{user_idx}")
    void modifyUser(User modifyBean);


}
