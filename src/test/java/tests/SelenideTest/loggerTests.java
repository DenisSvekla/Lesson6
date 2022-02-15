package tests.SelenideTest;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class loggerTests {
    private static final Logger logger = LogManager.getLogger(loggerTests.class);


    @Test
    public void logTest() {
        logger.trace("Trace Message: начало теста....");
        logger.debug("Debug Message: ....");
        logger.info("Info Message: ....");
        logger.error("Error Message: ....");
        logger.fatal("Fatal Message: ....");
    }

    @Test
    public void loginTest() {
        logger.trace("login test is started...");
        logger.trace("инициализируем начальные переменные ....");
        int a = 10;
        int b = 0;

        if (b == 0) {
            logger.fatal("делитель равен нулю");
        }
        int cc = a / b;

        logger.trace("login test is finished");
    }
}

