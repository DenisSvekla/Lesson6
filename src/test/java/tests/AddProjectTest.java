package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;

public class AddProjectTest extends BaseTest {

    @Test
    public void succesfullCreateProject () {
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        addProjectPage.createProject("Denisov", "не использовать");
        String =
        dashboardPage.findAnyProjectInProject("Denisov").click();



    }
}
