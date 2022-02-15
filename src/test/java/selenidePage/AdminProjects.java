package selenidePage;

import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AdminProjects {

    private static String ENDPOINT = "/admin/projects/overview";

    public AdminProjects() {

    }

    public AdminProjects(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPage();
        }
    }

    protected void openPage() {
        open(ReadProperties.getUrl() + ENDPOINT);
    }

    public SelenideElement getCancelButton(String nameProject) {
        return $(By.xpath("//a[contains(@href,'index.php?/admin/projects/edit/') and text()='" + nameProject + "']" +
                "/../..//div[@class='icon-small-delete']"));

    }

}
