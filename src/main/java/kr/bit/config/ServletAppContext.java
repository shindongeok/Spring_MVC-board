package kr.bit.config;



import kr.bit.interceptor.TopMenuInterceptor;
import kr.bit.mapper.TopMenuMapper;
import kr.bit.service.TopMenuService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")
@ComponentScan("kr.bit.dao")
@ComponentScan("kr.bit.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {


    @Value("${db.classname}")
    private String db_classname;

    @Value("${db.url}")
    private  String db_url;

    @Value("${db.username}")
    private String db_username;

    @Value("${db.password}")
    private String db_password;

    //인터셉터를하기위해 서비스 주입
    @Autowired
    private TopMenuService topMenuService;

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

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName(db_classname);
        source.setUrl(db_url);
        source.setUsername(db_username);
        source.setPassword(db_password);

        return source;
    }

    @Bean
    public SqlSessionFactory factory(BasicDataSource source) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(source);

        SqlSessionFactory factory = factoryBean.getObject();
        return factory; //sql실행, 매핑 인터페이스 처리
    }

    //mybatis 인터페이스 스프링에 빈으로 등록
    @Bean
    public MapperFactoryBean<TopMenuMapper> test_mapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<TopMenuMapper> fac =
                new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);

        fac.setSqlSessionFactory(factory);
        return fac;
    }



//    //properties파일에 있는 값을 뷰에 출력하기 위해서
//    @Bean(name="messageSource")
//    public ReloadableResourceBundleMessageSource messageSource(){
//        ReloadableResourceBundleMessageSource res=new ReloadableResourceBundleMessageSource();
//        res.setDefaultEncoding("UTF-8");
//        res.setBasenames("/WEB-INF/properties/error");
//        return res;
//    }

    //인터셉터 등록 -  경로와 인터셉터 설정하기 위해
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService);
        InterceptorRegistration re1=registry.addInterceptor(topMenuInterceptor);
        re1.addPathPatterns("/**"); //모든경로로 매핑해도 다 뜨도록... 컨트롤러 전에 preHandle


    }
//
//
//        Inter1 inter1 = new Inter1();
//        Inter2 inter2 = new Inter2();
//        Inter3 inter3 = new Inter3();
//        Inter4 inter4 = new Inter4();
//        Inter5 inter5 = new Inter5();
//        Inter6 inter6 = new Inter6();
//
//        InterceptorRegistration r1 =registry.addInterceptor(inter1);
//        InterceptorRegistration r2 =registry.addInterceptor(inter2);
//        InterceptorRegistration r3 =registry.addInterceptor(inter3);
//        InterceptorRegistration r4 =registry.addInterceptor(inter4);
//        InterceptorRegistration r5 =registry.addInterceptor(inter5);
//        InterceptorRegistration r6 =registry.addInterceptor(inter6);
//
//        //interceptor가 가로채 갈 주소를 등록
////        r1.addPathPatterns("/t1");
////        r2.addPathPatterns("/t1");
////        r3.addPathPatterns("/t2");
//
////            r4.addPathPatterns("/t1", "/t2");
////            r5.addPathPatterns("/s1/t3", "/s1/t4");
////            r6.addPathPatterns("/*");
////            r6.addPathPatterns("/s1/*"); //s1으로 시작되어지는 경로 s1/t3, /s1/t4
//            r6.addPathPatterns("/**");
//            r6.excludePathPatterns("/*"); // interceptor 가 가로채가지 않을 주소 등록 /t1, /t2
//
//    }
}
