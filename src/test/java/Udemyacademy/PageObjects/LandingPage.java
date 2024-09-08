package Udemyacademy.PageObjects;



import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstarctComponent;

public class LandingPage extends AbstarctComponent{

	WebDriver driver;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		
		//Constructor is the first method to execute
		//constructor is used to assign local variable to instance variable
		//Initialization happens here
		this.driver=driver;
	//here this initialises the current class driver [initEleemnts means initialise elements in @findby method
		//this is written inside constrcutor as it executes first in the script
		
		PageFactory.initElements(driver, this);
	}
	
	
	//declare factory class
	//findBy annotation
	//at run time this below code replace actual above code of declaring webelement
	
	
	@FindBy(id="userEmail")WebElement username;
	@FindBy(id="userPassword") WebElement password;
	@FindBy( id="login") WebElement loginbtn;
	@FindBy(css="div.toast-bottom-right")WebElement errormessage;
	
	//action methods 
	
	
	public ProductCatalog LoginApplication(String email,String pass) throws InterruptedException 
	{
		username.clear();
		username.sendKeys(email);
		password.clear();
		password.sendKeys(pass);
		System.out.println("Email: " + email);
		Thread.sleep(3000);
		loginbtn.click();
		
		//if a action lands in a new page.,instead of creating an object of it and then
		//calling it we can create the object on the next step and return them
		ProductCatalog pc=new ProductCatalog(driver);
		return pc;
		//now loginApplication method retuens productcatalog object
	}
	
	
	public String geterrormsg() {
		//calling waitforWebelementToAppear from abstarct component
		waitforWebelementToAppear(errormessage);
		return errormessage.getText();
	}
	
	
	
}
