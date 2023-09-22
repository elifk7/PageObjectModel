package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {

	public WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;	}
	
	
	//locatori
	public By orderDropdown = By.name("orderby");
	public By priceSliderInitalPosition = By.xpath("//span[@style='left: 0%;']");
	public By priceSliderFinalPosition = By.xpath("//span[@style='left: 100%;']");
	public By priceSliderFinalMoved = By.xpath("//span[@style='left: 62.5%;']");

	
	
	//metode
	
	public void dragAndDropSlider(By locator, int x,int y) {
		WebElement element = driver.findElement(locator);
		Actions  action = new Actions(driver);
		action.moveToElement(element).clickAndHold(element).moveByOffset(x,y).release().perform();
		//action.dragAndDropBy(element, x, y).perform();
		//action.dragAndDrop(element, element).perform();
	}
	public void dragAndDropElement(By locator1,By locator2) {
		WebElement element1 = driver.findElement(locator1);
		WebElement element2 = driver.findElement(locator2);

		Actions  action = new Actions(driver);
		//action.dragAndDrop(element1, element2).perform();
		action.
			moveToElement(element1).
			clickAndHold(element1).
			moveToElement(element2).
			release().perform();
	}
	
	
	public void selectByValue(String value) {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		select.selectByValue(value);
		
	}
	
	public void selectByVisibleText(String text) {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
		
	}
	
	public void selectByIndex(int index) {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
		
	}
	
	
	/**
	 * Method that retruns the value as String from the current selection
	 * of a dropdown 
	 * @return uses getText() method from selenium to retrun the text inside the
	 * selected option
	 */
	public String getSelectedOption() {
		WebElement dropdown =  driver.findElement(orderDropdown);
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}
	
	
}
