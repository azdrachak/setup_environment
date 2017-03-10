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
    private static By createAccountLink = By.cssSelector("#box-account-login a");
    private static By logoutLink = By.cssSelector("#box-account li:last-child a");
    private static By inputEmail = By.name("email");
    private static By inputPassword = By.name("password");
    private static By buttonLogin = By.name("login");
    private static By product = By.className("product");
    private static By linkCheckout = By.cssSelector("#cart a.link");

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
        styles.put("font-weight", item.findElement(itemCampaignPrice).getTagName());
        styles.put("text-decoration", item.findElement(itemCampaignPrice).getCssValue("text-decoration"));
        return styles;
    }

    public static void openCreateAccountPage(WebDriver driver) {
        driver.findElement(createAccountLink).click();
    }

    public static void login(WebDriver driver, String email, String password) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();
    }

    public static void logout(WebDriver driver) {
        driver.findElement(logoutLink).click();
    }

    public static List<WebElement> getProductsList(WebDriver driver) {
        return driver.findElements(product);
    }

    public static void clickCheckout(WebDriver driver) {
        driver.findElement(linkCheckout).click();
    }
}
