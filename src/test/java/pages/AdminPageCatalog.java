package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPageCatalog extends AdminPage {
    private static By buttonAddNewProduct = By.xpath("//a[contains(text(), 'Add New Product')]");

    public static void openAddNewProductPage(WebDriver driver) {
        driver.findElement(buttonAddNewProduct).click();
    }
}
