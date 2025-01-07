package kr.bit.mapper;

import kr.bit.beans.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    @Insert("insert into user_table(user_name, user_id, user_pw) values(#{user_name}, #{user_id}, #{user_pw})")
    void addUser(User joinBean);

    @Select("select user_idx, user_name from user_table where user_id=#{user_id} and user_pw=#{user_pw}")
    User getLoginUser(User loginProBean);
}
