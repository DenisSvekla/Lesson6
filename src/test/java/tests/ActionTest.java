package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest extends BaseTest {

    @Test
    public void actionTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement source1 = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(source)
                .clickAndHold()
                .moveToElement(source1)
                .release()
                //.dragAndDrop(source,source1)
                .build()
                .perform();
        Thread.sleep(10000);
    }
    @Test
    public void actionTest2() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement alert = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                //.moveToElement(alert)
                .contextClick(alert)
                .build()
                .perform();
        Thread.sleep(10000);
    }

}
