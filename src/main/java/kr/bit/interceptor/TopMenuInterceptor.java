package kr.bit.interceptor;

import kr.bit.beans.BoardInfo;
import kr.bit.service.TopMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TopMenuInterceptor implements HandlerInterceptor {

    private TopMenuService topMenuService;

    public TopMenuInterceptor(TopMenuService topMenuService){
        this.topMenuService=topMenuService;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        BoardInfo boardInfo = topMenuService.getTopMenu();  //select.....1, 게시판
        request.setAttribute("boardInfo", boardInfo);
        return true;    //true : 반환이 true 면 프리핸들 실행후 핸들러에 접근한다.
    }

}
