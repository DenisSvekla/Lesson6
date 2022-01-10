package baseEntities;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String EMAIL_DEFAULT = ReadProperties.getUserName();
    public static final String PASSWORD_DEFAULT = ReadProperties.getPassword();

    protected WebDriver driver;



    @BeforeMethod

    public void setUp() {
        switch (ReadProperties.getBrowserType().toLowerCase()) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu"); // отключение графического процесса
                chromeOptions.addArguments("--silent"); // отключение алертов браузера
                chromeOptions.addArguments("--maximize"); // макс. равернутое
                chromeOptions.setHeadless(ReadProperties.getHeadless());
                driver = new ChromeDriver(chromeOptions);

                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;

        }
        //driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
        driver.get(ReadProperties.getUrl());


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    }

