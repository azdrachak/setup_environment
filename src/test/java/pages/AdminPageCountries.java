package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminPageCountries extends AdminPage {
    private static By countriesTableRows = By.cssSelector("tbody>tr.row");
    private static By countryNames = By.cssSelector(".row>td a:not([title])");

    public static List<WebElement> getCountriesList(WebDriver driver) {
        return driver.findElements(countryNames);
    }

    public static List<String> getCountriesWithZonesLinks(WebDriver driver) {
        List<WebElement> countriesTableRows = driver.findElements(AdminPageCountries.countriesTableRows);
        List<String> nonZeroZones = new ArrayList<>();
        for (WebElement row : countriesTableRows) {
            List<WebElement> rowItems = row.findElements(By.cssSelector("td"));
            if (!rowItems.get(5).getAttribute("textContent").equals("0")) {
                nonZeroZones.add(row.findElement(By.cssSelector("a:not([title])")).getAttribute("href"));
            }
        }
        return nonZeroZones;
    }
}
