package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;


import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig (){
		
		
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exeption is   "+e.getMessage());
			
			e.printStackTrace();
		}
	}
	
	
	public String getApplicationURL() {
		String url=pro.getProperty("URL");
		return url;
	}
	
	public String getUserName() {
		String userName=pro.getProperty("userName");
		return userName;
	}
	
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	

}
