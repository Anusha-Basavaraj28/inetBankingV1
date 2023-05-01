package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@CacheLookup
	@FindBy(how = How.LINK_TEXT,using="New Customer")
	WebElement addNewCusstomer;
	
	@CacheLookup
	@FindBy(how = How.XPATH,using="//input[@name='name']")
	WebElement customerName;
	
	@CacheLookup
	@FindBy(how = How.XPATH,using="//input[@value='f']")
	WebElement fGender;
	
	@CacheLookup
	@FindBy(how = How.XPATH,using="//input[@value='m']")
	WebElement mGender;
	
	@CacheLookup
	@FindBy(how = How.ID,using="dob")
	WebElement dateOfBirth;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="addr")
	WebElement address;
	
	@CacheLookup
	@FindBy(how = How.XPATH,using="//input[@name='city']")
	WebElement city;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="state")
	WebElement state;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="pinno")
	WebElement pin;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="telephoneno")
	WebElement mobileNumber;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="emailid")
	WebElement email;
	
	@CacheLookup
	@FindBy(how = How.XPATH,using="//input[@name='password']")
	WebElement password;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="sub")
	WebElement submit;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="res")
	WebElement reset;
	
	
	public void clickAddNewCustomer() {
		
		addNewCusstomer.click();
	}
	
	public void customerName(String cName) {
		customerName.sendKeys(cName);
	}
	
	public void gender(String gen) {
		if(gen.equals("female")) {
			fGender.click();
		}
		else if(gen.equals("male")){
			mGender.click();
		}
	}
	
	public void dateOfBirth(String mm,String dd,String yy) {
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yy);
	}
	
	public void address(String caddress) {
		address.sendKeys(caddress);
	}
	
	
	public void city(String cityname) {
		city.sendKeys(cityname);
	}
	
	
	public void state(String statename) {
		state.sendKeys(statename);
	}

	public void pin(String pinNo) {
		pin.sendKeys(String.valueOf(pinNo));
	}
	
	public void telephoneNo(String telephoneNO) {
		mobileNumber.sendKeys(String.valueOf(telephoneNO));
	}
	
	public void cEmail(String cEmail) {
		email.sendKeys(cEmail);
	}
	
	public void cPassword(String cPwd) {
		password.sendKeys(cPwd);
	}
	
	public void submitBtn() {
		submit.click();
	}
	
	public void resetBtn() {
		reset.click();
	}

}
