package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Klubni {
    public static final String BASE_URL = "http://13gp.by/informatsiya/meditsinskie-kalkulyatory/" +
            "995-raschet-skorosti-klubochkovoj-filtratsii-skf";

    @Test
    public void smoke() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        // выбрать пол
        WebElement sexElement = driver.findElement(By.id("oSex"));
        Select sexDropDown = new Select(sexElement);
        sexDropDown.selectByIndex(1);
        // sexDropDown.selectByValue("1");
        // sexDropDown.selectByVisibleText("Женский");
        WebElement ocr = driver.findElement(By.id("oCr"));
        ocr.sendKeys("80");
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys("38");
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys("55");
        WebElement height = driver.findElement(By.id("oHeight"));
        height.sendKeys("163");
        WebElement click = driver.findElement(By.cssSelector("[value='Рассчитать']"));
        click.click();
        String actualMDRD = driver.findElement(By.id("txtMDR")).getText();
        String actualMDRD1 = driver.findElement(By.id("txtMDRD1")).getText();
        String actualCG = driver.findElement(By.id("txtCG")).getText();
        String actualBSA = driver.findElement(By.id("txtBSA")).getText();




        driver.quit();
    }
}
