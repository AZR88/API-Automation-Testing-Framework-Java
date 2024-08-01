package apiauto;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    static void getUserTest(){

        RestAssured.baseURI = "https://reqres.in/";

        given().when().get("api/users?page=2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page", Matchers.equalTo(2))
                .assertThat().body("data.id", Matchers.hasSize(6));
    }
}
