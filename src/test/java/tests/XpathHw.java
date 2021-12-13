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

        //form[@role='form']/div/div/div[@field='title']
        //form[@class='t-form']
        //form[@data-success-callback='t720_onSucces
        //h2[@field='title']
        //input[@type='hidden']


            //Использование логического оператора
            private static String searchByToAttribute = "//*[@class='form-control '  and @type='text']";

            //Использование логического оператора
            private static String searchBySpecificAttrPath = "//input[@type != 'hidden']";

            //Axes - оси
            //поиск всех родителей
            private static String path1 = "//*[@id='suite_mode_single_baseline']/ancestor::div";

            //Использование child - все предки текущего узла зависят от уровня
            private static String path2_1 = "//ul/child::li";
            private static String path2_2 = "//ul/li";  //аналог только проще


            // Использование descendant - все предки текущего узла не зависимо от уровня
            private static String path3_1 = "//ul/desсendant::span";
            private static String path3_2 = "//ul//span";  //аналог только проще


            //Использование following -  выбирает все в документе после закрытия тега текущего узла
            private static String path4_2 = "(//label[@for='announcement']/following::div/*[@class='checkbox'])[1]";

            //Использование following-sibling -  все предки текущего узла на одном уровне
            private static String path4_3 = "//label[@for='announcement']/following-sibling::div";


            // preceding идентичек following но работает до начала обрезного узла

            private static String path5 = "//label[@for='announcement']/preceding::div";
            private static String path6 = "//label[@for='announcement']/preceding-sibling::div";


        }
    }

