package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");
        DashboardPage dashboardPage = new DashboardPage(driver,true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }


    @Test (retryAnalyzer = Retry.class)
    public void loginTest1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");
        DashboardPage dashboardPage = new DashboardPage(driver,true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
}
