package tests.gui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureTest {

    @Test (description = "Read this is later. He is bad apple")
    public void testName() {
        Assert.assertTrue(true);
    }

    @Test
    @Description("Some detailed test description")
    public void testDescription () {
        Assert.assertTrue(true);
    }

    @Test
    @Issue("PR-123")
    @Issue("PR-124")

    public void testIssue () {
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("TMS-123")
    @TmsLink("TMS-123")

    public void testTMS () {
        Assert.assertTrue(true);
    }
    @Test
    @Link("https://example.org")
    @Link(name = "allureLink", type = "myLink", url = "http://onliner.by")

    public void testLink () {
        Assert.assertTrue(false);
    }
}
