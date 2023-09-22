package tests;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest{

	@Test(priority=1)
	public void xpathExample() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// WebElement: <li class="menu_user_login">
		// CSS selector --> li[class='menu_user_login']
		// XPATH selector-> //li[@class='menu_user_login']
		
		WebElement loginLink = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", loginLink);
		loginLink.click();
		
		//multiple elements 
		//plec de la tagname <li> si sar in jos multiple elemente pana gasesc <input ..>
		// Ex: //li//input[@name='log']
		WebElement username = driver.findElement(By.xpath("//li//input[@name='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", username);
		username.sendKeys("TestUser");
		
		//conditional operator OR
		//--> //li//input[@id='password' or @type='password' or @name='pwd']
		WebElement pass = driver.findElement(By.xpath("//li//input[@id='password' or @type='password' or @name='pwd']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", pass);
		pass.sendKeys("12345@67890");
		
		//conditional operator AND
		//--> //li//input[@class='submit_button' and @value='Login']
		WebElement submit = driver.findElement(By.xpath("//li//input[@class='submit_button' and @value='Login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", submit);
		submit.click();
		
	}
	
	@Test(priority=2)
	public void xpathExample2() {
		
		WebElement user = driver.findElement(By.xpath("//span[@class='user_name']"));
		Actions action =  new Actions(driver);
		action.moveToElement(user).perform();
		
		//driver.findElement(By.xpath("//span[@class='user_name']")).click();
		
		//Exemplu CONTAINS()
		//WebElement:
		//<a href="https://keybooks.ro/wp-admin/profile.php" class="icon icon-cog">Settings</a>
		//Accesare pe baza de contains atribute
		//CSS
		//  --> a[href*='profile.php']
		//vs
		//Xpath
		// --> //a[contains(@href, 'profile.php' )]
		driver.findElement(By.xpath("//a[contains(@href, 'profile.php' )]")).click();
		
		//WebElement  : <a href="https://keybooks.ro/account/orders/">recent orders</a>
		//-->//a[contains(text(), 'orde')]
		driver.findElement(By.xpath("//a[contains(text(), 'orde')]")).click();
		
		
		//-->//th[contains(@class, 'woocommerce-orders-table__header' )]/span[contains(text(), 'Order')]
		//--> /html/body/div[1]/div/div[4]/div/div/article/section/div/div/div/div/div/div/table/thead/tr/th[1]/span
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement orderTableHeader =  driver.findElement(
				By.xpath("//th[contains(@class, 'woocommerce-orders-table__header' )]/span[contains(text(), 'Order')]"));
				
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", orderTableHeader);

		//index based
		//--> (//th[contains(@class, 'woocommerce-orders-table__header')]/span)[4]
		
		WebElement totalTableHeader =  driver.findElement(
				By.xpath("(//th[contains(@class, 'woocommerce-orders-table__header')]/span)[4]"));
		
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", totalTableHeader);

	
		WebElement order1720 =  driver.findElement(
				By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell' )][@data-title='Order']/a[contains(text(), '1720')]"));
	
		jse.executeScript("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", order1720);

		//NOT
		List<WebElement> orders = driver.findElements(
				By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell' )][@data-title='Order']/a[not(contains(text(), '1720'))]"));
		
		for(WebElement element : orders) {
			jse.executeScript("arguments[0].setAttribute('style', 'background: yellow;border:4px solid red')", element);

		}
		

		
	}
	
	
	
}
