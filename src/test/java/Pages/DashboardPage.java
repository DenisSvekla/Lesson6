package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private By ADD_PROJECT_BUTTON_CREATE = By.id("sidebar-projects-add");
    private By MOST_ACTIVE_BUTTON = By.cssSelector(".link.link-tooltip");


    public SelenideElement getAddProjectButton() {
        return $(ADD_PROJECT_BUTTON_CREATE);
    }

    public SelenideElement getMostActiveButton() {
        return $(MOST_ACTIVE_BUTTON);
    }

    public SelenideElement getMilestonesButtonForAnyProject(String nameProject) {
        return $(By.xpath("//a[contains(@href,'index.php?/projects/overview/') " +
                "and text()='" + nameProject + "' and @style]/../../..//a[contains(@href,'index.php?/milestones/overview/') and @class='link']"));
    }

    public SelenideElement getCancelButton(String nameProject) {
        return $(By.xpath("//a[contains(@href,'index.php?/admin/projects/edit/') and text()='" + nameProject + "']" +
                "/../..//div[@class='icon-small-delete']"));

    }
}
