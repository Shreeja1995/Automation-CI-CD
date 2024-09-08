package Udemyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstarctComponent;

public class OrderPage extends AbstarctComponent{

	WebDriver driver;
	
	@FindBy(xpath="") WebElement zararderid;
	@FindBy(xpath="//tr/td[2]") List<WebElement> orderlists;
	
	//Constructor is the first method to execute
		//constructor is used to assign local variable to instance variable
		//Initialization happens here
	

	public  OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		//here this initializes the current class driver/[initElements means initialize elements in @findby method
		//this is written inside constructor as it executes first in the script	
		PageFactory.initElements(driver, this);
	}

	
	//action methods 

	public Boolean verifyOrderDisplay(String productName) {
		
	boolean match=	orderlists.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
	   return match;
		
	}
	
			
	
	   
}
