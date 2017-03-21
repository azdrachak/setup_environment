import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminLogin;
import pages.AdminPageCatalog;

import java.util.List;

public class LitecartAdminCatalogBrowserLog {
    private WebDriver wd;
    private final String adminLogin = "admin";
    private final String adminPwd = "admin";
    private final String catalogUrl = "http://localhost:8080/litecart/admin/?app=catalog&doc=catalog&category_id=1";

    @Before
    public void setUp() {
        this.wd = new ChromeDriver();
        wd.manage().window().maximize();

        wd.navigate().to("http://localhost:8080/litecart/admin/");
        AdminLogin.login(wd, adminLogin, adminPwd);
        wd.navigate().to(catalogUrl);
    }

    @Test
    public void browserLogTest() {
        int logMessages = 0;
        WebDriverWait wait = new WebDriverWait(wd, 5);
        int productsCount = AdminPageCatalog.productLinks(wd).size();

        for (int i = 0; i < productsCount; i++) {
            AdminPageCatalog.productLinks(wd).get(i).click();
            wait.until(driver -> driver.findElement(By.tagName("h1")).isDisplayed());

            List<LogEntry> log = wd.manage().logs().get("browser").getAll();
            logMessages += log.size();
            for (LogEntry logEntry : log) {
                System.out.println(logEntry);
            }

            wd.navigate().back();
        }
        Assert.assertTrue("Check that there were no messages in the browser log", logMessages == 0);
    }


    @After
    public void tearDown() {
        this.wd.quit();
        this.wd = null;
    }

}
