package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.HomePage;
import utils.Waits;

public class DropDownTest extends BaseTest {
    DropDownPage dropDownPage = new DropDownPage(driver);
    @Test
    public void selectFirstDropDown () throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByValue("1");
        Assert.assertEquals(dropdown,"valu");


    }
}
