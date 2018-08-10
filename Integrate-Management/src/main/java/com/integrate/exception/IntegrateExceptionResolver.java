package com.integrate.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class IntegrateExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
            Exception ex) {
        
        //输出异常
        ex.printStackTrace();
        
        //统一异常处理代码,针对系统自定义的CustomException异常,将异常处理在错误页面展示
        //就可以直接从异常类中获得异常信息
        
        String message = null;
        
        IntegrateException integrateException = null;
        
        //如果ex是系统自定义的异常,直接取出异常信息
        if(ex instanceof IntegrateException) {
            integrateException = (IntegrateException) ex;
        }else {
            //针对非自定义异常,对这类重新构造一个integrateException,异常信息为'未知错误'
            integrateException = new IntegrateException("未知错误");
        }
        
        message = integrateException.getMessage();
        
        request.setAttribute("message", message);
        
        try {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView();
    }

}
