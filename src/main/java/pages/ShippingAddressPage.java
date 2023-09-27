package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.SeleniumWrappers;

public class ShippingAddressPage extends SeleniumWrappers {

    public WebDriver driver;

    public ShippingAddressPage(WebDriver driver) { this.driver = driver; }

    public By shippingCountry = By.id("shipping_country");
    public By shippingState = By.id("shipping_state");

    public void selectByIndex(int index) {
        WebElement dropdown =  driver.findElement(shippingCountry);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public void selectByValue(String value) {
        WebElement dropdown =  driver.findElement(shippingState);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
}
