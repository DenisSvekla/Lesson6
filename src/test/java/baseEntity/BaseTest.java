package baseEntity;

import core.BrowsersService;
import core.ReadProperties;
import models.Project;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import utils.Listener;
import utils.Randomization;

//asdsadsa
@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    protected BrowsersService browsersService;


    protected ProjectSteps projectSteps;
    protected MilestoneSteps milestoneSteps;

    protected User user;
    protected Project addProject;
    protected Project updateProject;

    @BeforeTest
    public void setUpData() {
        user = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();

        addProject = Project.builder()
                .name(Randomization.getRandomString(8))
                .typeOfProject(Randomization.getRandomType())
                .build();

        updateProject = Project.builder()
                .name(Randomization.getRandomString(8))
                .typeOfProject(Randomization.getRandomType())
                .build();
    }

    @BeforeClass
    public void setUp() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        projectSteps = new ProjectSteps(driver);
        milestoneSteps = new MilestoneSteps(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }
}