package Udemyacademy.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstarctComponent;

public class CheckOutPage extends AbstarctComponent {

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(css="[placeholder='Select Country']") WebElement country;
	@FindBy(css=".action__submit") WebElement submit;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]") WebElement selectCountry;
	By results =By.cssSelector(".ta-results");
	
	
	//Action methods
	public void selectCountry(String countryName) {
		//code to help us choose the dropdown option
		Actions a=new Actions(driver);
		
		a.sendKeys(country,countryName).build().perform();
		waitForElementtoAppear(driver, results);
		selectCountry.click();
	}
	
	//thisis not working 
//	public Confirmationpage submitOrder() {
//		//submit.click();
//		
//		//creating an object for confirmation page and returning it 
//	
//		
//	}
	
	
	
	
	
	
	
	
	
	
}
