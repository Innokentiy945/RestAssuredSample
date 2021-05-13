package Smoke;

import Builder.Builder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class SmokeTests {

    @Test
    public void getData() {
        Response response = given()
                .spec(Builder.getBuilder())
                .get();

        int statusCode = 200;
        Assert.assertEquals(statusCode, response.statusCode());

        String expectedResponse = response.getBody().asString();
        assertThat(expectedResponse, containsString("id"));
        assertThat(expectedResponse, containsString("title"));
        assertThat(expectedResponse, containsString("description"));
        assertThat(expectedResponse, containsString("Exhibition"));
    }

    @DataProvider(name = "dpParam")
    public Object[][] dpParam() {
        Object[][] testData = new Object[][] {
                new Object[] { "Exhibition", "Art" },
                new Object[] { "Exhibition", "Sculpture" },
                new Object[] { "Exhibition", "Shop" },
                new Object[] { "Exhibition", "Bathroom" }
        };
        return testData;
    }

    @Test(dataProvider = "dpParam")
    public void postData(String title, String description) {
        Response response = given()
                .spec(Builder.postBuilder(title, description))
                .post();

        String expectedResponse = response.getBody().asString();
        assertThat(expectedResponse, containsString("Exhibition"));
    }

    @Test
    public void putData() {
        Response response = given()
                .spec(Builder.putBuilder("/67", "Classic art", "Classic art"))
                .put();

        String expectedResponse = response.getBody().asString();
        assertThat(expectedResponse, containsString("Classic art"));
    }

    @Test
    public void deleteData() {
        Response response = given()
                .spec(Builder.deleteBuilder("/67", "Classic art", "Classic art"))
                .put();

        String expectedResponse = response.getBody().asString();
        assertThat(expectedResponse, not("Classic art"));
    }
}
