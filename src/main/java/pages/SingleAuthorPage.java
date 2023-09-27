package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumWrappers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SingleAuthorPage extends SeleniumWrappers {

    public WebDriver driver;
    public SingleAuthorPage(WebDriver driver) {
        this.driver = driver;
    }

    public By elementPercentage = By.cssSelector("div.sc_skills_total");

    public List<String> getPercentage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Thread.sleep(3000);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(elementPercentage, "text"));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementPercentage));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.sc_skills_total[style*='overflow:hidden;']")));

        List<WebElement> procente = driver.findElements(elementPercentage);
        List<String> procenteLista = new ArrayList<>();
        for (WebElement elem: procente) {
            String value = elem.getText();
            procenteLista.add(value);
        }
        return procenteLista;
    }
}
