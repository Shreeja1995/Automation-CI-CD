package Resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG  {
	

	
	public static ExtentReports getReportObject() {
		
		
		String path=  System.getProperty("user.dir")+"\\reports\\index.html";
		 ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
		 reporter.config().setReportName("Web automation reports");
		 reporter.config().setDocumentTitle("Test Results");
		 
		 //main class for report
		 ExtentReports extent= new ExtentReports();
		//here reporter gives us the metadata of the report
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester","Shreeja");
		 
		 return extent;
	}
	
	
	
	
	
	
	
	
	
}
