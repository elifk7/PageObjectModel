package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.MenuPage;
import utils.BaseTest;

public class SendMessagesTest extends BaseTest{

	
	@Test
	public void sendMessageText() {
		
	MenuPage menu =  new MenuPage(driver);
	menu.navigateTo(menu.contactLink);
	ContactsPage contactsPage = new ContactsPage(driver);
	contactsPage.sendMessage("Test", "abc@test.test", "My subject", "My message");
		
	}
	
	
	@Test
	public void refactorSendMessageText() {
		
	app.click(app.menu.contactLink);
	app.contact.refactorSendMessage("Test", "abc@test.test", "My subject", "My message");

	String timestamp = new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
		
	}
	
	
	
}
