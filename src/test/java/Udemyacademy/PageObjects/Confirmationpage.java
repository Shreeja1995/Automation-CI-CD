package Udemyacademy.PageObjects;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstarctComponent;

public class Confirmationpage extends AbstarctComponent{

	
	
	//here this.driver - refers to the instance variable of the class 
	WebDriver driver;
	
	public Confirmationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css=".hero-primary") WebElement confirmationMessage;
	
	public String getConfirmation() {
		
		//after we submit the form we finally land on confirmation page hence creating and
		//returning confirmationMessage object
		return confirmationMessage.getText();
	}
	
	
	
	

}
