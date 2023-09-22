package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample2 extends BaseTest{
	
	
	
	@Test
	public void xpathExample() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//parent
		//--> //a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']
		WebElement loginMenu = driver.findElement(
				By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", loginMenu);
		loginMenu.click();
		//descendant  & child
		//toate xpath-urile de mai jos fac fix acealsi lucru
		//--> //ul[@id='menu_user']//div[contains(@class, 'login_field')]/input[@id='log']
		
		//--> //ul[@id='menu_user']/descendant::form[contains(@class,'login_form')]/child::div[contains(@class, 'login_field')]/child::input
		
		//--> //ul[@id='menu_user']//input[@id='log']
		
		//--> //ul//input[@id='log']
		WebElement usernameField = driver.findElement(
				By.xpath("//ul[@id='menu_user']/descendant::form[contains(@class,'login_form')]/child::div[contains(@class, 'login_field')]/child::input"));
		usernameField.sendKeys("TestUser");
		//descendant
		WebElement passwordField =  driver.findElement(By.xpath("//ul/descendant::input[@id='password']"));
		passwordField.sendKeys("12345@67890");
		
		//following sibling (coboara pe urmatorul frate)
		WebElement rememberMe = driver.findElement(
				By.xpath("//ul//div[contains(@class, 'login_field')]/following-sibling::div[contains(@class, 'remember_field')]/input"));
		rememberMe.click();
		//preceding-sibling (urca pe urmatorul frate)
		//-> //ul//div[contains(@class, 'remember_field')]/preceding-sibling::div[contains(@class, 'login_field')]

		//following  --> coboara in domm fara a avea nevoie de o realtie de rudenie
		//preceding  --> urca in dom fara a avea nevoie de o relatie de rudenie
		WebElement submitButton =  driver.findElement(
				By.xpath("//div[@class='top_panel_middle']/preceding::input[@class='submit_button']"));
	
		submitButton.click();
	}
	
	

}
