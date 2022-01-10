package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MICROSECONDS);
        Actions act = new Actions(driver);
        WebElement fff = driver.findElement(By.id("file-upload"));
        WebElement upload = driver.findElement(By.id("file-submit"));
        fff.sendKeys("C:/studies/Day_3_small.png");
        upload.click();
        Waits waits = new Waits(driver);

        WebElement textHeader = waits.waitForVisibility(By.xpath("//h3[. = 'File Uploaded!']"));
        WebElement fileName = waits.waitForVisibility(By.id("uploaded-files"));
        Assert.assertTrue(textHeader.isDisplayed());
        Assert.assertEquals(fileName.getText(),"Day_3_small.png");


        }

    }

