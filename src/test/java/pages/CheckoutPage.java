package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    private static By orderSummaryTableHeaderQuantity = By.cssSelector("#order_confirmation-wrapper .quantity");
    private static By itemsContainerBox = By.id("box-checkout-cart");
    private static By buttonRemove = By.name("remove_cart_item");

    public static WebElement getOrderSummaryFirstCell(WebDriver driver) {
        return driver.findElement(orderSummaryTableHeaderQuantity);
    }

    public static void stopItemsCarusel(WebDriver driver) {
        driver.findElement(itemsContainerBox).click();
    }

    public static List<WebElement> getRemoveButtons(WebDriver driver) {
        return driver.findElements(buttonRemove);
    }
}
