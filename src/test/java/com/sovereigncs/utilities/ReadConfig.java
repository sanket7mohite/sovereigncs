package com.sovereigncs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() 
	{
		File file = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occured" + e.getMessage());
		}
	}
	
	public String getAppURL() {
		
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsrename() {
			
			String usrename = prop.getProperty("usrename");
			return usrename;
		}
	
	public String getPassword() {
		
		String password = prop.getProperty("password");
		return password;
	}
		
	public String getChromeDriverPath() {
		
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
public String getFirfoxDriverPath() {
		
		String FirefoxPath = prop.getProperty("firefoxpath");
		return FirefoxPath;
	}
	
}
