package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

public class AddProjectTest extends BaseTest {



    @Test
    public void succesfullCreateProject () {
        LoginPage loginPage = new LoginPage(driver);
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.login(ReadProperties.getUserName(),ReadProperties.getPassword());
        dashboardPage.getAddProjectButton().click();
        addProjectPage.createProject("007DenisSv", "не использовать");
        String succesfull = addProjectPage.getSuccesfullMessage().getText();
        Assert.assertEquals(succesfull, "Successfully added the new project.", "сообщение о добавлении" +
                "проекта изменилось");

    }
}
