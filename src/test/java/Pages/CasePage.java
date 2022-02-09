package Pages;

import com.codeborne.selenide.SelenideElement;
import models.Case;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CasePage {

    private By TITLE_CASE = By.id("title");
    private By ADD_CASE_BUTTON = By.id("accept");
    private By SUCCESSFUL_MESSAGE = By.xpath("//*[@class = 'message message-success']");

    public SelenideElement getTitleCaseField() {
        return $(TITLE_CASE);
    }

    public SelenideElement getAddCaseButton() {
        return $(ADD_CASE_BUTTON);
    }

    public SelenideElement getSuccessfulMessage() {
        return $(SUCCESSFUL_MESSAGE);
    }

    public void addCase(Case newCase) {

        getTitleCaseField().val(newCase.getTitle());
        getAddCaseButton().click();
    }

    public void updateCase(Case updateCase) {
        getTitleCaseField().clear();
        getTitleCaseField().val(updateCase.getTitle());
        getAddCaseButton().click();
    }
}
