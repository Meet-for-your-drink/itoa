package com.duang.login.interceptor;

import com.duang.login.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author duang
 * @date 2020-09-06
 * @Describe 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前调用（controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检测Session中是否存储了user信息，如果没有，返回登陆页
        String loginer = (String) request.getSession().getAttribute("LOGINER");
        if(null == loginer || StringUtils.isBlank(loginer)){
            response.sendRedirect(request.getContextPath()+"/login.html");
        }else{
            return true;
        }
        return false;
    }

    /**
     * 请求处理之后进行调用，但在视图被渲染之前（controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     *  在整个请求结束之后进行调用，也就是DispatcherServlet渲染了对应视图之后执行，主要用于资源的清理工作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
