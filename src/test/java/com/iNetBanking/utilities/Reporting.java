package com.iNetBanking.utilities;

// this is the listener class used to generate extent report

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iNetBanking.testCases.BaseClass;


public class Reporting extends TestListenerAdapter {
	
	
	ExtentSparkReporter htmlReporter;   // look and feel of the report
	ExtentReports      extent;                // used to create entries into the report
    ExtentTest logger;           // update test cases into the report
	
    
    
    
	public void onStart(ITestContext testContext) {
    	
    	
    	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	String reportName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		  htmlReporter.config().setDocumentTitle("Automation Report"); // title of the report 
		  htmlReporter.config().setReportName("Functional Report"); // Name of  the report 
		 htmlReporter.config().setTheme(Theme.STANDARD);
		 
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Tester Name", "Anusha");
		extent.setSystemInfo("Browser", "Chrome");
		
		
	}

    public void onTestSuccess(ITestResult tr) {
		
    	logger=extent.createTest(tr.getName());
    	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
    	
    }
public void onTestFailure(ITestResult tr) {
		
    	logger=extent.createTest(tr.getName());
    	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    	
    	String ScreenShotPath=System.getProperty("user.dir")+"/ScreenShots/"+tr.getName()+".png";
    	
    	//String ScreenShotPath="C:\\Users\\anush\\eclipse-workspace\\iNetBankingV1_pavan\\ScreenShots\\loginTest.png";
    	
    	
    	//BaseClass baseClass = new BaseClass();
		try {
			BaseClass.captureScreenShot(BaseClass.driver, tr.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
    	
    	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+System.getProperty("user.dir"));
		System.out.println(ScreenShotPath);
		
    	File f=new File(ScreenShotPath);
    	System.out.println(f.getName());
    	
    	
    	
    	if(f.exists()) {
    		//logger.fail("details").addScreenCaptureFromPath(ScreenShotPath);
    		logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(ScreenShotPath));
    	}
    }

public void onTestSkipped(ITestResult tr) {
	
	logger=extent.createTest(tr.getName());
	logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	
	
}


public void onFinish(ITestContext testContext) {
	
	extent.flush();
}
}
