package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	// Properties class
	Properties properties;

	// Constructor

	public ReadConfig() {
		File source = new File("./Configuration/config.properties");// Creating file object

		try {

			// open fileinoutStream and Read data
			FileInputStream fis = new FileInputStream(source);
			properties = new Properties();
			properties.load(fis);// load config.prperties
		} catch (Exception e) {
			// if config.properties file not available, it will throw an exception
			System.out.println("Exception is " + e.getMessage());
		}

	}

	// Method to read data from config.properties
	public String getApplicationURL() {
		String url = properties.getProperty("baseURL");
		return url;

	}

	public String getUsername() {
		String username1 = properties.getProperty("username1");
		return username1;

	}

	public String getPassword() {
		String password = properties.getProperty("password");
		return password;

	}

	public String getChromePath() {
		String chromepath = properties.getProperty("chromepath");
		return chromepath;

	}

}
