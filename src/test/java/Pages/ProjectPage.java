package Pages;

import com.codeborne.selenide.SelenideElement;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";

    private String NAME_FIELD = "#name";

    private String ANNOUNCEMENT_FIELD = "#announcement";

    private String ADD_PROJECT_BUTTON = "#accept";


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
