package Udemyacademy.Resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

	public 	static WebDriver driver ;

	public static WebDriver initialisedriver() throws IOException {
		
		//properties class
	
		Properties p = new Properties();
		//here System.getProperty("user.dir") will point to the current project, we are avoiding 
		//hard coding local system path
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Udemyacademy\\ExtentReports\\GlobalData.properties");
		p.load(f);
		
		String browserName =p.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			
	    driver = new ChromeDriver();
	  
		}
	  
		else if(browserName.contains("firefox")){
		 driver = new FirefoxDriver();
			    
			   }
		else if(browserName.contains("edge")){
			 driver = new EdgeDriver();
			    
		}
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.manage().window().maximize();
		   
		    return driver;
		    
		    
       }
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public static void  launchApp() throws IOException  {
		//we are  initailising the driver here
	  driver=initialisedriver();
	//as soon as we launch the browser we land on the landing page so we use the landing
	//page creation here as its common for all the test cases
	//using the driver from above method to land on landing page
	
	
	
	}
	
	//take screenshot when test case fails
		public String getscreenshot(String testCaseName) throws IOException {
			TakesScreenshot ts =  (TakesScreenshot)driver;
	     File source= ts.getScreenshotAs(OutputType.FILE);
	     File file = new File(System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png");
	         FileUtils.copyFile(source, file);
	    return System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png";
		}
}
