import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPageStickerCheck {
    private WebDriver driver;
    private final String mainPage = "http://localhost:8080/litecart/en/";

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void duckyStickersTest() {
        driver.navigate().to(mainPage);
        List<WebElement> ducks = driver.findElements(By.cssSelector(".image-wrapper"));
        for (WebElement duck : ducks) {
            Assert.assertTrue(duck.findElements(By.cssSelector("div[class^=sticker]")).size() == 1);
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
