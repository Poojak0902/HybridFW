package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	private Properties prop;
	/**
	 * this is used to read the properties from prop file and returns the prop file in project
	 * @return
	 */
	public Properties readProperties() {
		prop= new Properties();
		try {
			FileInputStream file = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
}
