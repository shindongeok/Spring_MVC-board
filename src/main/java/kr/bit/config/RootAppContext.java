package kr.bit.config;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

//root-context.xml
@Configuration
public class RootAppContext { //root-context.xml

    @Bean
    @RequestScope   // 요청이 발생할 때마다 Bean객체가 생성되어 자동으로 주입된다.
    public Data data(){
        return new Data();
    }

    @Bean("sbean1")
    @RequestScope
    public Data2 data2(){
        return new Data2();
    }

}
