package tests;

import BaseEntities.BaseTestSelenide;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.MilestonePage;
import Pages.ProjectPage;
import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import models.Milestone;
import models.Project;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
        open("/admin/projects/add/1");
        ProjectPage projectPage = new ProjectPage();
        projectPage.addProject(project);
        DashboardPage dashboardPage = new DashboardPage(true);

//        dashboardPage.getAddProjectButton();
//        open("/dashboard");
        dashboardPage.getMilestonesButtonForAnyProject(project.getName()).click();
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.getAddMilestoneButtonFirst().click();
        milestonePage.addMilestone(newMilestone);
        milestonePage.getSuccessfulMessageAboutAddedMilestone().shouldBe(visible).shouldHave(text("Successfully added the new milestone."));

    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        open("/dashboard");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getMilestonesButtonForAnyProject(project.getName()).click();
        $(byText(newMilestone.getName())).click();
        $(byText("Edit")).click();
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.updateMilestone(updateMilestone);
        milestonePage.getSuccessfulMessageAboutAddedMilestone().shouldBe(visible).shouldHave(text("Successfully updated the milestone."));
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        $(byText(updateMilestone.getName())).click();
        $(byText("Edit")).click();
        $(By.xpath("//*[@class = 'button button-negative button-delete']")).click();
        $(byText("Yes, delete this milestone (cannot be undone)")).click();
        $(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully deleted the milestone."));
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
