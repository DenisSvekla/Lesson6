package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test
    public void infoAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert al = driver.switchTo().alert();
        Assert.assertEquals(al.getText(), "I am a JS Alert");
        al.accept();
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    }

    @Test
    public void conformAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert al = driver.switchTo().alert();
        Assert.assertEquals(al.getText(), "I am a JS Confirm");
        al.dismiss();
    }

    @Test
    public void promtAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert al = driver.switchTo().alert();
        Assert.assertEquals(al.getText(), "I am a JS prompt");
        al.sendKeys("вапыва");
        al.accept();
    }
}
