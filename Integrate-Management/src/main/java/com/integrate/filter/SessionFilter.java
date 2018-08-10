package com.integrate.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

public class SessionFilter implements Filter {



    /**
     * 
     * @Title: doFilter
     * @Description:
     * @param servletRequest
     * @param servletResponse
     * @param chain
     * @throws IOException
     * @throws ServletException
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        // 转换request response
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // shiro判断
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            // 判断是否是ajax请求,如果是ajax请求,那么设置响应头
            if (request.getHeader("x-requested-with") != null
                    && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                // 设置session超时标识
                response.setHeader("session-status", "timeout");
            }
        }

        chain.doFilter(request, response);

    }
    
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    public void destroy() {

    }
}
