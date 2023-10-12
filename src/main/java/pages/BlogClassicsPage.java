package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogClassicsPage {

    public WebDriver driver;

    public BlogClassicsPage(WebDriver driver) { this.driver = driver; }

    public By search = By.xpath("//aside[@id='search-2']//form[@role='search']");
}
