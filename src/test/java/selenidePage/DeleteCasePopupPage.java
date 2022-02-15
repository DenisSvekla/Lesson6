package selenidePage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DeleteCasePopupPage {

    private By MARK_DELETE_BUTTON = By.xpath("//a[@onclick = 'this.blur(); App.Cases.confirmDeletion(false, false); return false;']");

    public SelenideElement getMarkDeleteButton() {
        return $(MARK_DELETE_BUTTON);
    }
}
