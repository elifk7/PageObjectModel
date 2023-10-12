package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ProductPage;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

public class temaCurs24 extends BaseTest {

    @Test

    public void bookCheck() throws InterruptedException {


        app.menu.navigateTo(app.menu.shopLink);


        //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //jsExecutor.executeScript("window.scrollBy(0, 600);");

        //Thread.sleep(3000);


        Actions action = new Actions(driver);


        WebElement carte = driver.findElement(By.xpath("//h2[@class='woocommerce-loop-product__title']/a[@href='https://keybooks.ro/shop/a-hundred-and-one-receipes/']"));

        action.moveToElement(carte);

        carte.click();

        ProductPage product = new ProductPage(driver);

        assertTrue(product.checkElementIsDisplayed(product.gallery));

        assertTrue(product.checkElementIsDisplayed(product.rating));

        assertTrue(product.checkElementIsDisplayed(product.title));

        assertTrue(product.checkElementIsDisplayed(product.price));

        assertTrue(product.checkElementIsDisplayed(product.quantity));

        assertTrue(product.checkElementIsDisplayed(product.description));

        assertTrue(product.checkElementIsDisplayed(product.addToCart));

        assertTrue(product.checkElementIsDisplayed(product.category));
    }
}