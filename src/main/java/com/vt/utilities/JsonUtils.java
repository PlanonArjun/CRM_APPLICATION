package com.vt.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vt.constants.FrameworkConstants;
import com.vt.enums.ConfigProperties;


@SuppressWarnings("unchecked")
public class JsonUtils {
	
	private static Map<String,String> CONFIGMAP = new HashMap<>();
	
	private JsonUtils() {}
	
	static {
		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonconfigfilepath()), HashMap.class);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name "+key +" is not found.Please check config.json");
		}
		
		return CONFIGMAP.get(key.name().toLowerCase());
		
	}
}
