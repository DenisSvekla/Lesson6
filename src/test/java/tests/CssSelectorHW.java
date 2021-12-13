package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CssSelectorHW {
    // Долго думал, что сделать, но решил пройтись по teachmeskills
    // https://teachmeskills.by/
    @Test
    public void cssSelector() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://teachmeskills.by/");
        WebElement classSelector = driver.findElement(By.cssSelector(".t-submit"));
        WebElement idSelector = driver.findElement(By.cssSelector("#t-footer"));
        WebElement tagSelector = driver.findElement(By.cssSelector("form"));
        WebElement tagAttribute = driver.findElement(By.cssSelector("img[imgfield='li_img__1633427021631']"));
        WebElement multipleClasses = driver.findElement(By.cssSelector(".r.t-rec.t-screenmin-980px"));
        WebElement simpleHierarchicalSelector = driver.findElement(By.cssSelector("#t-header .t-screenmax-980px"));
        WebElement searchPartAttribute = driver.findElement(By.cssSelector("img[src*='static.tildacdn.com/tild3061-383']"));
        WebElement searchAttribute = driver.findElement(By.cssSelector("div[class~='showed']"));
        WebElement valueEndsFromSelector = driver.findElement(By.cssSelector("img[src$='Syberry_logo.jpg']"));
        WebElement valueStarsFromSelector = driver.findElement(By.cssSelector("img[src^='https://static.tildacdn.com/tild6261']"));
        WebElement childAfterParent = driver.findElement(By.cssSelector("[href='tel:+375291055959']>span"));
        WebElement elementRightAfterElement = driver.findElement(By.cssSelector(".t-zoomer__container+.t-zoomer__bg"));
        WebElement elementOnTheSameLevel = driver.findElement(By.cssSelector(".t-zoomer__container~.showed"));
        WebElement firstChild = driver.findElement(By.cssSelector("div[field=descr2]>ul>li:first-child"));
        WebElement lastChild = driver.findElement(By.cssSelector("g[fill-rule=evenodd]>rect:last-child"));
        WebElement nthChildFromBegin = driver.findElement(By.cssSelector("body>div:nth-child(3)"));
        WebElement nthChildFromEnd = driver.findElement(By.cssSelector("#t-header~div:nth-last-child(7)"));

    }
}
