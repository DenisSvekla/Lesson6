package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login";
    private static final By PAGE_OPENED_IDENTIFIER = By.id("button_primary");
    private By EMAIL_INPUT = By.id("name");
    private By PASSWORD_INPUT = By.id("password");
    private By LOGIN_BUTTON = By.id("button_primary");

    //конструктор страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
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
    private void populateFields (String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
    }
    public void login (String email, String password) {
        populateFields(email, password);
        getLoginButton().click();
    }
    public void loginWithValue (User user) {
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        getLoginButton().click();
    }
    public DashboardPage successLogin (String email, String password) {
       populateFields(email, password);
       getLoginButton().click();
        return new DashboardPage(driver);
    }

    public LoginPage incorrectLogin (String email, String password) {
        populateFields(email, password);
        getLoginButton().click();
        return new LoginPage(driver);
    }



}
