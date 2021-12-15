package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    // описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("logo-loginpage");

    private By EMAIL_INPUT = By.id("name");

    private By PASSWORD_INPUT = By.id("password");

    private By LOGIN_BUTTON = By.id("button_primary");

    private WebDriver driver;
    //конструктор страницы


    public LoginPage(WebDriver driver) {
      this.driver = driver;

    }



    //реализация геттеров элементов

    public WebElement getEmailField() {
        return driver.findElement(EMAIL_INPUT);
    }

    public WebElement getPasswordField() {
        return driver.findElement(PASSWORD_INPUT);
    }

    public WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }

    //реализация базовых методов


}
