package Que1;

import java.util.HashMap;
import org.testng.annotations.Test;
/*
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
*/

public class APITest {

	private static final String BASE_URI = "https://reqres.in";

    // 1. Create a new user using HashMap for POST request body
    @Test
    public void createUserUsingHashMap() {
        RestAssured.baseURI = BASE_URI;

        // Define the request body using HashMap
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Kartik");
        requestBody.put("job", "Test Engineer");

        // Send the POST request to create a new user
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .extract()
                .response();

        // Verify the response status code is 201 (Created)
        assertEquals(response.getStatusCode(), 201, "Response status code is not 201");

        // Extract and print the newly created user ID
        String userId = response.jsonPath().getString("id");
        System.out.println("Newly created user ID: " + userId);

    }




}
