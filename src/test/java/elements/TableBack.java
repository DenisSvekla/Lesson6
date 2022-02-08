package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TableBack {
    private  UIelement uIelement;

    public TableBack(WebDriver driver, By by) {
        this.uIelement = new UIelement(driver, by);
    }
    public TableBack(WebDriver driver, WebElement webElement) {
        this.uIelement = new UIelement(driver, webElement);
    }

    public UIelement getRow (int i) {
       ArrayList<UIelement> list = uIelement.findUIElements(By.tagName("tr"));
        return list.get(i);
    }

    public void getRow (String text) {

    }


    public void getColumn(int i) {


    }

    public void getColumn(String header) {

    }

    public UIelement getCell(int columnNumber, int rowNumber) {
        UIelement row = getRow(rowNumber);
        ArrayList<UIelement> list = row.findUIElements(By.tagName("td"));
        return list.get(columnNumber);
    }

    public UIelement getElementFromCell(UIelement cellElement, By by) {
        return cellElement.findElement(by);
    }
}
