package kr.bit.service;

import kr.bit.beans.User;
import kr.bit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //자동주입
    @Resource(name = "loginBean")   //RootAppContext- 세션영역에 설정한 빈 이름과 같기 때문에 주소값 자동 주입됨!
    private User loginBean;

    public void addUser(User joinBean){
        userDao.addUser(joinBean);
    }

//    public User getLoginUser(User loginProBean){
//        return userDao.getLoginUser(loginProBean);
//    }

}
