package com.iNetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.utilities.ReadConfig;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	
	
	ReadConfig readConfig=new ReadConfig();
	
	// Reading from the read config class which intern reads config.properties file.
	
	public String URL=readConfig.getApplicationURL();
	public String userName=readConfig.getUserName();
	public String password=readConfig.getPassword();
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		//driver=new ChromeDriver(); // launching the browser 
		
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		logger.info("URL is opened");
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	public static void  captureScreenShot(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot taken");
	}
	
public static String randEmail() {
		
		System.out.println("*********generated email id*****");
		System.out.println(RandomString.make(8)+"@gmail.com");
		
		return RandomString.make(8);
		
		
	}
	
	

}
