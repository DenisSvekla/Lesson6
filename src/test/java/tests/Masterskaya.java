package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Masterskaya {
    @Test
    public void test1 () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement leightInput = driver.findElement(By.name("calc_roomwidth"));
        leightInput.clear();
        leightInput.sendKeys("6");
        WebElement widthInput = driver.findElement(By.name("calc_roomheight"));
        widthInput.clear();
        widthInput.sendKeys("4");
        WebElement lamwidthInput = driver.findElement(By.name("calc_lamwidth"));
        lamwidthInput.clear();
        lamwidthInput.sendKeys("100");
        WebElement lamheightInput = driver.findElement(By.name("calc_lamheight"));
        lamheightInput.clear();
        lamheightInput.sendKeys("190");
        WebElement inpackInput = driver.findElement(By.name("calc_inpack"));
        inpackInput.clear();
        inpackInput.sendKeys("10");
        WebElement priceInput = driver.findElement(By.name("calc_price"));
        priceInput.clear();
        priceInput.sendKeys("50");


        //driver.quit();
    }
}
