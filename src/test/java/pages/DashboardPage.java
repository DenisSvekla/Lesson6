package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private static String ENDPOINT = "/dashboard";
    // добавить индефикатор
    private static final By PAGE_OPENED_IDENTIFIER = By.id("activityChart");
    private By ADD_PROJECT_BUTTON_CREATE = By.id("sidebar-projects-add");
    private By MOST_ACTIVE_BUTTON = By.cssSelector(".link.link-tooltip");
    private By DOWNLOAD_IMG_BUTTON = By.id("png-download");
    private By DOWNLOAD_CSV_BUTTON = By.id("csv-download");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL +ENDPOINT);
    }

    public boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }


    public WebElement getAddProjectButton () {
        return driver.findElement(ADD_PROJECT_BUTTON_CREATE);
    }
    public WebElement getMostActiveButton () { return driver.findElement(MOST_ACTIVE_BUTTON);}
    public WebElement getDownloadImgButton () { return driver.findElement(DOWNLOAD_IMG_BUTTON);}
    public WebElement getDownloadCsvButton () { return driver.findElement(DOWNLOAD_CSV_BUTTON);}
    public WebElement findAnyProjectInDashboard(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href, 'index.php?/projects/overview/') and @Style and text()='"+nameProject+"']"));
    }
    public WebElement getToDoButtonForAnyProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href,'index.php?/projects/overview/') " +
                "and text()='"+ nameProject +"' and @style]/../../..//a[contains(@href,'index.php?/todos/overview/')" +
                " and @class='link']"));
    }
    public WebElement getMilestonesButtonForAnyProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href,'index.php?/projects/overview/') " +
                "and text()='"+ nameProject +"' and @style]/../../..//a[contains(@href,'index.php?/milestones/overview/') and @class='link']"));
    }
    public WebElement getTestRunsButtonForAnyProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href,'index.php?/projects/overview/') " +
                "and text()='"+ nameProject +"' and @style]/../../..//a[contains(@href,'index.php?/runs/overview/') and @class='link']"));
    }
    public WebElement getTestCasesButtonForAnyProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href,'index.php?/projects/overview/')" +
                "and text()='"+ nameProject +"' and @style]/../../..//a[contains(@href,'index.php?/suites/view/') and @class='link']"));
    }
    public WebElement getReportsButtonForAnyProject(String nameProject) {
        return driver.findElement(By.xpath("//a[contains(@href,'index.php?/projects/overview/') " +
                "and text()='"+ nameProject +"' and @style]/../../..//a[contains(@href,'index.php?/reports/overview/') and @class='link']"));
    }



}
