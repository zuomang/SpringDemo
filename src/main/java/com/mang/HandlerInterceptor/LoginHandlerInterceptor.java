package com.mang.HandlerInterceptor;

import com.jpa.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Mang on 15/9/17.
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{
    static final Logger log= LoggerFactory.getLogger(LoginHandlerInterceptor.class);
    private String[] allowUrls;

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String requestUrl = request.getServletPath();
        log.info("request url is " + requestUrl);
        if(null != allowUrls && allowUrls.length >= 1) {
            for(String url: allowUrls) {
                if (requestUrl.startsWith(url))
                    return true;
            }
        }

        User user = (User)request.getSession().getAttribute("user");
        if (user != null) {
            log.info("request session contains user");
            return true;
        }

        RequestDispatcher view = request.getRequestDispatcher("/login");
        view.forward(request, response);

        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
