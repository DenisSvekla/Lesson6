package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW {


    @Test
    public void masterskaya() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String expectedlayingArea = "31.76 м2.";
        String expectedLCount = "108 шт.";
        String expectedPackCount = "11 шт.";
        String expectedPrice = "1776 руб.";
        String expectedRemainder = "2 шт.";
        String expectedTrash = "34 шт.";
        driver.manage().deleteAllCookies();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement leightInput = driver.findElement(By.name("calc_roomwidth"));
        leightInput.sendKeys("8,000");
        leightInput.sendKeys(Keys.DELETE);
        WebElement widthInput = driver.findElement(By.name("calc_roomheight"));
        widthInput.sendKeys("4,000");
        widthInput.sendKeys(Keys.DELETE);
        WebElement lamwidthInput = driver.findElement(By.name("calc_lamwidth"));
        lamwidthInput.sendKeys(Keys.DELETE,Keys.DELETE,Keys.DELETE,Keys.DELETE,"1700");
        WebElement lamheightInput = driver.findElement(By.name("calc_lamheight"));
        lamheightInput.sendKeys(Keys.DELETE,Keys.DELETE,Keys.DELETE,Keys.DELETE);
        lamheightInput.sendKeys("190");
        WebElement countinpackInput = driver.findElement(By.name("calc_inpack"));
        countinpackInput.sendKeys(Keys.DELETE,Keys.DELETE,Keys.DELETE);
        countinpackInput.sendKeys("10");
        WebElement priceInput = driver.findElement(By.name("calc_price"));
        priceInput.sendKeys(Keys.DELETE,Keys.DELETE,Keys.DELETE);
        priceInput.sendKeys("50");
        WebElement direction = driver.findElement(By.name("calc_direct"));
        Select select = new Select(direction);
        select.selectByValue("toh");
        WebElement bias = driver.findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.DELETE,Keys.DELETE,Keys.DELETE);
        bias.sendKeys("50");
        WebElement walldist = driver.findElement(By.name("calc_walldist"));
        walldist.sendKeys(Keys.DELETE,Keys.DELETE,Keys.DELETE);
        walldist.sendKeys("10");
        String actuallayingArea = driver.findElement(By.id("s_lam")).getText();
        String actuallLCount = driver.findElement(By.id("l_count")).getText();
        String actuallPackCount = driver.findElement(By.id("l_packs")).getText();
        String actuallPrice = driver.findElement(By.id("l_price")).getText();
        String actuallRemainder = driver.findElement(By.id("l_over")).getText();
        String actuallTrash = driver.findElement(By.id("l_trash")).getText();
        Assert.assertEquals(actuallayingArea, expectedlayingArea);
        Assert.assertEquals(actuallLCount, expectedLCount);
        Assert.assertEquals(actuallPackCount,expectedPackCount);
        Assert.assertEquals(actuallPrice,expectedPrice);
        Assert.assertEquals(actuallRemainder,expectedRemainder);
        Assert.assertEquals(actuallTrash,expectedTrash);


    }

    @Test
    public void rehau() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String expectedPower = "53";
        String expectedPower2 = "4";
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        driver.findElement(By.id("el_f_width")).sendKeys("3");
        driver.findElement(By.id("el_f_lenght")).sendKeys("4");
        WebElement select1 = driver.findElement(By.id("room_type"));
        Select premises = new Select(select1);
        premises.selectByValue("3");
        WebElement select2 = driver.findElement(By.id("heating_type"));
        Select heating = new Select(select2);
        heating.selectByValue("2");
        driver.findElement(By.id("el_f_losses")).sendKeys("50");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        WebElement button = driver.findElement(By.cssSelector("[value='Рассчитать']"));
        button.click();
        String actualPower = driver.findElement(By.id("floor_cable_power")).getAttribute("value");
        String actualPower2 = driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value");
        Assert.assertEquals(actualPower, expectedPower);
        Assert.assertEquals(actualPower2, expectedPower2);
        driver.quit();

    }

    // задание со звездочкой если искать весь текст
    @Test
    public void hwWith() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String expectedLm = "Требуемое количество досок ламината: 53";
        String expectedCountLm = "Количество упаковок ламината: 7";
        driver.get("https://calc.by/building-calculators/laminate.html");
        WebElement lenght = driver.findElement(By.id("ln_room_id"));
        lenght.clear();
        lenght.sendKeys("500");
        WebElement widht = driver.findElement(By.id("wd_room_id"));
        widht.clear();
        widht.sendKeys("400");
        WebElement lenght1 = driver.findElement(By.id("ln_lam_id"));
        lenght1.clear();
        lenght1.sendKeys("2000");
        WebElement width = driver.findElement(By.id("wd_lam_id"));
        width.clear();
        width.sendKeys("200");
        WebElement selectLm = driver.findElement(By.id("direction-laminate-id1"));
        selectLm.click();
        driver.findElement(By.cssSelector("[class='calc-btn']")).click();
        String actualLm = driver.findElement(By.xpath("//div[text()='Требуемое количество досок ламината: ']")).getText();
        String actualCountLm = driver.findElement(By.xpath("//div[text()='Количество упаковок ламината: ']")).getText();
        Assert.assertEquals(actualLm, expectedLm);
        Assert.assertEquals(actualCountLm, expectedCountLm);
        driver.quit();


    }

    // задание со звездочкой если искать только цифровой результат без текста
    @Test
    public void hwWith1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String expectedLm = "53";
        String expectedCountLm = "7";
        driver.get("https://calc.by/building-calculators/laminate.html");
        WebElement lenght = driver.findElement(By.id("ln_room_id"));
        lenght.clear();
        lenght.sendKeys("500");
        WebElement widht = driver.findElement(By.id("wd_room_id"));
        widht.clear();
        widht.sendKeys("400");
        WebElement lenght1 = driver.findElement(By.id("ln_lam_id"));
        lenght1.clear();
        lenght1.sendKeys("2000");
        WebElement width = driver.findElement(By.id("wd_lam_id"));
        width.clear();
        width.sendKeys("200");
        WebElement selectLm = driver.findElement(By.id("direction-laminate-id1"));
        selectLm.click();
        driver.findElement(By.cssSelector("[class='calc-btn']")).click();
        String actualLm = driver.findElement(By.xpath("//div[text()='Требуемое количество досок ламината: ']/span")).getText();
        String actualCountLm = driver.findElement(By.xpath("//div[text()='Количество упаковок ламината: ']/span")).getText();
        Assert.assertEquals(actualLm, expectedLm);
        Assert.assertEquals(actualCountLm, expectedCountLm);
        driver.quit();

    }
}
