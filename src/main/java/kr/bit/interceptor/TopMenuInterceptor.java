package kr.bit.interceptor;

import kr.bit.beans.BoardInfo;
import kr.bit.beans.User;
import kr.bit.service.TopMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TopMenuInterceptor implements HandlerInterceptor {

    //화면에 서비스를 주입
    private TopMenuService topMenuService;

    @Resource(name = "loginBean")
    private User loginBean;


    public TopMenuInterceptor(TopMenuService topMenuService, User loginBean){
        this.topMenuService=topMenuService;
        this.loginBean=loginBean;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        BoardInfo boardInfo = topMenuService.getTopMenu();  //select.....1, 게시판
        request.setAttribute("boardInfo", boardInfo);
        request.setAttribute("loginBean", loginBean);
        return true;    //true : 반환이 true 면 프리핸들 실행후 핸들러에 접근한다.
    }

}
