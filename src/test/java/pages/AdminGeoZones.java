package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminGeoZones {
    private static By zoneLinks = By.cssSelector("tr.row td a:not([title])");

    public static List<String> getZoneLinks(WebDriver driver) {
        List<String> links = new ArrayList<>();
        List<WebElement> linkLocators = driver.findElements(zoneLinks);
        for (WebElement linkLocator : linkLocators) {
            links.add(linkLocator.getAttribute("href"));
        }
        return links;
    }
}
