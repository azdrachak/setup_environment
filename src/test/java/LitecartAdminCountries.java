import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminLogin;
import pages.AdminPage;
import pages.AdminPageCountries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LitecartAdminCountries {
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
        AdminPage.navigateToCountries(driver);
    }

    @Test
    public void countriesSortingTest() {
        List<WebElement> countries = AdminPageCountries.getCountriesList(driver);
        List<String> countriesNames = new ArrayList<>();
        for (WebElement country : countries) {
            countriesNames.add(country.getText());
        }
        Assert.assertTrue(isSorted(countriesNames));
    }

    @Test
    public void countriesZonesSortingTest() {
        List<String> links = AdminPageCountries.getCountriesWithZonesLinks(driver);
        for (String link : links) {
            driver.navigate().to(link);

            List<WebElement> zoneRows = driver.findElements(By.cssSelector("#table-zones tr:not([class])"));
            List<String> zones = new ArrayList<>();
            String zone;
            for (WebElement zoneRow : zoneRows) {
                List<WebElement> cells = zoneRow.findElements(By.cssSelector("td"));
                zone = cells.get(2).getAttribute("textContent");
                // Check if zone name is empty to get rid of the last row with new zone input
                if (!zone.isEmpty()) zones.add(cells.get(2).getAttribute("textContent"));
            }
            Assert.assertTrue(isSorted(zones));
        }
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
