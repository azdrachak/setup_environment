package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPageAddNewProduct {
    private static By buttonSave = By.cssSelector("button[name=save]");

    private static By tabGeneral = By.xpath("//a[contains(text(), 'General')]");
    private static By generalRadioStatusEnabled = By.xpath("//label[contains(text(), 'Enabled')]");
    private static By generalRadioStatusDisabled = By.xpath("//label[contains(text(), 'Disabled')]");
    private static By generalName = By.xpath("//strong[contains(text(), 'Name')]/../span/input");
    private static By generalCode = By.cssSelector("[name=code]");
    private static By generalCategoriesRubberDuck = By.cssSelector("input[data-name='Rubber Ducks']");
    private static By generalProductGroupsMale = By.cssSelector("input[type=checkbox][value='1-1']");
    private static By generalProductGroupsFemale = By.cssSelector("input[type=checkbox][value='1-2']");
    private static By generalProductGroupsUnisex = By.cssSelector("input[type=checkbox][value='1-3']");
    private static By generalQuantity = By.cssSelector("[name=quantity]");
    private static By generalSoldOutStatus = By.cssSelector("select[name=sold_out_status_id]");
    private static By generalUploadImage = By.cssSelector("input[type=file]");
    private static By generalDateValidFrom = By.cssSelector("[name=date_valid_from]");
    private static By generalDateValidTo = By.cssSelector("[name=date_valid_to]");

    private static By tabInformation = By.xpath("//a[contains(text(), 'Information')]");
    private static By infoManufacturer = By.cssSelector("select[name=manufacturer_id]");
    private static By infoKeywords = By.cssSelector("input[name=keywords]");
    private static By infoShortDescription = By.xpath("//strong[contains(text(), 'Short Description')]/../span/input");
    private static By infoDescription = By.className("trumbowyg-editor");
    private static By infoHeadTitle = By.xpath("//strong[contains(text(), 'Head Title')]/../span/input");
    private static By infoMetaDescription = By.xpath("//strong[contains(text(), 'Meta Description')]/../span/input");

    private static By tabPrices = By.xpath("//a[contains(text(), 'Prices')]");
    private static By pricesInputPurchase = By.name("purchase_price");
    private static By pricesSelectCurrency = By.name("purchase_price_currency_code");
    private static By pricesPriceUsd = By.name("prices[USD]");
    private static By pricesPriceUsdVat = By.name("gross_prices[USD]");
    private static By pricesPriceEuro = By.name("prices[EUR]");
    private static By pricesPriceEuroVat = By.name("gross_prices[EUR]");

    public static void clickTabGeneral(WebDriver driver) {
        driver.findElement(tabGeneral).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
    }

    /**
     * Sets radio control 'Status' on the General tab
     *
     * @param driver WebDriver to operate on
     * @param status If 'Enabled', then enables option, otherwise disables it
     */
    public static void generalSetStatus(WebDriver driver, String status) {
        if (status.equals("Enabled")) {
            driver.findElement(generalRadioStatusEnabled).click();
        } else driver.findElement(generalRadioStatusDisabled).click();
    }

    public static void generalFillName(WebDriver driver, String name) {
        driver.findElement(generalName).sendKeys(name);
    }

    public static void generalFillCode(WebDriver driver, String code) {
        driver.findElement(generalCode).sendKeys(code);
    }

    public static void generalSetCategoryRubberDucks(WebDriver driver) {
        driver.findElement(generalCategoriesRubberDuck).click();
    }

    /**
     * Select product group option Male/Female/Unisex
     *
     * @param driver WebDriver to operate on
     * @param group  Group can be 'Male', 'Female' or 'Unisex' case insensitive.
     *               If something else passed, then no option will be set
     */
    public static void generalSetProductGroup(WebDriver driver, String group) {
        String option = group.toLowerCase();
        switch (option) {
            case "male":
                driver.findElement(generalProductGroupsMale).click();
                break;
            case "female":
                driver.findElement(generalProductGroupsFemale).click();
                break;
            case "unisex":
                driver.findElement(generalProductGroupsUnisex).click();
                break;
            default:
                break;
        }
    }

    public static void generalSetQuantity(WebDriver driver, Integer quantity) {
        WebElement qty = driver.findElement(generalQuantity);
        qty.clear();
        qty.sendKeys(quantity.toString());
    }

    /**
     * Set SoldOut option
     *
     * @param driver WebDriver
     * @param option one of [0, 1, 2]
     */
    public static void generalSetSoldOutStatus(WebDriver driver, int option) {
        Select select = new Select(driver.findElement(generalSoldOutStatus));
        if (option >= 0 || option <= 2) select.selectByIndex(option);
    }

    public static void generalUploadImage(WebDriver driver, String path) {
        driver.findElement(generalUploadImage).sendKeys(System.getProperty("user.dir") + path);
    }

    public static void generalSetValidFrom(WebDriver driver, String date) {
        driver.findElement(generalDateValidFrom).sendKeys(date);
    }

    public static void generalSetValidTo(WebDriver driver, String date) {
        driver.findElement(generalDateValidTo).sendKeys(date);
    }

    public static void saveProduct(WebDriver driver) {
        driver.findElement(buttonSave).click();
    }

    public static void clickTabInformation(WebDriver driver) {
        driver.findElement(tabInformation).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
    }

    public static void infoSelectManufacturer(WebDriver driver, int option) {
        Select select = new Select(driver.findElement(infoManufacturer));
        select.selectByIndex(option);
    }

    public static void infoFillKeywords(WebDriver driver, String keywords) {
        driver.findElement(infoKeywords).sendKeys(keywords);
    }

    public static void infoFillShortDescription(WebDriver driver, String description) {
        driver.findElement(infoShortDescription).sendKeys(description);
    }

    public static void infoFillDescription(WebDriver driver, String description) {
        driver.findElement(infoDescription).sendKeys(description);
    }

    public static void infoFillHeadTitle(WebDriver driver, String title) {
        driver.findElement(infoHeadTitle).sendKeys(title);
    }

    public static void infoFillMetaDescription(WebDriver driver, String description) {
        driver.findElement(infoMetaDescription).sendKeys(description);
    }

    public static void clickTabPrices(WebDriver driver) {
        driver.findElement(tabPrices).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
    }

    public static void pricesFillPurchasePrice(WebDriver driver, Double price) {
        WebElement input = driver.findElement(pricesInputPurchase);
        input.clear();
        input.sendKeys(price.toString());
    }

    public static void pricesSelectCurrency(WebDriver driver, int index) {
        Select select = new Select(driver.findElement(pricesSelectCurrency));
        select.selectByIndex(index);
    }

    public static void pricesFillPriceUsd(WebDriver driver, Double price) {
        driver.findElement(pricesPriceUsd).sendKeys(price.toString());
    }

    public static void pricesFillPriceEuro(WebDriver driver, Double price) {
        driver.findElement(pricesPriceEuro).sendKeys(price.toString());
    }

    public static void pricesFillPriceUsdVat(WebDriver driver, Double price) {
        WebElement input = driver.findElement(pricesPriceUsdVat);
        input.clear();
        input.sendKeys(price.toString());
    }

    public static void pricesFillPriceEuroVat(WebDriver driver, Double price) {
        WebElement input = driver.findElement(pricesPriceEuroVat);
        input.clear();
        input.sendKeys(price.toString());
    }
}
