package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

public class temaCurs24 extends BaseTest {

    @Test
    public void bookCheck() throws InterruptedException {

        app.menu.navigateTo(app.menu.shopLink);

        //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("window.scrollBy(0, 600);");
        //Thread.sleep(3000);

        Actions action  = new Actions(driver);

        WebElement carte = driver.findElement(By.xpath("//h2[@class='woocommerce-loop-product__title']/a[@href='https://keybooks.ro/shop/a-hundred-and-one-receipes/']"));
        action.moveToElement(carte);
        carte.click();

        //driver.findElement(By.xpath("//h2[@class='woocommerce-loop-product__title']/a[@href='https://keybooks.ro/shop/a-hundred-and-one-receipes/']")).click();

        driver.findElement(By.xpath("//a[@href='#' and @class='woocommerce-product-gallery__trigger']"));

        driver.findElement(By.xpath("//div[@class='star-rating']"));

        driver.findElement(By.xpath("//h1[@class='product_title entry-title']"));

        driver.findElement(By.xpath("//p[@class='price']"));

        driver.findElement(By.xpath("//div[@class='quantity']"));

        driver.findElement(By.xpath("//div[@class='woocommerce-product-details__short-description']"));

        driver.findElement(By.xpath("//form[@class='cart']/button[contains(@class, 'single_add_to_cart_button button alt')]"));

        driver.findElement(By.xpath("//span[@class='posted_in']"));

    }
}
