package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.Listener;
import utils.Waits;

@Listeners(Listener.class)
public class BaseTest {
    public static final String EMAIL_DEFAULT = ReadProperties.getUsername();
    public static final String PASSWORD_DEFAULT = ReadProperties.getPassword();

    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;


    @BeforeMethod
    public void setUp() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        waits = new Waits(driver);
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
