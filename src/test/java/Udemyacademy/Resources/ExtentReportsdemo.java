package Udemyacademy.Resources;

import java.io.IOException;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsdemo extends BaseTest{
 String URL ="https://rahulshettyacademy.com/";
 ExtentReports extent;
 @BeforeTest
 public void config() {
	 
	 
//ExtentReports and ExtentSparkReporter - Create classes for both of them 
	String path=  System.getProperty("user.dir")+"\\reports\\index.html";
	 ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
	 reporter.config().setReportName("Web automation reports");
	 reporter.config().setDocumentTitle("Test Results");
	 
	 //main class for report
	extent= new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Tester","Shreeja");
	 
 }
 
 
 
 
	@Test
	public void demo() throws IOException {
		
//here extent object is created for entire test method and we are casting extent to extenttest class
	ExtentTest test=extent.createTest("initial demo");
	initialisedriver();
	goTo();
	
	//inorder to add screenshot to our test we can use 
	// test.addScreenCaptureFromBase64String(URL);
	//example - To indicate the failure of the test  
//	driver.quit();
//	test.fail("Results are not a match");	
//	
	
	extent.flush();
	
	}
	
	
	public void goTo() {
		driver.get(URL);
		System.out.println(driver.getTitle());
	}
	
	
	
	
}
