import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateAccount;
import pages.MainPage;

public class LitecartCreateAccountTest {
    private WebDriver wd;
    private String appUrl = "http://localhost:8080/litecart/en/";

    @Before
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to(appUrl);
    }

    @Test
    public void createAccountTest() {
        String email = usernameGen();
        String password = "123456qwerty";
        String firstname = "John";
        String lastname = "Doe";
        String address = "5-th Main st, 41";
        String postcode = "12345";
        String city = "Colorado Springs";
        String country = "United States";
        String state = "Colorado";
        String phone = "+1 987-654-32-10";

        MainPage.openCreateAccountPage(wd);
        CreateAccount.fillFirstname(wd, firstname);
        CreateAccount.fillLastname(wd, lastname);
        CreateAccount.fillAddress1(wd, address);
        CreateAccount.fillCity(wd, city);
        CreateAccount.fillPostcode(wd, postcode);
        CreateAccount.selectCountry(wd, country);
        CreateAccount.selectZone(wd, state);
        CreateAccount.fillEmail(wd, email);
        CreateAccount.fillPhone(wd, phone);
        CreateAccount.fillAndConfirmPassword(wd, password, password);
        CreateAccount.clickCreateAccount(wd);

        MainPage.logout(wd);

        MainPage.login(wd, email, password);

        MainPage.logout(wd);

    }

    @After
    public void tearDown() {
        wd.quit();
        wd = null;
    }

    private String usernameGen() {
        String username = RandomStringUtils.randomAlphanumeric(12);
        String mail = RandomStringUtils.randomAlphabetic(5);
        return username + "@" + mail + ".com";
    }
}
