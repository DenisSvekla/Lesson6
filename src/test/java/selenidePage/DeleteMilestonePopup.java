package selenidePage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DeleteMilestonePopup {
    private By CHECK_BOX_WITH_CONFIRMATION = byText("Yes, delete this milestone (cannot be undone)");
    private By OK_BUTTON = By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']");


    public SelenideElement getCheckBoxField() {
        return $(CHECK_BOX_WITH_CONFIRMATION);
    }

    public SelenideElement getOkButton() {
        return $(OK_BUTTON);
    }
}
