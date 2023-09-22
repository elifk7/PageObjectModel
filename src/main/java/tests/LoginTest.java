package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{

	@Test(priority=1)
	public void validLoginTest() {	
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login =  new LoginPage(driver);
		login.loginInApp("TestUser", "12345@67890");
		assertTrue(login.checkLoginMessageIsDiplayed(login.sucessLoginPopup));
		login.logoutFromApp();
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login =  new LoginPage(driver);
		login.loginInApp("UserGresit", "12345@67890");
		assertTrue(login.checkLoginMessageIsDiplayed(login.errorLoginPopup));	
		login.closePopup();
	}
	
	@Test(priority=3)
	public void validLoginTest4() {	
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login =  new LoginPage(driver);
		login.loginInApp("TestUser", "12345@67890");
		assertTrue(login.checkLoginMessageIsDiplayed(login.sucessLoginPopup));
		login.logoutFromApp();
	}
	
}
