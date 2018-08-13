package com.integrate.tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.integrate.pojo.VO.RegisterUser;

public class CheckCard {

	private CheckCard(){}

	public static Map<String,Object> checkIdCard(String idCard) throws Exception {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "APPCODE " + MyConstants.ALIYUN_IDCARD_APPCODE);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("idCard", idCard);
		HttpResponse response = HttpUtil.doGet(MyConstants.ALIYUN_IDCARD_HOST, MyConstants.ALIYUN_IDCARD_PATH, MyConstants.ALIYUN_IDCARD_METHOD, headers, querys);
		String json = EntityUtils.toString(response.getEntity());
		Map<String,Object> map = JSONArray.parseObject(json, Map.class);
		Map<String,Object> retMap = new HashMap<String,Object>();
		Set<Entry<String,Object>> set = map.entrySet();
		for (Entry<String, Object> entry : set) {
			String key = entry.getKey();
			Object value = map.get(key);
			retMap.put(key, value);
		}
		return retMap;
	}
	
	public static Map<String, Object> registerParam(String card){
		Map<String, Object> retMap = new HashMap<String,Object>();
		RegisterUser user = new RegisterUser();
		try {
			Map<String, Object> map = checkIdCard(card);
			Object status = map.get("status");
			Object idCard = map.get("idCard");
			Object sex = map.get("sex");
			Object area = map.get("area");
			Object birthday = map.get("birthday");
			
			if("202".equals(status)) {
				retMap = MapTool.createMessageMap(5000, "身份信息错误", null);
				return retMap;
			}
			
			if("201".equals(status)) {
				user.setCord(idCard.toString());
				user.setUsername("bdqn" + RandomStringUtils.randomNumeric(4));
				user.setPassword("bdqn" + RandomStringUtils.randomNumeric(2) + birthday.toString().replace("-", ""));
				user.setMsg("温馨提示:您的密码由系统随机匹配,或可根据您的意愿自行填写");
				user.setAddress(area.toString());
				if("男".equals(sex.toString())) {
					user.setSex("1");
				}else if("女".equals(sex.toString())) {
					user.setSex("0");
				}
			}
			retMap = MapTool.createMessageMap(2000, "用户回显数据成功", user);
		} catch (Exception e) {
			e.printStackTrace();
			retMap = MapTool.createMessageMap(5000, "用户回显数据失败", null);
		}
		
		return retMap;
	}
}
