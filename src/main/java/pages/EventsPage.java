package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventsPage {
	
	public WebDriver driver;
	
	public EventsPage (WebDriver driver) {
		this.driver = driver;
	}

	public By timeForBookLink = By.linkText("Time for Books Discussion");
	
	
	public void clickOnEvent(By locator) {
		
		driver.findElement(locator).click();
	}
}
