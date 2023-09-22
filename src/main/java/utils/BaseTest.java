package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public static WebDriver driver;
	public BasePage app;
	
	@BeforeClass
	public void setup() {
		//System.setProperty("webdriber.chrome.driver", "path//chromedriver.exe")	
		driver =  new ChromeDriver();
		driver.manage().window().maximize();//face maximize la browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://keybooks.ro/");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		app = new BasePage();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);// bad practice
		driver.close();	//inchide doar tabul curent
		//driver.quit();// inchide browserul indifiernt cate tab-uri are deschise 
		
	}
	

}
