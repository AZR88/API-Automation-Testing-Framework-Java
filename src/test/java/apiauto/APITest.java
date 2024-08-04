package apiauto;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    static void GetUser(){

        RestAssured.baseURI = "https://reqres.in/";

        given().when().get("api/users?page=2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page", Matchers.equalTo(2))
                .assertThat().body("data.id", Matchers.hasSize(6));
    }

    @Test
    public void PostUser(String name, String job, boolean shouldPass) {
        RestAssured.baseURI = "https://reqres.in/";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        if (shouldPass) {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(201)
                    .assertThat().body("name", Matchers.equalTo(name))
                    .assertThat().body("job", Matchers.equalTo(job))
                    .assertThat().body("$", Matchers.hasKey("id"))
                    .assertThat().body("$", Matchers.hasKey("createdAt"));
        } else {
            given().log().all()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(jsonObject.toString())
                    .post("/api/users")
                    .then()
                    .assertThat().statusCode(400); // Status code untuk negative test
        }
    }


    @Test
    static void  PutUser(){
        RestAssured.baseURI = "https://reqres.in/";
        int userId = 2;
        String newName ="updateUser";
        String newJob = "QA";

        String fname = given().when().get("/api/users/2"+userId).getBody().jsonPath().get("data.name");
        String ljob = given().when().get("/api/users/2"+userId).getBody().jsonPath().get("data.job");
        System.out.println("name before ="+fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("name", newName);
        bodyMap.put("job", newJob);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .put("/api/users/2"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", Matchers.equalTo(newName))
                .assertThat().body("job", Matchers.equalTo(newJob));
    }

    @Test
    static void  PatchUser(){
        RestAssured.baseURI = "https://reqres.in/";
        int userId = 2;
        String newName ="Agus";


        String fname = given().when().get("/api/users/2"+userId).getBody().jsonPath().get("data.name");
        String ljob = given().when().get("/api/users/2"+userId).getBody().jsonPath().get("data.job");
        System.out.println("name before ="+fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("name", newName);
        bodyMap.put("job", ljob);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type","application/json")
                .body(jsonObject.toString())
                .put("/api/users/2"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", Matchers.equalTo(newName))
                .assertThat().body("job", Matchers.equalTo(ljob));
    }

    @Test
    public void DeleteUser(){
        RestAssured.baseURI = "https://reqres.in/";

        int userToDelete = 2;

        given().log().all()
                .when().delete("/api/users/2"+userToDelete)
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }

}
