package tests;

import org.openqa.selenium.By;

public class CssSelector {

    private void cssSelectors() {
        By classisSelector = By.cssSelector(".d-none"); // поиск по классу d-none
        // =
        By classisSelector1 = By.className("d-none"); // поиск по классу d-none

        By idSelector = By.cssSelector("#suite_mode_single"); // поиск по id
        //=
        By idSelector1 = By.id("suite_mode_single"); // поиск по id

        By tagSelector = By.cssSelector("label"); // поиск по tag
        //=
        By tagSelector1 = By.id("label"); // поиск по tag

        By tagAttributySelector = By.cssSelector("label[for='name']"); // поиск по tag и его атрибуту с значением
        By tagAttributySelector1 = By.cssSelector("label[for='name']"); // поиск по tag и его атрибутом

        By multipleClasses = By.cssSelector(".column.overflow-content"); // поиск по двум классам в элементе
        //...............................................................// можно и больше, каждый класс разделяется точкой

        By simpleHierarchicalSelector = By.cssSelector(".table .content-inner"); // поиск простого дочернего элемента
        By fullHierarchicalSelector = By.cssSelector("body .table .content-inner");

        By searchLokeContainsSelector = By.cssSelector("div[class~='column']");// поиск со значением слова в значении атрибута
        By fullHierarchicalSelector2 = By.cssSelector("div[class*='admin']"); // поиском с вхождением подстроки в
        //.....................................................................// значении атрибута

        By valueStarsFromSelector = By.cssSelector("a[href^='https://']"); // поиск элемента с атрибутом значение которого начинается с
        //.................................................................//которого начинается с

        By valueEndsFromSelector = By.cssSelector("a[href$='@gmail.com']"); // поиск элемента с атрибутом значение которого начинается с
        //.................................................................//которого заканчивается с

        By  childAfterParent = By.cssSelector("ul>li"); //поиск дочернего li у которого родитель ul

        By  elementRightAfterElement = By.cssSelector("#form+script"); //поиск элемента script который идет сразу после
        //.............................................................//элемента form

        By  elementOnTheSameLevel = By.cssSelector("#form~script"); //поиск поиск элементов script которым/ый
        //.....................................................//предшествует элементу #form не обязательно сразу

        By  firstChild = By.cssSelector("li:first-child"); //поиск первого дочернего элемента
        By  lastChild = By.cssSelector("li:last-child"); //поиск последнего дочернего элемента
        By  nthChildFromBegin = By.cssSelector("li:nth-child(2)"); //поиск n дочернего элемента с начала
        By  nthChildFromEnd = By.cssSelector("li:nth-last-child(4)"); //поиск n дочернего элемента с конца


    }
}
