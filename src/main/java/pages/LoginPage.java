package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori
	public By usernameField = By.id("log");
	public By passwordField = By.id("password");
	public By submitButton = By.cssSelector("li input[value='Login']");
	public By errorLoginPopup = By.cssSelector("div[class*='sc_infobox_style_error']");
	public By sucessLoginPopup = By.cssSelector("div[class*='sc_infobox_style_success']");
	public By logoutButton = By.linkText("Logout");
	public By closeButton = By.cssSelector("a[class='popup_close']");
	
	//metode specifice
	public void loginInApp(String user, String pass) {
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(submitButton).click();
	}
	
	public boolean checkLoginMessageIsDiplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void logoutFromApp() {
		driver.findElement(logoutButton).click();
	}
	
	
	public void closePopup() {
		driver.findElement(closeButton).click();

	}
	
}
