package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.cj.xdevapi.JsonParser;

public class FileUtility 
{
	/*
	 * author @vipin
	 */
	/**
	 * This method used to read the data from properties and return the value based on key specifier
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	/**
	 * This method is used to read the data from JSON file and return the value based on Json Key
	 * @param jsonkey
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromJson(String jsonkey) throws Throwable
	{
		FileReader reader = new FileReader(IPathConstant.JSONFILEPATH);
		JSONParser parser =new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject jsobj = (JSONObject) obj;
		String value = jsobj.get(jsonkey).toString();

		return value;

	}
}
