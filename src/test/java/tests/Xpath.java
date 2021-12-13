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
    private static String parentPath1 = "//*[@id='suite_mode_single']/parent::label";

    //*[@id='suite_mode_single']/parent:

    //поиск элемента по индексу
    private static String elementByIndexPath = "(//form)[5]";

    //поиск элемента по тексту (по полному соответствию)
    private static String searchByTextPath = "//*[text() = 'NewWidget']";
    private static String searchByTextPath1 = "//*[. = 'NewWidget']";

    //поиск элемента по подстроке в тексте
    private static String searchBySubStringPath = "//*[contains(text() = 'NewWidget')]";


    //поиск элемента по атрибуту значение которого начинается с
    private static String searchByStratsWith = "//input[starts-with(@type, 'hi')]";

    //*[@id='suite_mode_single_baseline']/ancestor::div

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
