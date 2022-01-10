package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputsPage extends BasePage {
    private By INPUT_FIELD = By.cssSelector("input[type='number']");



    public InputsPage(WebDriver driver) {
        super(driver);
    }
}
