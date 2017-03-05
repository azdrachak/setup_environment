package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLogin {
    private static By userInput = By.name("username");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");

    public static void login(WebDriver driver, String user, String password) {
        driver.findElement(userInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
