import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ItemPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LitecartCampaignsItemCheck {
    private WebDriver driver;
    private final String mainPageUrl = "http://localhost:8080/litecart/en/";
    private final String mainPageRedPrice = "(204, 0, 0)";
    private final String mainPageGreyPrice = "(119, 119, 119)";
    private final String itemPageRedPrice = "(204, 0, 0)";
    private final String itemPageGreyPrice = "(102, 102, 102)";


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.navigate().to(mainPageUrl);
    }

    @Test
    public void campaignItemTest() {
        WebElement item = MainPage.getCampaignItems(driver).get(0);

        // Get Item properties on the main page
        String mainPageItemName = MainPage.getItemName(item);
        String mainPageItemRegPrice = MainPage.getItemRegularPrice(item);
        Map<String, String> mainPageItemRegPriceStyle = MainPage.getItemRegularPriceCSS(item);
        String mainPageItemCampPrice = MainPage.getItemCampaignPrice(item);
        Map<String, String> mainPageItemCampPriceStyle = MainPage.getItemCampaignPriceCSS(item);

        // Open item page
        item.click();

        // Get Item properties on the item page
        String itemPageItemName = ItemPage.getItemName(driver);
        String itemPageItemRegPrice = ItemPage.getItemRegularPrice(driver);
        Map<String, String> itemPageItemRegPriceStyle = ItemPage.getItemRegularPriceCSS(driver);
        String itemPageItemCampPrice = ItemPage.getItemCampaignPrice(driver);
        Map<String, String> itemPageItemCampPriceStyle = ItemPage.getItemCampaignPriceCSS(driver);

        Assert.assertEquals("Main page and Item page item names are equal",
                mainPageItemName, itemPageItemName);
        Assert.assertEquals("Main page and item page regular prices are equal",
                mainPageItemRegPrice, itemPageItemRegPrice);
        Assert.assertEquals("Main page and item page campaign prices are equal",
                mainPageItemCampPrice, itemPageItemCampPrice);

        Assert.assertEquals("Main page regular price has grey color",
                mainPageGreyPrice, colorStrip(mainPageItemRegPriceStyle.get("color")));
        Assert.assertEquals("Main page regular price is crossed",
                "line-through", mainPageItemRegPriceStyle.get("text-decoration"));

        Assert.assertEquals("Item page regular price has grey color",
                itemPageGreyPrice, colorStrip(itemPageItemRegPriceStyle.get("color")));
        Assert.assertEquals("Item page regular price is crossed",
                "line-through", itemPageItemRegPriceStyle.get("text-decoration"));

        Assert.assertEquals("Main page campaign price has red color",
                mainPageRedPrice, colorStrip(mainPageItemCampPriceStyle.get("color")));
        Assert.assertEquals("Main page campaign price is bold",
                "strong", mainPageItemCampPriceStyle.get("font-weight"));

        Assert.assertEquals("Item page campaign price has red color",
                itemPageRedPrice, colorStrip(itemPageItemCampPriceStyle.get("color")));
        Assert.assertEquals("Item page campaign price is bold",
                "strong", itemPageItemCampPriceStyle.get("font-weight"));

        Assert.assertTrue("Main page campaign price is larger than the regular one",
                convertFontSize(mainPageItemCampPriceStyle.get("font-size")) > convertFontSize(mainPageItemRegPriceStyle.get("font-size")));
        Assert.assertTrue("Item page campaign price is larger than the regular one",
                convertFontSize(itemPageItemCampPriceStyle.get("font-size")) > convertFontSize(itemPageItemRegPriceStyle.get("font-size")));
    }

    /**
     * Adjusts CSS color, returned by different browsers
     * in the different formats to the uniform format
     *
     * @param rgba string in form rgba(119, 119, 119, 1) or rgb(119, 119, 119)
     * @return color in the format (119, 119, 119)
     */
    private String colorStrip(String rgba) {
        String delimiters = "[a-z(), ]+";
        String[] s = rgba.split(delimiters);
        String color = Arrays.toString(Arrays.copyOfRange(s, 1, 4));
        color = color.replace("[", "(");
        color = color.replace("]", ")");
        return color;
    }

    /**
     * Convert browser's font size to float number
     *
     * @param fontSize font size with trailing letters px
     * @return font size float value
     */
    private float convertFontSize(String fontSize) {
        return Float.parseFloat(fontSize.replace("px", ""));
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
