package com.iNetBanking.testCases;





import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.AddCustomerPage;
import com.iNetBanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	
	@Test
	public void addCustomer() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickSubmit();
		logger.info("clicked submit");
		Thread.sleep(3000);
		
		AddCustomerPage addCustomer=new AddCustomerPage(driver);
		addCustomer.clickAddNewCustomer();
		logger.info("clicked on New Customer");
		
		logger.info("providing customer details");
		addCustomer.customerName("Anusha");
		logger.info("entered customer name");
		addCustomer.gender("female");
		logger.info("entered gender");
		addCustomer.dateOfBirth("06", "28", "1988");
		Thread.sleep(3000);
		logger.info("entered date of birth");
		Thread.sleep(3000);
		addCustomer.address("2000 woodsview dr");
		logger.info("entered address");
		addCustomer.city("newyork");
		logger.info("entered city");
		
		addCustomer.state("NY");
		logger.info("entered state");
		addCustomer.pin("123456");
		logger.info("entered pin");
		addCustomer.telephoneNo("0123456789");
		
		logger.info("entered mobilenumber");
		addCustomer.cEmail(randEmail()+"@gmail.com");
		logger.info("entered email");
		addCustomer.cPassword("anu@123");
		logger.info("entered password");
		addCustomer.submitBtn();
		logger.info("clicked on submit button");
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		logger.info("validation started.......");
		if(res) {
			Assert.assertTrue(true);
			logger.info("Customer Registered Successfully!!!");
		}
		else {
			logger.info("Customer Registered not Successfull!!!");
			Assert.assertTrue(false);
			captureScreenShot(driver, "addNewCustomer");
		}
	}
	
	


}
