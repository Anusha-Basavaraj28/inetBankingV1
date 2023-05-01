package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement textUserName;
	
	@FindBy(name="password")
	WebElement textPassword;
	
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	// /html/body/div[3]/div/ul/li[15]/a
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logoutBtn;
	
	public void setUserName(String uname) {
		textUserName.sendKeys(uname);
	}
	
	public void setPassword(String password) {
		textPassword.sendKeys(password);
	}
		public void clickSubmit() {
			loginBtn.click();
		}
		
		public void clickLogout() {
			logoutBtn.click();
		}
}
