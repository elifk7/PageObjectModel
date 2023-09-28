package utils;

import pages.*;

public class BasePage extends SeleniumWrappers {

	public MenuPage menu = new MenuPage(driver);
	public LoginPage login  = new LoginPage(driver);
	public ShopPage shop =  new ShopPage(driver);
	public ContactsPage contact =  new ContactsPage(driver);
	public EventsPage events = new EventsPage(driver);
	public SingleEventPage singleEvent = new SingleEventPage(driver);
	public SingleAuthorPage singleAuthor = new SingleAuthorPage(driver);
	public ShippingAddressPage shippingAddress = new ShippingAddressPage(driver);
}
