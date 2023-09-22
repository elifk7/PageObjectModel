package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class ContactsPage extends SeleniumWrappers{

	public WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By nameField = By.cssSelector("input[name='your-name']");
	public By emailField = By.cssSelector("input[name='your-email']");
	public By subjectField = By.cssSelector("input[name='your-s']");
	public By messageField = By.cssSelector("textarea[name='your-message']");
	public By submitButton = By.cssSelector("input[value='Send Message']");
	
	
	public By zoomInButton = By.cssSelector("button[title='Zoom in']");
	public By zoomOutButton = By.cssSelector("button[title='Zoom out']");
	public By iframe = By.tagName("iframe");

	
	
	public void sendMessage(String name, String email, String subject, String message) {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(subjectField).clear();
		driver.findElement(subjectField).sendKeys(subject);
		driver.findElement(messageField).clear();
		driver.findElement(messageField).sendKeys(message);
		driver.findElement(submitButton).click();
		
	}
	
	public void refactorSendMessage(String name, String email, String subject, String message) {	
		sendKeys(nameField, name);
		sendKeys(emailField, email);
		sendKeys(subjectField, subject);
		sendKeys(messageField, message);
		click(submitButton);
	}
	
	
	
	
	public void zoomMap(By locator) {
		WebElement element =  driver.findElement(iframe);
		driver.switchTo().frame(element);
		driver.findElement(locator).click();
	}
	
	
	public void sendKeysWithCaps(By locator, String textToBeSent) {
		WebElement element =  driver.findElement(locator);
		Actions action =  new Actions(driver);
		action.
			moveToElement(element).
			click().
			keyDown(Keys.SHIFT).
			sendKeys(textToBeSent).
			perform();
	}
}
