package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.ConfirmationDeletePopupPage;
import pages.DashboardPage;
import pages.GeneralProjectsPage;

public class ProjectSteps extends BaseStep {

    private AddProjectPage addProjectPage;
    private GeneralProjectsPage generalProjectsPage;
    private ConfirmationDeletePopupPage confirmationDeletePopupPage;

    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public void addProject(Project project) {
        addProjectPage = new AddProjectPage(driver);
        addProjectPage.getNameField().sendKeys(project.getName());
        addProjectPage.getAnnoucementField().sendKeys(project.getAnouncement());
        addProjectPage.getCheckBoxShowAnnouncement().click();
        addProjectPage.setType(project.getTypeOfProject());
        addProjectPage.getAddProjectButton().click();
    }

    public void updateProject(Project currentProject, Project newProject) {
        generalProjectsPage = new GeneralProjectsPage(driver);
        generalProjectsPage.findAnyProjectInProject(currentProject.getName()).click();
        addProjectPage = new AddProjectPage(driver);
        addProjectPage.getNameField().clear();
        addProjectPage.getNameField().sendKeys(newProject.getName());
        addProjectPage.getAnnoucementField().sendKeys(newProject.getAnouncement());
        addProjectPage.getCheckBoxShowAnnouncement().click();
        addProjectPage.setType(newProject.getTypeOfProject());
        addProjectPage.getSaveProjectButton().click();
        generalProjectsPage = new GeneralProjectsPage(driver);

    }

    public void deleteProject(Project project) {
        generalProjectsPage = new GeneralProjectsPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",
                generalProjectsPage.findAnyProjectInDashboard(project.getName()));
        generalProjectsPage.getDeleteButtonAnyProject(project.getName()).click();
        confirmationDeletePopupPage = new ConfirmationDeletePopupPage(driver);
        confirmationDeletePopupPage.getCheckBoxForConfirmationDelete().click();
        confirmationDeletePopupPage.getButtonOk().click();

    }
}
