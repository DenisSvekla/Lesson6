package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private  UIelement uIelement;
    private WebDriver driver;

    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.uIelement = new UIelement(driver, by);
    }
    public Table(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uIelement = new UIelement(driver, webElement);
    }

    public  TableRow  getRow (int i) {
       ArrayList<UIelement> list = uIelement.findUIElements(By.tagName("tr"));
        return new TableRow(driver,list.get(i));
    }

    public void getRow (String text) {

    }


    public void getColumn(int i) {


    }

    public void getColumn(String header) {

    }

    public UIelement getCell(int columnNumber) {
        ArrayList<UIelement> list = uIelement.findUIElements(By.tagName("td"));
        return list.get(columnNumber);
    }

    public UIelement getElementFromCell(UIelement cellElement, By by) {
        return cellElement.findElement(by);
    }
}
