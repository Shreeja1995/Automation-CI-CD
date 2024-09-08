package Udemyacademy.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Udemyacademy.PageObjects.CartPage;
import Udemyacademy.PageObjects.CheckOutPage;
import Udemyacademy.PageObjects.Confirmationpage;
import Udemyacademy.PageObjects.LandingPage;
import Udemyacademy.PageObjects.ProductCatalog;
import Udemyacademy.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends BaseTest{
	
	public LandingPage lp;
	public ProductCatalog pc;
	public CartPage cp;
	public CheckOutPage cop;
	public   Confirmationpage cm;
	

//@Given("I landed on ecommerce page")
//public void i_landed_on_ecommerce_page()  throws IOException {
//		
//		
//	 lp= launchApp();
//	
//	}
//	//as we are using regular expression to send username and password using ^ username- (.+) password - (.+)    $
//	@Given("I logged in with username {string} and password {string}") 
//	public void I_logged_in_with_username_and_password(String username,String password) throws InterruptedException {
//		
//		 pc =lp.LoginApplication(username,password);
//		
//		
//	}
//	
//	@When("I add the product {string} to Cart")
//    public void I_add_the_product_to_Cart(String productName) {
//		
//        List<WebElement>products =pc.getProductList();
//		
//		pc.AddTocart(productName);
//		
//	}
//	
//	
//	 @And("checkout {string} and submit the order")
//	 public void checkout_and_submit_the_order(String productName) {
//		 
//		 
//		 Boolean match = cp.verifyProductDisplay(productName);
//			
//		 Assert.assertTrue(match);
//		 
//		  cop =  cp.goTocheckoutPage();
//		  cop.selectCountry("India");
//		  
//		  //here in the checkout page ,we are not able to click on placeholder button because
//		  //t is an angular application, and the "Place Order" button is a dynamic element.
//		  //So to handle it, we use the JavascriptExecutor
//		  
//		  JavascriptExecutor jse = (JavascriptExecutor)driver;
//			
//			 WebElement ele = driver.findElement(By.cssSelector(".action__submit"));
//
//			 jse.executeScript("arguments[0].click()", ele);
//			
//			 //after clicking on submit we are going to confirmation page thats why created new object of it.
//		      
//	 }
//	
//	 @Then("verify {string} is displayed on confirmation page")
//	
//	   public void verify_message_displayed_confirmation_page(String string) {
//		  new Confirmationpage(driver); 
//		String message =cm.getConfirmation();
//		  
//		  Assert.assertTrue(message.equalsIgnoreCase(string));
//
//		
//	}
	
	@Given("I landed on ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {
		 lp= launchApp();
	}
	@Given("I logged in with username {string} and password {string}")
	public void i_logged_in_with_username_and_password(String username, String password) throws InterruptedException {
		 pc =lp.LoginApplication(username,password);
	}
	@When("I add the product {string} to Cart")
	public void i_add_the_product_to_cart(String productName) {
		 List<WebElement>products =pc.getProductList();
		 pc.AddTocart(productName);
		 
	}
	@When("checkout {string} and submit the order")
	public void checkout_and_submit_the_order(String productName) {
		cp = new CartPage(driver);
		 Boolean match = cp.verifyProductDisplay(productName);
		 Assert.assertTrue(match);
		 cop =  cp.goTocheckoutPage();
		 cop.selectCountry("India");
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 WebElement ele = driver.findElement(By.cssSelector(".action__submit"));
		 jse.executeScript("arguments[0].click()", ele);
	}
	@Then("verify {string} is displayed on confirmation page")
	public void verify_is_displayed_on_confirmation_page(String string) {
		String message =cm.getConfirmation();
		 Assert.assertTrue(message.equalsIgnoreCase(string));
	}

	@Then("\"Incorrect email or password.\" message is displayed")
	public void incorrect_email_or_password_message_is_displayed(String message) {
	   
	    Assert.assertEquals(message,lp.geterrormsg());
	    driver.close();
	}

}
