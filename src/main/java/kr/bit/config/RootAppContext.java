package kr.bit.config;


import kr.bit.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

//root-context.xml
@Configuration
public class RootAppContext { //root-context.xml

    //로그인된 사용자의 정보를 관리하기 위해 빈으로등록후 이름지정 세션스콥으로 지정해서 생명주기 주기.
    //loginBean 으로 빈 등록
    @Bean("loginBean")
    @SessionScope   //생명주기 세션범위안에서 계속 유지
    public User loginBean(){
        return new User();
    }

}
