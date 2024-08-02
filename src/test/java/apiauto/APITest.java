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

    @Test
    static void PostUserTest(){
        RestAssured.baseURI = "https://reqres.in/";

        String name = "ziel";
        String job = "student";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("job",job);

        given().log().all()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(jsonObject.toString())
                .post("/api/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));

    }
}
