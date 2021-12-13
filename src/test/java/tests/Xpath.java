package tests;

public class Xpath {
    private static String absolutePath = "/html/body/div";

    //все элементы на странице, начиная с html тега
    private static String allElementInHtmlPath = "//*";

    // элемент по тегу
    private static String bodyPath = "//body";

    //поиск дочернего относительно родителя
    private static String childPath = "//form/input";

    //поиск элемента с атрибутом и его значением
    private static String tagWithAttribute = "//span[@id='access--1']";

    //поиск родителя у элемента с аттрибутом и его значением
    private static String parentPath = "//span[@id='access--1']/..";

    //поиск элемента по индексу
    private static String elementByIndexPath = "(//form)[5]";

    //поиск элемента по тексту (по полному соответствию)
    private static String searchByTextPath = "//*[text() = 'NewWidget']";
    private static String searchByTextPath1 = "//*[. = 'NewWidget']";

    //поиск элемента по подстроке в тексте
    private static String searchBySubStringPath = "//*[contains(text() = 'NewWidget')]";

    //Использование логического оператора
    private static String searchByToAttribute = "//*[@class='form-control '  and @type='text']";



    //*[@class='form-control '  and @type='text']
    //*[@class='form-control '  and @type='text']


}
