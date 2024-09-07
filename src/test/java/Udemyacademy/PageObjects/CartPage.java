package Udemyacademy.PageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstarctComponent;


	public class CartPage extends AbstarctComponent{

		WebDriver driver;
		@FindBy(css=".totalRow button") WebElement checkoutele;
		@FindBy(css=".cartSection h3") List<WebElement> cartProducts;
		
		//Constructor is the first method to execute
			//constructor is used to assign local variable to instance variable
			//Initialization happens here
		
	
		public  CartPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			
			//here this initializes the current class driver/[initElements means initialize elements in @findby method
			//this is written inside constructor as it executes first in the script	
			PageFactory.initElements(driver, this);
		}

		//declare factory class
		//findBy annotation
		//at run time this below code replace actual above code of declaring webelement
		
		
		
		//action methods 

		public Boolean verifyProductDisplay(String productName) {
			
		boolean match=	cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		   return match;
			
		}
		
		public  CheckOutPage goTocheckoutPage() {
			checkoutele.click();
		//as soon as we click on checkout button ,we arrive on check 
			//out page hence object for same is created 
			CheckOutPage cop =  new CheckOutPage(driver);
			return cop;
		}		
		
		   
		     
		    
		     
		     
		     
		     
		     
		     
		}
		
		
		



