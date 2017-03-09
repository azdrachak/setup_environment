import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AdminLogin;
import pages.AdminPage;
import pages.AdminPageAddNewProduct;
import pages.AdminPageCatalog;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class LitecartAdminAddToCatalog {
    private WebDriver wd;
    private final String appUrl = "http://localhost:8080/litecart/admin/";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");

        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.navigate().to(appUrl);
        AdminLogin.login(wd, "admin", "admin");
        AdminPage.navigateToCatalog(wd);
    }

    @Test
    public void addToCatalogTest() {
        String timestamp = new SimpleDateFormat("HH-mm-ss").format(new Date());
        String productName = "Duck-" + timestamp;
        String imagePath = "/src/test/resources/1-yellow-duck-n1.png";

        AdminPageCatalog.openAddNewProductPage(wd);
        AdminPageAddNewProduct.clickTabGeneral(wd);
        AdminPageAddNewProduct.generalSetStatus(wd, "Enabled");
        AdminPageAddNewProduct.generalFillName(wd, productName);
        AdminPageAddNewProduct.generalFillCode(wd, timestamp);
        AdminPageAddNewProduct.generalSetCategoryRubberDucks(wd);
        AdminPageAddNewProduct.generalSetProductGroup(wd, "Male");
        AdminPageAddNewProduct.generalSetQuantity(wd, 150);
        AdminPageAddNewProduct.generalSetSoldOutStatus(wd, 0);
        AdminPageAddNewProduct.generalUploadImage(wd, imagePath);
        AdminPageAddNewProduct.generalSetValidFrom(wd, "04042017");
        AdminPageAddNewProduct.generalSetValidTo(wd, "06062017");

        AdminPageAddNewProduct.clickTabInformation(wd);
        AdminPageAddNewProduct.infoSelectManufacturer(wd, 1);
        AdminPageAddNewProduct.infoFillKeywords(wd, "duck ducks rubber");
        AdminPageAddNewProduct.infoFillShortDescription(wd, "Rubber duck N1");
        AdminPageAddNewProduct.infoFillDescription(wd, "This rubber duck is perfect\nfor bathing and talking to!");
        AdminPageAddNewProduct.infoFillHeadTitle(wd, "DUCKS");
        AdminPageAddNewProduct.infoFillMetaDescription(wd, "Ducks-ducks-ducks");

        AdminPageAddNewProduct.clickTabPrices(wd);
        AdminPageAddNewProduct.pricesFillPurchasePrice(wd, 10.10);
        AdminPageAddNewProduct.pricesSelectCurrency(wd, 1);
        AdminPageAddNewProduct.pricesFillPriceUsd(wd, 10.10);
        AdminPageAddNewProduct.pricesFillPriceUsdVat(wd, 10.50);
        AdminPageAddNewProduct.pricesFillPriceEuro(wd, 9.50);
        AdminPageAddNewProduct.pricesFillPriceEuroVat(wd, 9.90);

        AdminPageAddNewProduct.saveProduct(wd);
        assertTrue(wd.findElement(By.xpath("//a[contains(text(), " + "'" + productName + "')]")).isDisplayed());
    }

    @After
    public void tearDown() {
        wd.quit();
        wd = null;
    }
}
