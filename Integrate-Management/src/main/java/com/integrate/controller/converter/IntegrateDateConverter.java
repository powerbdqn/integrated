package com.integrate.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 
* @类注释
* @ClassName: CustomDateConverter 
* @Description: 自定义日期转换器  
* @author 韩志彬
* @date 2018年6月17日 下午12:08:02 
*
 */
public class IntegrateDateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String source) {
        
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}