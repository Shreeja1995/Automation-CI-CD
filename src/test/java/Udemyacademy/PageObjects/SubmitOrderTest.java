package Udemyacademy.PageObjects;

import java.util.HashMap;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebElement;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Udemyacademy.TestComponents.BaseTest;


public class SubmitOrderTest extends BaseTest{
	
	String productName="ZARA COAT 3";
	
	//using data provider 
	@Test(dataProvider="getData",groups= {"Purchase"})
	
		//catching the HashMap data in input variable later retrieving the email and pass using input 
	public void submit(HashMap<String,String> input) throws IOException, InterruptedException  {

		//using the lp object to call the method loginApplication
		ProductCatalog pc =lp.LoginApplication(input.get("email"),input.get("password"));
		lp.geterrormsg();
		
		List<WebElement>products =pc.getProductList();
		
		pc.getProductByname(input.get("product"));
		
		//using hashmap's input.get method to get the product name
		pc.AddTocart(input.get("product"));
		
		//here productcatalog is the child class and it has access to parent class method .goToCartPage
		CartPage cp =pc.goToCartPage();

	   Boolean match = cp.verifyProductDisplay(input.get("product"));
	
	 Assert.assertTrue(match);
	 
	 CheckOutPage cop =  cp.goTocheckoutPage();
	  cop.selectCountry("India");
	  
	  //here in the checkout page ,we are not able to click on placeholder button because
	  //t is an angular application, and the "Place Order" button is a dynamic element.
	  //So to handle it, we use the JavascriptExecutor
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		 WebElement ele = driver.findElement(By.cssSelector(".action__submit"));

		 jse.executeScript("arguments[0].click()", ele);
		
	  Confirmationpage cm =new Confirmationpage(driver);
	  String message =cm.getConfirmation();
	  
	  Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	
	
//	public void verifyOrder() {
//		ProductCatalog pc =lp.LoginApplication("shree@email.com","Learning@123");
//	OrderPage orderpage  =	pc.goToOrderspage();
//	Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
//		System.out.println(productName);
//		
//	}
	
	
	//take screenshot when test case fails
	public String getscreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver;
     File source= ts.getScreenshotAs(OutputType.FILE);
     File file = new File(System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png");
         FileUtils.copyFile(source, file);
    return System.getProperty("user.dir")+ "\\reports\\" + testCaseName + ".png";
	}
	
	
	@DataProvider(name="getData")
	public Object[][] getData() throws IOException{
		
//		//create a 2d array which takes 2 data sets
//		//object is a generic data type which takes any type of data
//		
//		//incase if there are more set of values to send ,we cant use 2d array 
//		//e can instead use hashmap
//	//HashMap<String,String> map = new HashMap<String,String>();
//	
////	map.put("email","shree@email.com");
////	map.put("password","Learning@123");
////	map.put("productName","ZARA COAT 3");
////	
////	//creating one more hashmap to send in 2nd set of input data
////	HashMap<String,String> map2 = new HashMap<String,String>();
////	map2.put("email","abc@hotmail.com");
////	map2.put("password","Learning@123");
////	map2.put("productName","ADIDAS ORIGINAL");
	List<HashMap<String, String>> data = getJsonDataToMap((System.getProperty("user.dir")+"\\src\\test\\java\\Udemyacademy\\Data\\Purchaseorder.json"));
	return	new Object[][]{ {data.get(0)},{data.get(1)}};
	
	}
	
}

