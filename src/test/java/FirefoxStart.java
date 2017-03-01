import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FirefoxStart {
    private WebDriver driver;

    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, true);
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("d:\\Program Files\\Mozilla Firefox ESR\\firefox.exe"));
//        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("d:\\Program Files\\FirefoxNightly\\firefox.exe"));

        driver = new FirefoxDriver(firefoxBinary, new FirefoxProfile(), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(((HasCapabilities) driver).getCapabilities());
    }

    @Test
    public void openGoogleTest() {
        driver.navigate().to("https://www.google.com/ncr");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
