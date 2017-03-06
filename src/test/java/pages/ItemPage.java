package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ItemPage {
    private static By itemName = By.cssSelector("h1.title");
    private static By itemRegularPrice = By.cssSelector("s.regular-price");
    private static By itemCampaignPrice = By.cssSelector("strong.campaign-price");

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

}
