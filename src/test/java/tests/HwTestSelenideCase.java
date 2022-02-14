package tests;

import BaseEntities.BaseTestSelenide;
import Pages.CasePage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.ProjectPage;
import com.codeborne.selenide.Configuration;
import core.ReadProperties;
import models.Case;
import models.Project;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HwTestSelenideCase extends BaseTestSelenide {
    Project project;
    Case newCase;
    Case updateCase;

    @Test
    public void addCase() {
        setUp();
        open("/admin/projects/add/1");
        ProjectPage projectPage = new ProjectPage();
        projectPage.addProject(project);
        open("/dashboard");
        $(byText(project.getName())).click();
        $("#sidebar-cases-add").click();
        CasePage casePage = new CasePage();
        casePage.addCase(newCase);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible);
        $(byText("Add another")).shouldBe(visible);


    }

    @Test(dependsOnMethods = "addCase")
    public void updateCase() {
        $(byText("Edit")).click();
        CasePage casePage = new CasePage();
        casePage.updateCase(updateCase);
        casePage.getSuccessfulMessage().shouldBe(visible).shouldHave(text("Successfully updated the test case."));
    }

    @Test(dependsOnMethods = "updateCase")
    public void deleteCase() {
        $(byText("Edit")).click();
        $(byText("Delete this test case")).click();
        $(By.xpath("//a[@onclick = 'this.blur(); App.Cases.confirmDeletion(false, false); return false;']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully flagged the test case as deleted."));
    }

    @Test(dependsOnMethods = "deleteCase")
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
