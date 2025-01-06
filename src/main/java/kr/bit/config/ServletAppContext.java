package kr.bit.config;

import kr.bit.interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")
@ComponentScan("kr.bit.beans")
public class ServletAppContext implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/",".jsp");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
    //properties파일에 있는 값을 뷰에 출력하기 위해서
    @Bean(name="messageSource")
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource res=new ReloadableResourceBundleMessageSource();
        res.setDefaultEncoding("UTF-8");
        res.setBasenames("/WEB-INF/properties/error");
        return res;
    }

    //인터셉터 등록 -  경로와 인터셉터 설정하기 위해
    public void addInterceptors(InterceptorRegistry registry){
        WebMvcConfigurer.super.addInterceptors(registry);


        Inter1 inter1 = new Inter1();
        Inter2 inter2 = new Inter2();
        Inter3 inter3 = new Inter3();
        Inter4 inter4 = new Inter4();
        Inter5 inter5 = new Inter5();
        Inter6 inter6 = new Inter6();

        InterceptorRegistration r1 =registry.addInterceptor(inter1);
        InterceptorRegistration r2 =registry.addInterceptor(inter2);
        InterceptorRegistration r3 =registry.addInterceptor(inter3);
        InterceptorRegistration r4 =registry.addInterceptor(inter4);
        InterceptorRegistration r5 =registry.addInterceptor(inter5);
        InterceptorRegistration r6 =registry.addInterceptor(inter6);

        //interceptor가 가로채 갈 주소를 등록
//        r1.addPathPatterns("/t1");
//        r2.addPathPatterns("/t1");
//        r3.addPathPatterns("/t2");

//            r4.addPathPatterns("/t1", "/t2");
//            r5.addPathPatterns("/s1/t3", "/s1/t4");
//            r6.addPathPatterns("/*");
//            r6.addPathPatterns("/s1/*"); //s1으로 시작되어지는 경로 s1/t3, /s1/t4
            r6.addPathPatterns("/**");
            r6.excludePathPatterns("/*"); // interceptor 가 가로채가지 않을 주소 등록 /t1, /t2

    }
}
