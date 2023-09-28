package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

public class temaCurs25 extends BaseTest {

    @Test
    public void slideMusic() throws InterruptedException {
        app.menu.hoverElement(app.menu.blogLink);
        driver.findElement(By.xpath("//a[@href='https://keybooks.ro/category/post-formats/']")).click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("a[href*='https://keybooks.ro/2016/02/02/audio-post/']")));
        Thread.sleep(3000);

        WebElement audioPost = driver.findElement(By.cssSelector("a[href*='https://keybooks.ro/2016/02/02/audio-post/']"));
        audioPost.click();

        driver.findElement(By.cssSelector("h6.sc_audio_title"));
        driver.findElement(By.xpath("//div[@class='mejs-button mejs-playpause-button mejs-play']")).click();
        driver.findElement(By.xpath("//div[@class='mejs-button mejs-playpause-button mejs-play']")).click();

        app.audioPostPage.dragAndDropSlider(app.audioPostPage.timeHandle, 200, 0);

    }
}
