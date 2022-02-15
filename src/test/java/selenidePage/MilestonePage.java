package selenidePage;

import com.codeborne.selenide.SelenideElement;
import models.Milestone;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MilestonePage {

    private String NAME_FIELD = "#name";
    private String References = "#reference";
    private String DESCRIPTION_FIELD = "#description_display";
    private String ADD_MILESTONE_BUTTON = "#accept";
    private String ADD_MILESTONE_BUTTON_FIRST = "#navigation-milestones-add";
    private By SUCCESSFUL_MESSAGE_ABOUT_ADDING = By.xpath("//*[@class = 'message message-success']");
    private By isShowCompletedSelector = By.id("is_completed");
    private By DELETE_MILESTONE_BUTTON = By.xpath("//*[@class = 'button button-negative button-delete']");
    private By SUCCESSFUL_MESSAGE_ABOUT_DELETE_MILESTONE = By.xpath("//*[@class = 'message message-success']");


    public SelenideElement getNameField() {
        return $(NAME_FIELD);
    }

    public SelenideElement getReferencesField() {
        return $(References);
    }

    public SelenideElement getDescriptionField() {
        return $(DESCRIPTION_FIELD);
    }

    public SelenideElement getAddMilestoneButton() {
        return $(ADD_MILESTONE_BUTTON);
    }

    public SelenideElement getAddMilestoneButtonFirst() {
        return $(ADD_MILESTONE_BUTTON_FIRST);
    }

    public SelenideElement getSuccessfulMessageAboutAddedMilestone() {
        return $(SUCCESSFUL_MESSAGE_ABOUT_ADDING);
    }

    public SelenideElement getSuccessfulMessageAboutDeletedMilestone() {
        return $(SUCCESSFUL_MESSAGE_ABOUT_DELETE_MILESTONE);
    }

    public SelenideElement getIsShowCompletedField() {
        return $(isShowCompletedSelector);
    }

    public SelenideElement getMilestoneByName(String nameMilestone) {
        return $(byText(nameMilestone));
    }

    public SelenideElement getEditButton() {
        return $(byText("Edit"));
    }

    public SelenideElement getDeleteMilestoneButton() {
        return $(DELETE_MILESTONE_BUTTON);
    }


    public void addMilestone(Milestone milestone) {
        getNameField().setValue(milestone.getName());
        getDescriptionField().setValue(milestone.getDescription());
        getAddMilestoneButton().click();
    }

    public void updateMilestone(Milestone updateMilestone) {
        getNameField().clear();
        getNameField().val(updateMilestone.getName());
        getDescriptionField().clear();
        getDescriptionField().val(updateMilestone.getDescription());
        getIsShowCompletedField().click();
        getAddMilestoneButton().click();
    }
}
