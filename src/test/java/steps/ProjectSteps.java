package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import utils.Randomization;

public class ProjectSteps extends BaseStep {

    private AddProjectPage addProjectPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public void addProject(Project project) {
        addProjectPage.getNameField().sendKeys(project.getName());
        addProjectPage.



    }

    public void updateProject(Project currentProject, Project newProject) {

    }

    public void deleteProject(Project project) {

    }
}
