package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class temaCurs28 extends BaseTest {

    @Test
    public void socialMedia() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        app.menu.navigateTo(app.menu.homeLink);

        String originalHandle = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();

        // Switch to the new tab
        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        app.menu.navigateTo(app.menu.facebookLink);

        //driver.switchTo().frame(0);

        //driver.findElement(By.xpath("//span[@class='facebook-icon']")).click();

        //jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='https://www.facebook.com/keytraining.ro']")));
        assertEquals("https://www.facebook.com/keytraining.ro", driver.getCurrentUrl());

    }
}
