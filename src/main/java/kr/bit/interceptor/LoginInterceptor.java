package kr.bit.interceptor;

import kr.bit.beans.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인 확인 처리!!! (권한부여)
public class LoginInterceptor implements HandlerInterceptor {

    private User loginBean;

    public LoginInterceptor(User loginBean){
        this.loginBean=loginBean;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(loginBean.isUserLogin()==false){
            String str=request.getContextPath();

            response.sendRedirect(str+"/user/not_login");
            //컨트롤단에 진입 불가
            return false;
        }
        return true;
    }



}
