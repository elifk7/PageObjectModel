package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class temaCurs26 extends BaseTest {

    @Test
    public void verifCateg() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        app.menu.hoverElement(app.menu.blogLink);
        driver.findElement(By.xpath("//a[@href='https://keybooks.ro/category/classic/']")).click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 1500);");

        WebElement search = driver.findElement(By.xpath("//aside[@id='search-2']//form[@role='search']"));
        assertTrue(search.isDisplayed());

        Thread.sleep(6000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aside[@id='search-2']//form[@role='search']")));
        //jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:4px solid red')", search);

        search.sendKeys("Why I won’t stop buying books");
        search.submit();
    }
}
