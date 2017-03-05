import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminGeoZones;
import pages.AdminLogin;
import pages.AdminPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LitecartAdminGeoZones {
    private WebDriver driver;
    private final String adminUrl = "http://localhost:8080/litecart/admin/login.php";
    private final String adminUser = "admin";
    private final String adminPwd = "admin";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.navigate().to(adminUrl);
        AdminLogin.login(driver, adminUser, adminPwd);
        AdminPage.navigateToGeoZones(driver);
    }

    @Test
    public void geoZonesAlphabeticalTest() {
        List<String> links = AdminGeoZones.getZoneLinks(driver);
        for (String link : links) {
            driver.navigate().to(link);
            List<String> zones = new ArrayList<>();
            List<WebElement> zonesLocator = driver.findElements(By.cssSelector("select[name] option[selected]:not([data-tax-id-format])"));
            for (WebElement element : zonesLocator) {
                zones.add(element.getText());
            }
            Assert.assertTrue(isSorted(zones));
        }
        Assert.assertTrue(true);
    }

    private boolean isSorted(List<String> strings) {
        List<String> sortedList = new ArrayList<>(strings);
        Collections.sort(sortedList);
        return strings.equals(sortedList);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
