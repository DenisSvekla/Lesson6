package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionHw extends BaseTest {

    @Test
    public void actionTest() {
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.xpath("//*[text()=' Login']"));
        Actions actions = new Actions(driver);
        actions
                .sendKeys(username, "tomsmith")
                .sendKeys(password, "SuperSecretPassword!")
                .click(button)
                .build()
                .perform();
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
    }
}
