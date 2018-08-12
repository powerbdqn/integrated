package com.integrate.pojo.VO;

import java.util.HashMap;
import java.util.Map;

public class ReturnMap {

private ReturnMap() {}
	
	public static Map<String,Object> createMap(Integer code,String msg,Integer count,Object obj) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("msg", msg);
		map.put("count", count);
		map.put("data", obj);
		return map;
	}
}
