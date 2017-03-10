package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class ItemPage {
    private static By itemName = By.cssSelector("h1.title");
    private static By itemRegularPrice = By.cssSelector("s.regular-price");
    private static By itemCampaignPrice = By.cssSelector("strong.campaign-price");
    private static By buttonAddToCart = By.cssSelector("[name=add_cart_product]");
    private static By cartQuantity = By.cssSelector("#cart .quantity");
    private static By buttonHomePage = By.cssSelector("[title=Home]");
    private static By selectSize = By.name("options[Size]");

    public static String getItemName(WebDriver driver) {
        return driver.findElement(itemName).getAttribute("textContent");
    }

    public static String getItemRegularPrice(WebDriver driver) {
        return driver.findElement(itemRegularPrice).getAttribute("textContent");
    }

    public static HashMap<String, String> getItemRegularPriceCSS(WebDriver driver) {
        HashMap<String, String> styles = new HashMap<>();
        styles.put("color", driver.findElement(itemRegularPrice).getCssValue("color"));
        styles.put("font-size", driver.findElement(itemRegularPrice).getCssValue("font-size"));
        styles.put("text-decoration", driver.findElement(itemRegularPrice).getCssValue("text-decoration"));
        return styles;
    }

    public static String getItemCampaignPrice(WebDriver driver) {
        return driver.findElement(itemCampaignPrice).getAttribute("textContent");
    }

    public static HashMap<String, String> getItemCampaignPriceCSS(WebDriver driver) {
        HashMap<String, String> styles = new HashMap<>();
        styles.put("color", driver.findElement(itemCampaignPrice).getCssValue("color"));
        styles.put("font-size", driver.findElement(itemCampaignPrice).getCssValue("font-size"));
        styles.put("font-weight", driver.findElement(itemCampaignPrice).getTagName());
        styles.put("text-decoration", driver.findElement(itemCampaignPrice).getCssValue("text-decoration"));
        return styles;
    }

    public static void clickButtonAddToCart(WebDriver driver) {
        driver.findElement(buttonAddToCart).click();
    }

    public static WebElement getCartQuantity(WebDriver driver) {
        return driver.findElement(cartQuantity);
    }

    public static void clickButtonHomePage(WebDriver driver) {
        driver.findElement(buttonHomePage).click();
    }

    /**
     * If Item has Size option to select, selects the first one
     *
     * @param driver WebDriver
     */
    public static void selectSize(WebDriver driver) {
        if (driver.findElements(selectSize).size() > 0) {
            Select select = new Select(driver.findElement(selectSize));
            select.selectByIndex(1);
        }
    }
}
