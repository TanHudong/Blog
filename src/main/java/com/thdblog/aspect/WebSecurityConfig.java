package com.thdblog.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/2 16:40
 * @Description
 */
public class WebSecurityConfig extends WebMvcConfigurerAdapter{
    public final static String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/blog/article/**");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter{

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
            System.out.println("拦截到");
            Cookie[] cookies = request.getCookies();
            String path = request.getServletPath();
            if (path.contains("article") || path.contains("login")){
                return true;
            }

            for(Cookie cookie:cookies){
                System.out.println(cookie.getName()+"拦截器中的cookie");
                if(cookie.getName().equals(SESSION_KEY)){
                    return true;
                }
            }

            response.sendRedirect("/blog/admin/login");
            return false;
       }
    }
}
