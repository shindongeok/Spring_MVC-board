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

    //회원가입
    public void addUser(User joinBean){
        userDao.addUser(joinBean);
    }

    //
    public void getLoginUser(User loginProBean){

        User loginProBean2 = userDao.getLoginUser(loginProBean);
        //user_idx, user_name
        if(loginProBean2 != null){
            // 로그인이 되어 있는 사람의 idx값 가져와서 세션영역에 담아둔 loginProBean에 넣어주겠다!!(계속 유지를 위해 저장)
            loginBean.setUser_idx(loginProBean2.getUser_idx());
            loginBean.setUser_name(loginProBean2.getUser_name());
            loginBean.setUserLogin(true); // 로그인이 되어있는 상태이므로 true

            //비번, 아이디가 일치하면 -> 로그인이 된 상태라면
            //세션영역에 담은  loginProBean객체로부터  idx,  name, 로그인 여부확인을 설정한다.

        }
    }
    // String -> boolean 타입 변경
    public boolean existId(String user_id){
       String user_name = userDao.existId(user_id);
       if(user_name==null){
           return true; //사용할 수 있는 아이디이다. true
       }
       return false;    //사용할 수 없는 아이디이다. false
    }


    public void getModifyUser(User modifyBean){
        User user=userDao.getModifyUser(loginBean.getUser_idx());
        //로그인한 사람의 idx기준으로 아이디, 이름 추출해서
        modifyBean.setUser_id(user.getUser_id());
        modifyBean.setUser_name(user.getUser_name());
        modifyBean.setUser_idx(user.getUser_idx());

    }

    public void modifyUser(User modifyBean){

        modifyBean.setUser_idx(loginBean.getUser_idx());

        userDao.modifyUser(modifyBean);
    }

}
