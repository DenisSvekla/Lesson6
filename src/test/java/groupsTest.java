import org.testng.annotations.Test;

public class groupsTest extends BaseTest {

    @Test (groups = {"smoke","sanity", "regression"}, description = "1123123")
    public void testSmokeTest () {
        System.out.println("groupsTest -> testSmokeTest");
    }

    @Test (groups = {"sanity", "regression"},description = "1122dd23123")
    public void sanityTest () {
        System.out.println("groupsTest -> sanityTest");
    }

    @Test (groups = "regression")
    public void regressionTest () {
        System.out.println("groupsTest -> regressionTest");
    }
}
