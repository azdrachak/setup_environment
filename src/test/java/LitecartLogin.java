import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class LitecartLogin {
    private WebDriver driver;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("d:\\Program Files\\FirefoxNightly\\firefox.exe");
//        driver = new FirefoxDriver(options);
//        this.driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        driver.navigate().to("http://localhost:8080/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        Assert.assertEquals("My Store", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
