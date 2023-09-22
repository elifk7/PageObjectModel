package tests;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class ActionClassExample extends BaseTest{
	
	
	@Test(priority=1)
	public void hoverExample() {
		MenuPage menu = new MenuPage(driver);
		menu.hoverElement(menu.aboutLink);
		menu.hoverElement(menu.blogLink);
		menu.navigateTo(menu.shopLink);

	}
	
	//@Test(priority=2)
	public void dragAndDropExample() throws InterruptedException {
		ShopPage shop =  new ShopPage(driver);
		//shop.dragAndDropSlider(shop.priceSliderInitalPosition, 100, 0);
		shop.dragAndDropSlider(shop.priceSliderFinalPosition, -100, 0);
		shop.dragAndDropElement(shop.priceSliderInitalPosition, shop.priceSliderFinalMoved);
		//shop.dragAndDropElement(shop.priceSliderInitalPosition, shop.priceSliderFinalPosition);
		Thread.sleep(3000);
	}
	
	//@Test
	public void actionScroll() throws InterruptedException {
		Actions action =  new Actions(driver);	
		action.scrollByAmount(0, 2000).perform();
		Thread.sleep(3000);
		action.scrollByAmount(0, -2000).perform();
		Thread.sleep(3000);
	}
	
	//@Test(priority=1)
	public void sendKeysExample() throws InterruptedException {
		MenuPage menu =  new MenuPage(driver);
		menu.navigateTo(menu.contactLink);
		Thread.sleep(5000);

		ContactsPage contacts =  new ContactsPage(driver);
		contacts.sendKeysWithCaps(contacts.nameField, "abracadabra");

	}
	
	//@Test(priority=2)
	public void sendKeysExample2() {
		MenuPage menu =  new MenuPage(driver);
		menu.navigateTo(menu.contactLink);
		ContactsPage contacts =  new ContactsPage(driver);
		WebElement element = driver.findElement(contacts.nameField);
		Actions action =  new Actions(driver);
		action.
			moveToElement(element).
			sendKeys(element, "Name").
			pause(Duration.ofSeconds(2)).
			sendKeys(Keys.TAB, "email@email.com").
			pause(Duration.ofSeconds(2)).
			sendKeys(Keys.TAB, "My subject").
			pause(Duration.ofSeconds(2)).
			sendKeys(Keys.TAB, "My message").
			pause(Duration.ofSeconds(2)).
			sendKeys(Keys.TAB, Keys.ENTER).
			pause(Duration.ofSeconds(2)).
			perform();		
	}
	
	@Test
	public void copyPasteExample() {
		
		//MenuPage menu =  new MenuPage(driver);
		app.menu.navigateTo(app.menu.loginLink);
		//LoginPage login =  new LoginPage(driver);
		WebElement username =  driver.findElement(app.login.usernameField);
		username.sendKeys("TestUser");
		Actions action = new Actions(driver);
		
		//selectez textul pe care vreau sa il copiez
		Keys ctrlKey = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
		//selectie cu CTRL+A
		action.
			keyDown(ctrlKey).
			sendKeys("a").
			keyUp(ctrlKey).
			perform();
		
		WebElement password = driver.findElement(app.login.passwordField);
		/*action.
			moveToElement(password).
			click().
			pause(Duration.ofSeconds(2)).
			keyDown(Keys.CONTROL).
			sendKeys("v").
			keyUp(Keys.CONTROL).
			pause(Duration.ofSeconds(2)).
			perform(); */

		action.
			keyDown(ctrlKey).
			sendKeys("c").
			keyUp(ctrlKey).
			perform();
		
		action.
			moveToElement(password).
			click().
			pause(Duration.ofSeconds(2)).
			keyDown(ctrlKey).
			sendKeys("v").
			keyUp(ctrlKey).
			pause(Duration.ofSeconds(2)).
			perform();
		
		System.out.println(password.getAttribute("value"));
		
	}

}
