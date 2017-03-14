import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminLogin;
import pages.AdminPageCountries;
import pages.AdminPageEditCountry;

import java.util.List;
import java.util.Set;

public class LitecartAdminCountriesLinks {
    private WebDriver wd;
    private final String appUrl = "http://localhost:8080/litecart/admin/";
    private final String countriesUrl = "http://localhost:8080/litecart/admin/?app=countries&doc=countries";
    private final String adminLogin = "admin";
    private final String adminPwd = "admin";

    @Before
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to(appUrl);
        AdminLogin.login(wd, adminLogin, adminPwd);
        wd.navigate().to(countriesUrl);
    }

    @Test
    public void countriesLinksOpenNewWindowTest() {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        String baseWindowHandle = wd.getWindowHandle();
        Set<String> windowHandles;
        List<WebElement> countries = AdminPageCountries.getCountriesList(wd);
        countries.get(0).click();

        List<WebElement> externalLinks = AdminPageEditCountry.getExternalLinks(wd);

        for (WebElement link : externalLinks) {
            link.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            windowHandles = wd.getWindowHandles();
            windowHandles.remove(baseWindowHandle);
            String newWindow = windowHandles.iterator().next();
            wd.switchTo().window(newWindow);
            wd.close();
            wd.switchTo().window(baseWindowHandle);
        }
    }

    @After
    public void tearDown() {
        wd.quit();
        wd = null;
    }
}
