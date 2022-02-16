package baseEntity;

import org.openqa.selenium.WebDriver;

//asdasd
public class BaseStep {
    protected WebDriver driver;
    protected Waits waits;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }
}
