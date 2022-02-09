package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.ReadProperties;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final By userName = By.id("name");
    private final String userPassword = "#password";
    private final String login_button_selector = "#button_primary";

    public SelenideElement getUserNameField() {
        return $(userName);
    }

    public SelenideElement getPasswordField() {
        return $(userPassword);
    }
    public SelenideElement getButtonLogin() {
        return $(login_button_selector);
    }


    public void loginUsers () {
        getUserNameField().setValue(ReadProperties.getUsername());
        getPasswordField().setValue(ReadProperties.getPassword());
        getButtonLogin().click();
    }
}
