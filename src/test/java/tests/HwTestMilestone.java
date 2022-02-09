package tests;

import BaseEntities.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.MilestonePage;
import Pages.ProjectPage;
import com.codeborne.selenide.Configuration;
import com.fasterxml.jackson.databind.ser.Serializers;
import core.ReadProperties;
import models.Milestone;
import models.Project;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class HwTestMilestone extends BaseTest {
    Project project;
    Milestone newMilestone;

    @Test
    public void addMilestone() {
        setUp();
        open("/admin/projects/add/1");
        ProjectPage projectPage = new ProjectPage();
        projectPage.addProject(project);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getAddProjectButton();
        open("/dashboard");
        dashboardPage.getMilestonesButtonForAnyProject(project.getName()).click();
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.getAddMilestoneButtonFirst().click();
        milestonePage.addMilestone(newMilestone);










    }




    public void  setUp() {
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
                .name("Grud")
                .announcement("444")
                .build();

        newMilestone = Milestone.builder()
                .name("names")
                .description("asd")
                .build();

    }
}
