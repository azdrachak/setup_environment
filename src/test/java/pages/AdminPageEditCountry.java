package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPageEditCountry {
    private final static By externalLinks = By.cssSelector(".fa-external-link");

    public static List<WebElement> getExternalLinks(WebDriver driver) {
        return driver.findElements(externalLinks);
    }

}
