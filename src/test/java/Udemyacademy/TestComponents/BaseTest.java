package Udemyacademy.TestComponents;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Udemyacademy.PageObjects.LandingPage;

public class BaseTest {
	
	public 	static WebDriver driver ;
	public static LandingPage lp;
	public static WebDriver initialisedriver() throws IOException {
		
		//properties class
	
		Properties p = new Properties();
		//here System.getProperty("user.dir") will point to the current project, we are avoiding 
		//hard coding local system path
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
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
	public  LandingPage launchApp() throws IOException {
		//we are  initailising the driver here
	  driver=initialisedriver();
	//as soon as we launch the browser we land on the landing page so we use the landing
	//page creation here as its common for all the test cases
	//using the driver from above method to land on landing page
	lp= new LandingPage(driver);
	
	lp.goTo();
	//returning landing page object here inorder to use that in LoginApplication method
	return lp;
	
	
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		  driver.quit();
	}
	
//	public static List<HashMap<String, String>> getJsondattoMap(String filePath) throws IOException {
//
//		//read json to string and as readFileTostring is deprecated we add ,StandardCharsets.UTF_8) as the third arguement
//	String jsonContent=	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
//
//		
//	//convert string to hashmap - add jackson databind - add dependency of jackson-databind in pom.xml file
//	ObjectMapper mapper = new ObjectMapper();
//	List<HashMap<String,String>>data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>()
//	{	
//	});
//	
//	return data;
//	}
	
	
	public static List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException	
	{		
	//read json to string	 
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);		  
	 //String to HashMap- Jackson Databind		  
	ObjectMapper mapper = new ObjectMapper();	  
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {   
		
	}); 	//{map, map}	
	return data;
	}
	
	
	
	//take screenshot when test case fails
			public String getscreenshot(String testCaseName,WebDriver driver) throws IOException {
				TakesScreenshot ts =  (TakesScreenshot)driver;
		     File source= ts.getScreenshotAs(OutputType.FILE);
		     File file = new File(System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png");
		         FileUtils.copyFile(source, file);
		    return System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png";
			}
	
	
	
	
}