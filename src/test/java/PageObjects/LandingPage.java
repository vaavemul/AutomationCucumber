package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='search']") WebElement searchBox;
		
	public String searchItem(String name) throws InterruptedException {
		 
		 searchBox.sendKeys(name);
	        Thread.sleep(500);
	       String  prodName = driver.findElement(By.cssSelector("h4.product-name"))
	                .getText().split("-")[0].trim();
	       return prodName;
	    
	}
}
