package tests.SelenideTest;


import baseEntity.BaseTestSelenide;
import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import io.cucumber.java.hu.De;
import models.Milestone;
import models.Project;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenidePage.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
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
        open("/admin/projects/overview");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getCancelButton(project.getName()).click();
        $(byText("Yes, delete this project (cannot be undone)")).click();
        $(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();

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
                .name("0000123")
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
