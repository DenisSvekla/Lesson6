package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Randomization;
import utils.Retry;

public class LoginTest extends BaseTest {
    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }


    @Test(retryAnalyzer = Retry.class)
    public void loginTest1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test
    public void chainTest() {
        Assert.assertTrue(new LoginPage(driver).successLogin(ReadProperties.getUsername(), ReadProperties.getPassword())
                .getAddProjectButton().isDisplayed());

    }

//    @Test
//    public void loginTestvalue() {
//        User user = new User();
//        user.setEmail(ReadProperties.getUsername());
//        user.setPassword(ReadProperties.getPassword());
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginWithValue(user);
//        DashboardPage dashboardPage = new DashboardPage(driver, true);
//        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
//    }
//    @Test
//    public void loginTestWithBuilder() {
//        UserBuilder user = new UserBuilder.Builder()
//                .withEmail(ReadProperties.getUsername())
//                .withPassword(ReadProperties.getPassword())
//                .build();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginWithValue(user);
//        DashboardPage dashboardPage = new DashboardPage(driver, true);
//        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
//    }

//    private void setUpProject() {
//        addProject = new Project();
//        addProject.setName(Randomization.getRandomString(9));
//        addProject.setTypeOfProject(Randomization.getRandomType());
//
//        updateProject = new Project();
//        updateProject.setName(Randomization.getRandomString(9));
//    }


}
