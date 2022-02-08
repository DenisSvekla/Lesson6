package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final By userName = By.id("name");
    private final String userPasswrod = "#password";
    private final String login_button_selector = "#button_primary";

    public SelenideElement getUserNameField() {
        return $(userName);
    }

    public SelenideElement getPasswordField() {
        return $(userPasswrod);
    }
    public SelenideElement getButtonLogin() {
        return $(login_button_selector);
    }
}
