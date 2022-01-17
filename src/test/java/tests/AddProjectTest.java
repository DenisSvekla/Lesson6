package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.List;

public class AddProjectTest extends BaseTest {


    @Test
    public void succesfullCreateProject() {
        LoginPage loginPage = new LoginPage(driver);
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());
        dashboardPage.getAddProjectButton().click();
        addProjectPage.createProject("007DenisSv", "не использовать");
        String succesfull = addProjectPage.getSuccesfullMessage().getText();
        Assert.assertEquals(succesfull, "Successfully added the new project.", "сообщение о добавлении" +
                "проекта изменилось");

    }

    @Test
    public void asd() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());
        driver.get("https://qa1504.testrail.io/index.php?/admin/projects/add/1");
        List<WebElement> types = driver.findElements(By.name("suite_mode"));

        System.out.println(types.size());
    }


}

