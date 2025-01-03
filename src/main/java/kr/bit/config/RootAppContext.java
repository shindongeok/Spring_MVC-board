package kr.bit.config;

import kr.bit.beans.Data;

import kr.bit.beans.Data2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

//root-context.xml
@Configuration
public class RootAppContext { //root-context.xml

    @Bean
    @SessionScope   //브라우저가 서버에 최초(처음)로 요청을 보낼때 빈객체 주입된다.
    public Data data(){
        return new Data();
    }

    @Bean("session2")
    @SessionScope
    public Data2 data2(){
        return new Data2();
    }

}
