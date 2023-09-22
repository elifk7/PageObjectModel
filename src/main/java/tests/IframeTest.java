package tests;

import org.testng.annotations.Test;

import utils.BaseTest;

public class IframeTest extends BaseTest {

	@Test
	public void clickMapTest() throws InterruptedException {
		
		app.menu.navigateTo(app.menu.contactLink);
		//Thread.sleep(10000);
		app.contact.zoomMap(app.contact.zoomInButton);
		
		
	}
	
	
	
}
