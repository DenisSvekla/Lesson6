package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }



    public WebElement findAnyProjectInDashboard(String name) {
        return driver.findElement(By.xpath("//a[contains(@href, 'index.php?/projects/overview/') and @Style and text()='name']"));

    }

    public WebElement findAnyProjectInProject(String name) {
        return driver.findElement(By.xpath("//a[contains(@href, 'index.php?/admin/edit/') and text()='name']"));

    }
}
