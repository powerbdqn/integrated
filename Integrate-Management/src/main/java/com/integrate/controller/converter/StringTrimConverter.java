package com.integrate.controller.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 
* @类注释
* @ClassName: StringTrimConverter 
* @Description:  自定义字符串转换器
* @author 韩志彬
* @date 2018年6月17日 下午12:11:48 
*
 */
public class StringTrimConverter implements Converter<String,String>{
    @Override
    public String convert(String source) {
        
        try {
            if(source != null) {
                source = source.trim();
                if("".equals(source)) {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }
}
