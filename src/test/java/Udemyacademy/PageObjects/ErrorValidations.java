package Udemyacademy.PageObjects;

import java.io.IOException;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Udemyacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {
	
	String productName="ZARA COAT 3";
	@Test(groups={"Errorhandling"})
	public void loginErrorValidation() throws IOException, InterruptedException  {

	String email ="shree@eml.com";
	String pass ="Learning@123";
	
	
	
	//using the lp object to call the method loginApplication
	lp.LoginApplication(email, pass);
	//div[aria-label='Incorrect email or password.']

//div[@class='ng-tns-c4-20 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	lp.geterrormsg();

	Assert.assertEquals("Incorrect email or password.",lp.geterrormsg());
	
    }
	
	@Test(groups={"Errorhandling"}, retryAnalyzer=Udemyacademy.TestComponents.RetryFailedTest.class)
	public void productErrorValidation() throws IOException, InterruptedException  {

		String email1 ="shree@email.com";
		String pass1 ="Learning@123";
		//String productName="ZARA COAT 3";
		
		//using the lp object to call the method loginApplication
		ProductCatalog pc =lp.LoginApplication(email1,pass1);
		
	System.out.println(lp.geterrormsg());	
		
		List<WebElement>products =pc.getProductList();
		
		pc.getProductByname(productName);
		
		pc.AddTocart(productName);
		
		//here productcatalog is the child class and it has access to parent class method .goToCartPage
		CartPage cp =pc.goToCartPage();
  
	
	Boolean match = cp.verifyProductDisplay("ZARA COAT 33");
	
	 Assert.assertTrue(match);
	 
	
	}


}
