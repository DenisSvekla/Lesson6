package selenidePage;

import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static String ENDPOINT = "/auth/login/";
    private final By userName = By.id("name");
    private final String userPassword = "#password";
    private final String login_button_selector = "#button_primary";

    public LoginPage() {

    }

    public LoginPage(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPage();
        }
    }

    protected void openPage() {
        open(ReadProperties.getUrl() + ENDPOINT);
    }

    public SelenideElement getUserNameField() {
        return $(userName);
    }

    public SelenideElement getPasswordField() {
        return $(userPassword);
    }

    public SelenideElement getButtonLogin() {
        return $(login_button_selector);
    }


    public void loginUsers() {
        getUserNameField().setValue(ReadProperties.getUsername());
        getPasswordField().setValue(ReadProperties.getPassword());
        getButtonLogin().click();
    }
}
