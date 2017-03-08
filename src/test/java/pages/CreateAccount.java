package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
    private static By inputFirstName = By.name("firstname");
    private static By inputLastName = By.name("lastname");
    private static By inputAddress1 = By.name("address1");
    private static By inputPostcode = By.name("postcode");
    private static By inputCity = By.name("city");
    private static By selectCountry = By.cssSelector("select[name=country_code]");
    private static By selectZoneCode = By.cssSelector("select[name=zone_code]");
    private static By inputEmail = By.name("email");
    private static By inputPhone = By.name("phone");
    private static By inputPassword = By.name("password");
    private static By inputPasswordConfirm = By.name("confirmed_password");
    private static By buttonCreateAccount = By.name("create_account");

    public static void fillFirstname(WebDriver driver, String firstname) {
        driver.findElement(inputFirstName).sendKeys(firstname);
    }

    public static void fillLastname(WebDriver driver, String lastname) {
        driver.findElement(inputLastName).sendKeys(lastname);
    }

    public static void fillAddress1(WebDriver driver, String address) {
        driver.findElement(inputAddress1).sendKeys(address);
    }

    public static void fillPostcode(WebDriver driver, String postcode) {
        driver.findElement(inputPostcode).sendKeys(postcode);
    }

    public static void fillCity(WebDriver driver, String city) {
        driver.findElement(inputCity).sendKeys(city);
    }

    public static void selectCountry(WebDriver driver, String country) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountry));
        Select select = new Select(driver.findElement(selectCountry));
        select.selectByVisibleText(country);
    }

    public static void selectZone(WebDriver driver, String zone) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectZoneCode));
        Select select = new Select(driver.findElement(selectZoneCode));
        select.selectByVisibleText(zone);
    }

    public static void fillEmail(WebDriver driver, String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public static void fillPhone(WebDriver driver, String phone) {
        WebElement phoneInput = driver.findElement(inputPhone);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public static void fillAndConfirmPassword(WebDriver driver, String pwd, String pwdConfirm) {
        driver.findElement(inputPassword).sendKeys(pwd);
        driver.findElement(inputPasswordConfirm).sendKeys(pwdConfirm);
    }

    public static void clickCreateAccount(WebDriver driver) {
        driver.findElement(buttonCreateAccount).click();
    }

}
