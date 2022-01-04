import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    void onTestFailure (ITestListener result) {
        System.out.println("==============================");
        System.out.println("Screenshot has been captured.");
        System.out.println("==============================");
    }
    public void onTestStart(ITestResult result) {
        System.out.println(String.format("Test started: %s", result.getName()));
    }

}
