package selenidePage;

import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPage {

    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";

    private String NAME_FIELD = "#name";

    private String ANNOUNCEMENT_FIELD = "#announcement";

    private String ADD_PROJECT_BUTTON = "#accept";

    private static String ENDPOINT = "/admin/projects/add/1";

    public ProjectPage() {

    }

    public ProjectPage(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPage();
        }
    }

    protected void openPage() {
        open(ReadProperties.getUrl() + ENDPOINT);
    }


    public SelenideElement getNameField() {
        return $(NAME_FIELD);
    }

    public SelenideElement getAnnouncementField() {
        return $(ANNOUNCEMENT_FIELD);
    }

    public SelenideElement getAddProjectButton() {
        return $(ADD_PROJECT_BUTTON);
    }

    public void setType(ProjectType type) {
        $(By.xpath(typeRadioButtonSelector.replace("replace", String.valueOf(type))));
    }

    public void addProject(Project project) {
        getNameField().setValue(project.getName());
        getAnnouncementField().setValue(project.getAnnouncement());
        getAddProjectButton().click();
    }
}
