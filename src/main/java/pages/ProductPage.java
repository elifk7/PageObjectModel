package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public By gallery = By.xpath("//a[@href='#' and @class='woocommerce-product-gallery__trigger']");
    public By rating = By.xpath("//div[@class='star-rating']");
    public By title = By.xpath("//h1[@class='product_title entry-title']");
    public By price = By.xpath("//p[@class='price']");
    public By quantity = By.xpath("//div[@class='quantity']");
    public By description = By.xpath("//div[@class='woocommerce-product-details__short-description']");
    public By addToCart = By.xpath("//form[@class='cart']/button[contains(@class, 'single_add_to_cart_button button alt')]");
    public By category =By.xpath("//span[@class='posted_in']");

    public boolean checkElementIsDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}