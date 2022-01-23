import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(Listener.class)
public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("--------calculator started working--------");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("--------calculator finished work--------");
    }
}
