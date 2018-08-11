package com.integrate.tool;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

@SuppressWarnings("all")
public class MapTool {

	private MapTool(){}
	
	public static Map<String,Object> createMessageMap(Integer code,String message,Object obj){
		Map<String,Object>	map = new HashMap<>();
		try {
			map.put("code", code);
			map.put("message", message);
			map.put("obj", obj);
		} catch (Error e) {
			throw new RuntimeErrorException(e, "{success:false,info:\""+ e.getCause().getMessage()+"\"}");
		}
		
		return map;
	}
	
	
}
