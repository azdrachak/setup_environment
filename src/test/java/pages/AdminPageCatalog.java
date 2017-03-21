package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPageCatalog extends AdminPage {
    private static By buttonAddNewProduct = By.xpath("//a[contains(text(), 'Add New Product')]");
    private static By productLink = By.cssSelector("a[href*=product_id]:not([title])");

    public static void openAddNewProductPage(WebDriver driver) {
        driver.findElement(buttonAddNewProduct).click();
    }

    public static List<WebElement> productLinks(WebDriver driver) {
        return driver.findElements(productLink);
    }
}
