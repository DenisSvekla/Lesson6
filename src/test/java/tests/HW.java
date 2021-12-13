package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void masterskaya() {
        String expectedlayingArea = "31.76 м2.";
        String expectedLCount = "108 шт.";
        String expectedPackCount = "11 шт.";
        String expectedPrice = "1776 руб.";
        String expectedRemainder = "2 шт.";
        String expectedTrash = "34 шт.";

        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement leightInput = driver.findElement(By.name("calc_roomwidth"));
        WebElement widthInput = driver.findElement(By.name("calc_roomheight"));
        WebElement lamwidthInput = driver.findElement(By.name("calc_lamwidth"));
        WebElement lamheightInput = driver.findElement(By.name("calc_lamheight"));
        WebElement countinpackInput = driver.findElement(By.name("calc_inpack"));
        WebElement priceInput = driver.findElement(By.name("calc_price"));
        WebElement direction = driver.findElement(By.name("calc_direct"));
        WebElement bias = driver.findElement(By.name("calc_bias"));
        WebElement walldist = driver.findElement(By.name("calc_walldist"));

        leightInput.sendKeys("8,000");
        leightInput.sendKeys(Keys.DELETE);
        widthInput.sendKeys("4,000");
        widthInput.sendKeys(Keys.DELETE);
        lamwidthInput.sendKeys(Keys.DELETE, Keys.DELETE, Keys.DELETE, Keys.DELETE, "1700");
        lamheightInput.sendKeys(Keys.DELETE, Keys.DELETE, Keys.DELETE, Keys.DELETE);
        lamheightInput.sendKeys("190");
        countinpackInput.sendKeys(Keys.DELETE, Keys.DELETE, Keys.DELETE);
        countinpackInput.sendKeys("10");
        priceInput.sendKeys(Keys.DELETE, Keys.DELETE, Keys.DELETE);
        priceInput.sendKeys("50");
        Select select = new Select(direction);
        select.selectByValue("toh");
        bias.sendKeys(Keys.DELETE, Keys.DELETE, Keys.DELETE);
        bias.sendKeys("50");
        walldist.sendKeys(Keys.DELETE, Keys.DELETE, Keys.DELETE);
        walldist.sendKeys("10");
        String actuallayingArea = driver.findElement(By.id("s_lam")).getText();
        String actuallLCount = driver.findElement(By.id("l_count")).getText();
        String actuallPackCount = driver.findElement(By.id("l_packs")).getText();
        String actuallPrice = driver.findElement(By.id("l_price")).getText();
        String actuallRemainder = driver.findElement(By.id("l_over")).getText();
        String actuallTrash = driver.findElement(By.id("l_trash")).getText();
        Assert.assertEquals(actuallayingArea, expectedlayingArea);
        Assert.assertEquals(actuallLCount, expectedLCount);
        Assert.assertEquals(actuallPackCount, expectedPackCount);
        Assert.assertEquals(actuallPrice, expectedPrice);
        Assert.assertEquals(actuallRemainder, expectedRemainder);
        Assert.assertEquals(actuallTrash, expectedTrash);
    }

    @Test
    public void rehau() {
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
        WebElement button = driver.findElement(By.cssSelector("[value='Рассчитать']"));
        try {
            button.click();
        } catch (ElementClickInterceptedException exception) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)");
            button.click();
        }
        String actualPower = driver.findElement(By.id("floor_cable_power")).getAttribute("value");
        String actualPower2 = driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value");
        Assert.assertEquals(actualPower, expectedPower);
        Assert.assertEquals(actualPower2, expectedPower2);
    }

    // задание со звездочкой если искать весь текст
    @Test
    public void hwWith() {
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
    }

    // задание со звездочкой если искать только цифровой результат без текста
    @Test
    public void hwWith1() {
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
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
