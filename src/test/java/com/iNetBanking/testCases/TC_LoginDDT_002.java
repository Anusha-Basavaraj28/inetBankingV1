package com.iNetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.LoginPage;
import com.iNetBanking.utilities.XLUtiles;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String u,String p) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(u);
		logger.info("user name provided");
		lp.setPassword(p);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000); // to pause
		if(isAlertPresent()==true) {
			logger.info("login failed");
			driver.switchTo().alert().accept(); // close the login failed alert.
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else {
		Assert.assertTrue(true);
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); // close the logout alert
		driver.switchTo().defaultContent();
		logger.info("login successful");
	}
	
	}
	// user defined method to check whether alert present or not.
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	
	//reading data from Excel sheet into 2 dimensional array.
    @DataProvider(name="LoginData")
	String[][] getData() throws IOException{
    	
    	String path=System.getProperty("user.dir")+"/src/test/java/com/iNetBanking/testData/LoginData.xlsx";
		//String path="C:\\Users\\anush\\eclipse-workspace\\iNetBankingV1_pavan\\src\\test\\java\\com\\iNetBanking\\testData\\LoginData.xlsx";
    	int rowNo=XLUtiles.getRowCount(path, "Sheet1");
    	int columnNO=XLUtiles.getCellCount(path, "Sheet1", 1);
    	
    	System.out.println(rowNo);
    	System.out.println(columnNO);
    	String loginData[][]=new String[rowNo][columnNO];
    	
    	for(int i=1;i<=rowNo;i++) {
    		
    		for(int j=0;j<columnNO;j++) {
    			
    			loginData[i-1][j]=XLUtiles.getCellData(path, "Sheet1", i, j);
    			
    		}
    	}
    	
    	return loginData;
    	
    	
	}
}
