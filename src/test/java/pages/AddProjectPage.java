package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {
    private By ADD_PROJECT_BUTTON_CREATE = By.id("sidebar-projects-add");
    private By NAME_PROJECT = By.id("name");
    private By ANNOUCEMENT_FIELD = By.id("announcement");
    private By CHECKBOX_SHOW_ANNOUCEMENT = By.id("show_announcement");
    private By ADD_PROJECT_BUTTON_ACCEPT = By.id("accept");



    public AddProjectPage(WebDriver driver) {
        super(driver);
    }


    public void createProject(String name, String announcemet) {
        driver.findElement(NAME_PROJECT).sendKeys(name);
        driver.findElement(ANNOUCEMENT_FIELD).sendKeys(announcemet);
        driver.findElement(CHECKBOX_SHOW_ANNOUCEMENT).click();
        driver.findElement(ADD_PROJECT_BUTTON_ACCEPT).click();
    }

}
