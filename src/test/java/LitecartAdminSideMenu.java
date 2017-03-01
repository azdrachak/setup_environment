import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LitecartAdminSideMenu {
    private WebDriver driver;
    private final String adminUrl = "http://localhost:8080/litecart/admin/";

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void sideMenuTest() {
        // Login to the admin panel
        driver.navigate().to(adminUrl);
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=login]")).click();

        // Click menus
        int menuCount = driver.findElements(AdminPage.sideMenus).size();
        for (int i = 0; i < menuCount; i++) {
            List<WebElement> menus = driver.findElements(AdminPage.sideMenus);
            menus.get(i).click();
            Assert.assertTrue(driver.findElements(By.tagName("h1")).size() > 0);

            // click submenus of the menu
            int subMenuCount = driver.findElements(AdminPage.subMenus).size();
            for (int j = 0; j < subMenuCount; j++) {
                List<WebElement> subMenus = driver.findElements(AdminPage.subMenus);
                subMenus.get(j).click();
                Assert.assertTrue(driver.findElements(By.tagName("h1")).size() > 0);
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
