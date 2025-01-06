package kr.bit.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inter1 implements HandlerInterceptor {
    //요청 발생 시 호출되는 메소드 코드가 중복되는 부분이 있을 때 인터셉터를 통해 처리한다.
    //로그인 여부 확인, 등급별 서비스 권한, 관리자 작업처리에서 많이 사용

    //controller 메소드가 호출되기 전에 호출됨
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre-inter1");
        return true;
    }

    //controller 메소드가 호출된 이후에 호출됨(view처리 수행 전에 호출됨)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("post-inter1");
    }

    //view처리 끝나고 응답결과가 브라우저로 전달되기 전에 호출됨
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion-inter1");
    }
}
