package example.status;

import example.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Status200 extends TestBase {
    String browser;

    @Parameters("browser")
    @BeforeTest
    public void setBrowser(String browser) {
        this.browser = browser;
        System.out.println("Browser: " + browser);
    }

    @DataProvider(name = "getEndpointAndStatus")
    public Object[][] getEndpointAndStatus() {
        return new Object[][]{
                {"/", 404},
                {"/state/", 200},
                {"/state/1", 404}
        };
    }

    @Test(dataProvider = "getEndpointAndStatus")
    public void getState(String endpoint, Integer status) {
        System.out.println(browser + " - " + endpoint + ": " + status);
    }

    @Test
    public void failCase() {
        Assert.fail("Test Failure");
    }
}
