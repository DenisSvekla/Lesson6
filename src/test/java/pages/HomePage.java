package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By DROPDOWN_LINK = By.linkText("Dropdown");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDropDownLink () {return driver.findElement(DROPDOWN_LINK);}
}
