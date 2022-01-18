package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import utils.Listener;
import utils.Waits;

@Listeners(Listener.class)
public class BaseTest {
    public static final String EMAIL_DEFAULT = ReadProperties.getUsername();
    public static final String PASSWORD_DEFAULT = ReadProperties.getPassword();

    protected WebDriver driver;
    protected BrowsersService browsersService;
    protected Waits waits;
    protected ProjectSteps projectSteps;
    protected MilestoneSteps milestoneSteps;
    protected LoginSteps loginSteps;


    @BeforeMethod
    public void setUp() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        waits = new Waits(driver);
        driver.get(ReadProperties.getUrl());
        projectSteps = new ProjectSteps(driver);
        milestoneSteps = new MilestoneSteps(driver);
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
