package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class temaCurs26 extends BaseTest {

    @Test
    public void verifCateg() throws InterruptedException {

        app.menu.hoverElement(app.menu.blogLink);
        driver.findElement(By.xpath("//a[@href='https://keybooks.ro/category/classic/']")).click();

        //WebElement search = driver.findElement(By.xpath("//aside[@id='search-2']//form[@role='search']"));
        WebElement search = driver.findElement(By.xpath("//input[@type='text' and @class='search_field' and @name='s' and @title='Search for:']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(search).perform();

        //search.sendKeys("Why I won’t stop buying books");
        search.sendKeys("why");
        search.submit();

        WebElement whyIWont = driver.findElement(By.xpath("//div[@class='post_featured']"));
        actions.moveToElement(whyIWont).click().perform();

        driver.findElement(By.xpath("//a[@class='category_link' and @href='https://keybooks.ro/category/classic/']"));
        driver.findElement(By.xpath("//a[@class='category_link' and @href='https://keybooks.ro/category/news/']"));
        driver.findElement(By.xpath("//a[@class='category_link' and @href='https://keybooks.ro/category/recommend/']"));
    }

    @Test
    public void verifSale() throws InterruptedException {
        app.menu.navigateTo(app.menu.shopLink);

        WebElement cookbooks = driver.findElement(By.xpath("//a[@href='https://keybooks.ro/product-category/cookbooks/']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(cookbooks).click().perform();

        //aici e aplicabil doar daca am rezultate putine
        //cat sa imi arate ceva de forma "Showing all 5 results"
        WebElement numberOfResults = driver.findElement(By.className("woocommerce-result-count"));
        String resultText = numberOfResults.getText();
        String[] parts = resultText.split(" ");
        int number = Integer.parseInt(parts[2]);

        System.out.println(number);

        List<WebElement> saleTicket = driver.findElements(By.cssSelector("span.onsale"));

        if (number == saleTicket.size())
            System.out.println("Toate cartile din categoria cookbooks sunt la reducere");
        else
            System.out.println("Nu toate cartile din categoria cookbooks sunt la reducere");
    }
}
