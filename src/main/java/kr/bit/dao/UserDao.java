package kr.bit.dao;

import kr.bit.beans.User;
import kr.bit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User joinBean){
        userMapper.addUser(joinBean);
    }

    public User getLoginUser(User loginProBean){
        return userMapper.getLoginUser(loginProBean);

    }
}
