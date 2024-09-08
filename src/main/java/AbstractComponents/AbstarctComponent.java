package AbstractComponents;

import java.time.Duration;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class AbstarctComponent {

	//add to cart element 
	WebDriver driver;
	
	

	
	public AbstarctComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//assigning the driver object from child class to parent class -[Abstract component]
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void waitForElementtoAppear(WebDriver driver,By byLocator) {
		
		
	 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	    w.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	    
	    
	    }
	
	public void waitForElementToDisappear(WebDriver driver,By byLocator) {
		
		
		 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		  w.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitforWebelementToAppear(WebElement byLocator) {
		 WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		 w.until(ExpectedConditions.visibilityOf(byLocator));
	}
	
	
	
}