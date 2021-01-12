package example.status;

import example.TestBase;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Status200 extends TestBase {

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
        System.out.println(endpoint + ": " + status);
    }
}
