package steps;

import baseEntity.BaseStep;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddProjectPage;

public class ProjectSteps extends BaseStep {
    private AddProjectPage addProjectPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public void addProject(Project project) {
        System.out.println("Bla bla bla report");
        Assert.assertTrue(true);

    }

    public void updateProject(Project currentProject, Project newProject) {

    }

    public void deleteProject(Project project) {

    }
}
