package com.iNetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
		
		 //driver.get(URL);
		 //logger.info("URL is opened");
		 
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		
		logger.info("entered username");
		
		lp.setPassword(password);
		
		logger.info("entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			System.out.println(driver.getTitle());
			
			Assert.assertTrue(true);
			logger.info("login test passed");
			
		}
		else {
			try {
				captureScreenShot(driver, "loginTest");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println(driver.getTitle());
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}
