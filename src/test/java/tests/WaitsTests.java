package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

public class WaitsTests extends BaseTest {

    @Test
    public void dd() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Waits waits = new Waits(driver);
        WebElement figure = driver.findElement(By.className("figure"));
        figure.click();
        Assert.assertTrue(waits.waitForVisibility(By.xpath("//h5[.= 'name: user1']")) !=null);



    }
}
