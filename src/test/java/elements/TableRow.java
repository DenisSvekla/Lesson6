package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TableRow {
    private  UIelement uIelement;

    public TableRow(WebDriver driver, By by) {
        this.uIelement = new UIelement(driver, by);
    }
    public TableRow (WebDriver driver, WebElement webElement) {
        this.uIelement = new UIelement(driver, webElement);
    }

    public TableRow (WebDriver driver, UIelement uIelement) {
        this.uIelement = new UIelement(driver, uIelement);
    }

    public ArrayList<UIelement> findUIElements(By by) {
        return  uIelement.findUIElements(by);
    }


}
