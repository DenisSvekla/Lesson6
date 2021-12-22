package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("logo-loginpage");
    private By EMAIL_INPUT = By.id("name");
    private By PASSWORD_INPUT = By.id("password");
    private By LOGIN_BUTTON = By.id("button_primary");

    //конструктор страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
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
    public WebElement getPageOpenedIdentified() { return driver.findElement(PAGE_OPENED_IDENTIFIER); }

    //реализация базовых методов
    public void login (String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }



}
