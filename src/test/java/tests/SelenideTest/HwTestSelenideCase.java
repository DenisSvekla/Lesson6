package tests.SelenideTest;


import baseEntity.BaseTestSelenide;
import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import models.Case;
import models.Project;
import org.testng.annotations.Test;
import selenidePage.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class HwTestSelenideCase extends BaseTestSelenide {
    Project project;
    Case newCase;
    Case updateCase;

    @Test
    public void addCase() {
        setUp();
        ProjectPage projectPage = new ProjectPage(true);
        projectPage.addProject(project);
        DashboardPage dashboardPage = new DashboardPage(true);
        dashboardPage.getAnyProject(project.getName()).click();
        projectPage.getAddButtonCase().click();
        CasePage casePage = new CasePage();
        casePage.addCase(newCase);
        casePage.getSuccessfulMessage().shouldBe(visible);


    }

    @Test(dependsOnMethods = "addCase")
    public void updateCase() {
        CasePage casePage = new CasePage();
        casePage.getEditButton().click();
        casePage.updateCase(updateCase);
        casePage.getSuccessfulMessage().shouldBe(visible).shouldHave(text("Successfully updated the test case."));
    }

    @Test(dependsOnMethods = "updateCase")
    public void deleteCase() {
        CasePage casePage = new CasePage();
        casePage.getEditButton().click();
        casePage.getDeleteButton().click();
        DeleteCasePopupPage deleteCasePopupPage = new DeleteCasePopupPage();
        deleteCasePopupPage.getMarkDeleteButton().click();
        casePage.getSuccessfulMessage().shouldBe(visible).shouldHave(text("Successfully flagged the test case as deleted."));
    }

    @Test(dependsOnMethods = "deleteCase")
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
                .name("Denisa project")
                .announcement("444")
                .build();

        newCase = Case.builder()
                .title("read me")
                .build();

        updateCase = Case.builder()
                .title("asdsad")
                .build();

    }
}
