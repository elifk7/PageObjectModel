package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AudioPostPage {

    public WebDriver driver;

    public AudioPostPage(WebDriver driver) { this.driver = driver; }

    public By timeHandle = By.cssSelector("span.mejs-time-handle-content");

    public By volHandle = By.cssSelector("a.mejs-horizontal-volume-slider");

    public void dragAndDropSlider(By locator, int x,int y) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).clickAndHold(element).moveByOffset(x,y).release().perform();
    }
}
