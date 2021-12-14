package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathHw {

    @Test
    public void xpathHw() {
        // также как и в прошлый раз использовал сайт teachmeskills
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://teachmeskills.by/");
        WebElement absolutePath = driver.findElement(By.xpath("/html/body/div[@id='allrecords']"));
        WebElement tagAttribute = driver.findElement(By.xpath("//div[@id='t-header']"));
        WebElement childPath = driver.findElement(By.xpath("//div[@class='t858']/div[@class='t-container']"));
        WebElement parentPath = driver.findElement(By.xpath("//div[@class='t-zoomer__close']/.."));
        WebElement parentPath1 = driver.findElement(By.xpath("//span[text()='Как построен ']/parent::div"));
        WebElement elementByIndexPath = driver.findElement(By.xpath("(//*[@id='t-header']/div)[2]"));
        WebElement searchByTextPath = driver.findElement(By.xpath("//*[text()='Помощь в поиске работы']"));
        WebElement searchByTextPath1 = driver.findElement(By.xpath("//span[. ='Помощь в поиске работы']"));
        WebElement searchBySubStringPath = driver.findElement(By.xpath("//*[contains(text(), 'на реальных проектах')]"));
        WebElement searchByStratsWith = driver.findElement(By.xpath("//div[starts-with(@id, 'rec82930')]")); // возможно эта айдишка динамическая, но при нескольких обновлений, айдишка не менялась
        WebElement seachWithOperator = driver.findElement(By.xpath("//iframe[@id='roistat-lh-popup-iframe' and @frameborder='0']"));
        WebElement pathParentBeforeAncestor = driver.findElement(By.xpath("//*[@id='t-header']/ancestor::div"));
        WebElement useChild = driver.findElement(By.xpath("(//ul/child::li[@class='t228__list_item'])[2]"));
        WebElement useDescndant = driver.findElement(By.xpath("//*[@class='t-cover' and contains(@id, 'recorddiv82')]/descendant::div[@class='t001__wrapper']"));
        WebElement useFollowing = driver.findElement(By.xpath("//*[text()='Помощь в поиске работы']/following::div[@class='t-cover' and @bgimgfield='img']"));
        WebElement useFollowingSibling = driver.findElement(By.xpath("//*[@id='allrecords']/following-sibling::div[@class='roistat-lh-hidden' and @style]"));
        WebElement usePreceding = driver.findElement(By.xpath("//*[@class='t-cover__arrow']/preceding::h1"));
        WebElement usePrecedingSibling = driver.findElement(By.xpath("//*[@class='t-cover__arrow']/preceding-sibling::div[@class='t-container']"));
    }
}

