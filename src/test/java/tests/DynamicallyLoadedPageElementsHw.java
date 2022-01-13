package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class DynamicallyLoadedPageElementsHw extends BaseTest {

    @Test
    public void dynamicHw() {
        Waits waits = new Waits(driver);
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button")).click();
        Assert.assertTrue(waits.waitForVisibility(By.id("loading")).isDisplayed());
        waits.waitForChangeAttribute(By.id("loading"),"style", "display: none;", 5);
        Assert.assertTrue(waits.waitForVisibility(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

    }
}
