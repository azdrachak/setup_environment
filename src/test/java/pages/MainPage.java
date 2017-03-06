package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class MainPage {
    private static By campaignsItem = By.cssSelector("#box-campaigns li");
    private static By itemRegularPrice = By.cssSelector("s.regular-price");
    private static By itemCampaignPrice = By.cssSelector("strong.campaign-price");

    public static List<WebElement> getCampaignItems(WebDriver driver) {
        return driver.findElements(campaignsItem);
    }

    public static String getItemName(WebElement item) {
        return item.findElement(By.cssSelector("div.name")).getAttribute("textContent");
    }

    public static String getItemRegularPrice(WebElement item) {
        return item.findElement(itemRegularPrice).getAttribute("textContent");
    }

    public static HashMap<String, String> getItemRegularPriceCSS(WebElement item) {
        HashMap<String, String> styles = new HashMap<>();
        styles.put("color", item.findElement(itemRegularPrice).getCssValue("color"));
        styles.put("font-size", item.findElement(itemRegularPrice).getCssValue("font-size"));
        styles.put("text-decoration", item.findElement(itemRegularPrice).getCssValue("text-decoration"));
        return styles;
    }

    public static String getItemCampaignPrice(WebElement item) {
        return item.findElement(itemCampaignPrice).getAttribute("textContent");
    }
    public static HashMap<String, String> getItemCampaignPriceCSS(WebElement item) {
        HashMap<String, String> styles = new HashMap<>();
        styles.put("color", item.findElement(itemCampaignPrice).getCssValue("color"));
        styles.put("font-size", item.findElement(itemCampaignPrice).getCssValue("font-size"));
//        styles.put("font-weight", item.findElement(itemCampaignPrice).getCssValue("font-weight"));
        styles.put("font-weight", item.findElement(itemCampaignPrice).getTagName());
        styles.put("text-decoration", item.findElement(itemCampaignPrice).getCssValue("text-decoration"));
        return styles;
    }
}
