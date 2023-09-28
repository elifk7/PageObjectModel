package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;


import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class temaCurs23 extends BaseTest {

    @Test
    public void addressEdit() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        app.menu.navigateTo(app.menu.loginLink);
        LoginPage login =  new LoginPage(driver);
        login.loginInApp("TestUser", "12345@67890");
        assertTrue(login.checkLoginMessageIsDiplayed(login.sucessLoginPopup));

        driver.get("https://keybooks.ro/account/edit-address/shipping/");

        app.shippingAddress.selectByIndex(41);

        String tara = new Select(driver.findElement(app.shippingAddress.shippingCountry)).getFirstSelectedOption().getText();
        //System.out.println(tara);
        assertEquals(tara,"Canada");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 400);");
        //Thread.sleep(3000);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("select#shipping_state[style*='overflow:hidden;']")));

        //Actions action  = new Actions(driver);
        WebElement province = driver.findElement(app.shippingAddress.shippingState);
        //action.moveToElement(province);

        Thread.sleep(3000);
        province.click();

        if(province.isEnabled())
            app.shippingAddress.selectByValue("Newfoundland and Labrador");
    }
}
