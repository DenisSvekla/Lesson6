package tests.SelenideTest;


import baseEntity.BaseTestSelenide;
import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import models.Milestone;
import models.Project;
import org.testng.annotations.Test;
import selenidePage.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class HwTestSelenideMilestone extends BaseTestSelenide {
    Project project;
    Milestone newMilestone;
    Milestone updateMilestone;

    @Test
    public void addMilestone() {
        setUp();
        ProjectPage projectPage = new ProjectPage(true);
        projectPage.addProject(project);
        DashboardPage dashboardPage = new DashboardPage(true);
        dashboardPage.getMilestonesButtonForAnyProject(project.getName()).click();
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.getAddMilestoneButtonFirst().click();
        milestonePage.addMilestone(newMilestone);
        milestonePage.getSuccessfulMessageAboutAddedMilestone().shouldBe(visible).shouldHave(text("Successfully added the new milestone."));
    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        DashboardPage dashboardPage = new DashboardPage(true);
        dashboardPage.getMilestonesButtonForAnyProject(project.getName()).click();
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.getMilestoneByName(newMilestone.getName()).click();
        milestonePage.getEditButton().click();
        milestonePage.updateMilestone(updateMilestone);
        milestonePage.getSuccessfulMessageAboutAddedMilestone().shouldBe(visible).shouldHave(text("Successfully updated the milestone."));
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.getMilestoneByName(updateMilestone.getName()).click();
        milestonePage.getEditButton().click();
        milestonePage.getDeleteMilestoneButton().click();
        DeleteMilestonePopup deleteMilestonePopup = new DeleteMilestonePopup();
        deleteMilestonePopup.getCheckBoxField().click();
        deleteMilestonePopup.getOkButton().click();
        milestonePage.getSuccessfulMessageAboutAddedMilestone().shouldBe(visible).shouldHave(text("Successfully deleted the milestone."));
    }

    @Test(dependsOnMethods = "deleteMilestone")
    public void deleteProject() {
        AdminProjects adminProjects = new AdminProjects(true);
        adminProjects.getCancelButton(project.getName()).click();
        DeleteProjectPopup deleteProjectPopup = new DeleteProjectPopup();
        deleteProjectPopup.getCheckBoxField().click();
        deleteProjectPopup.getOkButton().click();
    }


    public void setUp() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.getBrowserName();
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;
        Configuration.headless = false;
        Configuration.timeout = 8000;
        open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.loginUsers();

        project = Project.builder()
                .name("trust")
                .announcement("444")
                .build();

        newMilestone = Milestone.builder()
                .name("names")
                .description("asd")
                .build();

        updateMilestone = Milestone.builder()
                .name("updates")
                .description("ddd")
                .build();

    }
}
