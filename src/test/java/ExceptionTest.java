import org.testng.annotations.Test;

import java.util.List;

public class ExceptionTest {
   // Calculator calculator = new Calculator("Exception");

    @Test(expectedExceptions = NullPointerException.class)
    public void test() {
        List list = null;
        System.out.println(list.size());

    }



}
