package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutorHw extends BaseTest {

    @Test
    public void scroll() {
        driver.get("http://the-internet.herokuapp.com/floating_menu#home");
        WebElement selen = driver.findElement(By.xpath("//div/a[@href='http://elementalselenium.com/']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", selen);
        Assert.assertTrue(selen.isDisplayed());
    }
}
