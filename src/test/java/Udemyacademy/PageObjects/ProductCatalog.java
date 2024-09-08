package Udemyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstarctComponent;


public class ProductCatalog extends AbstarctComponent{

	String email ="shree@email.com";
	String pass ="Learning@123";
	
	WebDriver driver;
	String ProductName;
	
	//Constructor is the first method to execute
		//constructor is used to assign local variable to instance variable
		//Initialization happens here
	
	
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		//here this initializes the current class driver/[initElements means initialize elements in @findby method
		//this is written inside constructor as it executes first in the script	
		PageFactory.initElements(driver, this);
	}

	//declare factory class
	//findBy annotation
	

	//convert list into poe List<WebElement>items = driver.findElements(By.cssSelector("div.mb-3"));
	
	@FindBy(css="div.mb-3") List<WebElement> items;
	@FindBy(css="button[routerlink='/dashboard/cart']") WebElement cart;
	//pagefactory elements of orderhistory page
	@FindBy(css="button[routerlink='/dashboard/myorders']")WebElement orders;
	
	
	//need to pass by element  in getProductlist method
  By productsBy = By.cssSelector(".mb-3");
  By  successmsg= By.id("toast-container");
	By loadingLoc = By.cssSelector(".ng-animating");
By overlayloc=By.cssSelector("div.ngx-spinner-overlay");	
By elementLocator = By.cssSelector(".parent-class .child-class");
	//action methods 

	public List<WebElement> getProductList() {
		//wait for products to appear so calling waitForElementtoAppear from abstractcompoenent class 
		//in the argument mention whats the By [element ] we are waiting to capture
		
		//passing arguement for ByLocator parameter
		waitForElementtoAppear(driver, productsBy);
		//once they are loaded return them
		return items;
		
	}
	
	public WebElement getProductByname(String ProductName) {
		//after returning all the products which matches with By element ,we will now
		//iterate through them using streams to find the text zara coat3
	     WebElement prod = items.stream().filter(item->item.findElement(By.cssSelector("b"))
			.getText().equals(ProductName))
	.findFirst().orElse(null);
	     return prod;
	}
	
	
	     public void AddTocart(String ProductName)
	     {
	    	 //Note : When we get 2 matching elements for a css selector 
	         //and when we select the last matching element we need give the syntax as :last-of-type

	  WebElement prod=getProductByname(ProductName);
	      prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	      
	     //webdriver wait for success msg to appear
	      waitForElementtoAppear(driver, successmsg);
	      
	     //webdriver wait for loading icon to disappear
	      waitForElementToDisappear(driver, loadingLoc);
	      
	      
	      
	      //click on the cart button
	      cart.click();
	      
	      
	     }
	     public CartPage goToCartPage() {
	  		cart.click();
	  		 
	  		CartPage cp= new CartPage(driver);
	 	      return cp;
	  	      
	  	}
	     public OrderPage goToOrderspage() {
			 orders.click();
		  		 
		  		OrderPage orderpage= new OrderPage(driver);
		 	      return orderpage;
		
		 }
	     
	     
	     
	     
	     
	     
	}
	
	
	

