package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private By NAME_PROJECT = By.id("name");
    private By ANNOUCEMENT_FIELD = By.id("announcement");
    private By CHECKBOX_SHOW_ANNOUCEMENT = By.id("show_announcement");
    private By ADD_PROJECT_BUTTON = By.id("accept");
    private By BUTTON_FOR_SMALL_FILTER = By.cssSelector(".icon-display-small");
    private By BUTTON_FOR_BIG_FILTER = By.cssSelector("icon-display-large-inactive");
    private By MESSAGE_ABOUT_SUCCESFULL_ADDED_PROJECT = By.cssSelector(".message-success");


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    //реализация геттеров элементов
    public WebElement getNameField() {return driver.findElement(NAME_PROJECT);}
    public WebElement getAnnoucementField() {return driver.findElement(ANNOUCEMENT_FIELD);}
    public WebElement getCheckBoxShowAnnouncement() {return driver.findElement(CHECKBOX_SHOW_ANNOUCEMENT);}
    public WebElement getAddProjectButton() {return driver.findElement(ADD_PROJECT_BUTTON);}
    public WebElement getSmallFilterButton() {return driver.findElement(BUTTON_FOR_SMALL_FILTER);}
    public WebElement getBigFilterButton() {return driver.findElement(BUTTON_FOR_BIG_FILTER);}
    public WebElement findAnyProjectInProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href, 'index.php?/admin/projects/edit/') and text()='"+nameProject+"']"));
    }
    public WebElement getCancelButton(String nameProject) {
       return driver.findElement(By.xpath("//a[contains(@href,'index.php?/admin/projects/edit/') and text()='"+nameProject+"']" +
                "/../..//div[@class='icon-small-delete']"));
    }
    public WebElement getSuccesfullMessage () {
       return driver.findElement(MESSAGE_ABOUT_SUCCESFULL_ADDED_PROJECT);

    }


    public void createProject(String name, String announcemet) {
        driver.findElement(NAME_PROJECT).sendKeys(name);
        driver.findElement(ANNOUCEMENT_FIELD).sendKeys(announcemet);
        driver.findElement(CHECKBOX_SHOW_ANNOUCEMENT).click();
        driver.findElement(ADD_PROJECT_BUTTON).click();
    }


}
