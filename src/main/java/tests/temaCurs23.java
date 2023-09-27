package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;


import java.time.Duration;

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

        app.shippingAddres.selectByIndex(41);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(3000);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("select#shipping_state[style*='overflow:hidden;']")));

        Actions action  = new Actions(driver);

        WebElement state = driver.findElement(app.shippingAddres.shippingState);
        //action.moveToElement(state);

        //state.click();
        Thread.sleep(3000);

        //if(state.isEnabled())
        app.shippingAddres.selectByValue("Newfoundland and Labrador");
    }
}
