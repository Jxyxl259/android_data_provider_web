package com.jiang.android.utils;


import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by mayan3 on 2015/11/11.
 */
public class JsonUtil {
	public static final ObjectMapper OM = new ObjectMapper();
	static{
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		OM.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		OM.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		OM.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		SimpleModule module = new SimpleModule("money", Version.unknownVersion());
//		module.addSerializer(Money.class, new MoneySerializer());
//		module.addSerializer(Date.class,new MyDateSerializer());
//		OM.registerModule(module);

		OM.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);
	}
	public static JavaType assignList(Class<? extends Collection> collection, Class<? extends Object> object) {
		return JsonUtil.OM.getTypeFactory().constructParametricType(collection, object);
	}
	public static <T> ArrayList<T> readValuesAsArrayList(String key, Class<T> object) {
		ArrayList<T> list = null;
		try {
			list = OM.readValue(key, assignList(ArrayList.class, object));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static String toJson(Object obj){
		try {
			return  obj == null ? "" : OM.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static <T> T fromJson(String json, Class<T> clazz){
		try {
			return OM.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
