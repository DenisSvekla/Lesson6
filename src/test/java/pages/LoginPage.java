package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login";
    private static final By PAGE_OPENED_IDENTIFIER = By.className("logo-loginpage");
    private By EMAIL_INPUT = By.id("name");
    private By PASSWORD_INPUT = By.id("password");
    private By LOGIN_BUTTON = By.id("button_primary");

    //конструктор страницы
    public LoginPage(WebDriver driver) {

        super(driver,false);
    }



    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
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
    public void login (String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

    private  void populateFields (String email, String psw) {

        getEmailField().sendKeys(ReadProperties.getUsername());
        getPasswordField().sendKeys(ReadProperties.getPassword());
    }
    public DashboardPage successLogin(String email, String psw) {
        populateFields(email, psw);
        getLoginButton().click();
        return new DashboardPage(driver);
    }

    public LoginPage incorrectLogin (String email, String psw) {
        populateFields(email, psw);
        getLoginButton().click();
        return new LoginPage(driver);
    }



}
