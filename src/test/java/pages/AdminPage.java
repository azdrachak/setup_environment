package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    public static By sideMenus = By.cssSelector("#app-");
    public static By subMenus = By.cssSelector("#app- li");
    private static By countriesSubMenu = By.xpath("//*[@class='name' and contains(text(), 'Countries')]");

    public static void navigateToCountries(WebDriver driver) {
        driver.findElement(countriesSubMenu).click();
    }
}
