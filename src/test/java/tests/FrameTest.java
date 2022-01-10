package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {


    @Test
    public void ads() {
        driver.get("http://the-internet.herokuapp.com/iframe");
       // driver.switchTo().frame((driver.findElement(By.id("mce_0_ifr"))));
        driver.switchTo().frame(0);
        Assert.assertTrue(driver.findElement(By.tagName("p")).isDisplayed());
        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());
    }
}
