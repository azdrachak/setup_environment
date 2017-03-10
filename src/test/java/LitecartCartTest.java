import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import pages.ItemPage;
import pages.MainPage;

import java.util.List;

public class LitecartCartTest {
    private WebDriver wd;
    private final String appUrl = "http://localhost:8080/litecart/";

    @Before
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to(appUrl);
    }

    @Test
    public void cartAddAndDeleteTest() {
        WebDriverWait wait = new WebDriverWait(wd, 5);

        for (int i = 0; i < 3; i++) openItemAddToCart(wait);

        MainPage.clickCheckout(wd);

        // To play it safe stop items in the cart spinning around
        CheckoutPage.stopItemsCarusel(wd);

        int itemsToDelete = CheckoutPage.getRemoveButtons(wd).size();
        while (itemsToDelete > 0) {
            WebElement orderSummaryFirstCell = CheckoutPage.getOrderSummaryFirstCell(wd);
            List<WebElement> buttons = CheckoutPage.getRemoveButtons(wd);
            buttons.get(0).click();
            wait.until(ExpectedConditions.stalenessOf(orderSummaryFirstCell));
            itemsToDelete = CheckoutPage.getRemoveButtons(wd).size();
        }

        Assert.assertTrue("Check that all items are deleted from the cart",
                wd.findElement(By.tagName("em")).getText().equals("There are no items in your cart."));
    }

    private void openItemAddToCart(WebDriverWait wait) {
        WebElement product = MainPage.getProductsList(wd).get(0);
        product.click();
        ItemPage.selectSize(wd);
        WebElement cartQty = ItemPage.getCartQuantity(wd);
        String quantity = cartQty.getText();
        ItemPage.clickButtonAddToCart(wd);
        wait.until(driver -> !ItemPage.getCartQuantity(driver).getText().equals(quantity));
        ItemPage.clickButtonHomePage(wd);
    }

    @After
    public void tearDown() {
        wd.quit();
        wd = null;
    }

}
