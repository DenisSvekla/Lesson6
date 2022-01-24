package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import enums.ProjectType;
import models.Project;
import models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GeneralProjectsPage;
import utils.Randomization;

public class AddProjectTest extends BaseTest {
    Project project;
    Project currentProject;
    Project updateProject;
    User user;

// пока сделано так, можно и меньше кода, об этом я хочу задать пару вопросов на занятии
    // у меня не получилось вынести в отдельный метод натройки проектов, почему то setUp не отра-
    //батывал и у меня не получилось сделать пока проверку, что проект действительно удален
    @Test
    public void addProject()  {
        user = new User.BuilderUser.Builder()
                .withEmail(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();
        project = new Project.BuilderProject.Builder()
                .withName(Randomization.getRandomString(9))
                .withAnouncement(Randomization.getRandomString(18))
                .wihtIsShowAnnouncement(true)
                .withYypeOfProject(ProjectType.SINGLE)
                .build();
        loginSteps.loginGeneralUsers(user);
        driver.get("https://qa1504.testrail.io/index.php?/admin/projects/add/1");
        projectSteps.addProject(project);
        GeneralProjectsPage generalProjectsPage = new GeneralProjectsPage(driver);
        Assert.assertTrue(generalProjectsPage.getSuccessfullyMessageAboutAddingProject().isDisplayed());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",
                generalProjectsPage.findAnyProjectInDashboard(project.getName()));
        Assert.assertTrue(waits.waitForVisibility(generalProjectsPage.findAnyProjectInDashboard(project.getName())),
                "Проект не отображается");

    }

    @Test(dependsOnMethods = "addProject")
    public void updateProject() {
        currentProject = project;
        updateProject = new Project.BuilderProject.Builder()
                .withName(Randomization.getRandomString(9))
                .withAnouncement(Randomization.getRandomString(18))
                .withYypeOfProject(Randomization.getRandomType())
                .build();
        loginSteps.loginGeneralUsers(user);
        driver.get("https://qa1504.testrail.io/index.php?/admin/projects/overview");
        GeneralProjectsPage generalProjectsPage = new GeneralProjectsPage(driver);
        projectSteps.updateProject(currentProject, updateProject);
        Assert.assertTrue(generalProjectsPage.findAnyProjectInProject(updateProject.getName()).isDisplayed());

    }

    @Test(dependsOnMethods = "updateProject")
    public void deleteProject() {
        loginSteps.loginGeneralUsers(user);
        driver.get("https://qa1504.testrail.io/index.php?/admin/projects/overview");
        GeneralProjectsPage generalProjectsPage = new GeneralProjectsPage(driver);
        projectSteps.deleteProject(updateProject);
        //Assert.assertTrue(generalProjectsPage.getSuccessfullyMessageAboutDeleteProject().isDisplayed());
        Assert.assertTrue(waits.isElementExisting(generalProjectsPage.findAnyProjectInProject(updateProject.getName())));

    }

}
