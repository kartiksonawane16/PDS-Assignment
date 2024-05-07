package Q2;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtJSONFile {
	
	private static final String BASE_URI = "https://reqres.in";
	private static  String USER_ID;
	private static final String filePath = "C:\\Users\\karsonaw\\Desktop";

    // Create a new user using external JSON file for POST request body
    @Test(priority = 1)
    public void createUserUsingExternalJSONFile() {
        RestAssured.baseURI = BASE_URI;

        // Send the POST request to create a new user with external JSON file data
        Response response = given()
                .contentType(ContentType.JSON)
                .body(new File(filePath))
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
    
    @Test(priority = 2)
    public void getUserData() {
        RestAssured.baseURI = BASE_URI;

        // Send the GET request to retrieve user data
        Response response = given()
                .when()
                .get("/api/users")
                .then()
                .extract()
                .response();

        // Verify the response status code is 200 (OK)
        assertEquals(response.getStatusCode(), 200, "Response status code is not 200");

        // Print the response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }
    
    @Test(priority = 3)
    public void updateUserData() {
        RestAssured.baseURI = BASE_URI;

        // Send the PUT request to update user data
        Response response = given()
                .contentType(ContentType.JSON)
                .body(new File(filePath))
                .when()
                .put("/api/users/{userId}", USER_ID)
                .then()
                .extract()
                .response();

        // Verify the response status code is 200 (OK) for successful update
        assertEquals(response.getStatusCode(), 200, "Response status code is not 200");

        // Print the response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }
    
    
    @Test(priority = 4)
    public void deleteUserData() {
        RestAssured.baseURI = BASE_URI;

        // Send the DELETE request to delete user data
        Response response = given()
                .when()
                .delete("/api/users/{userId}", USER_ID)
                .then()
                .extract()
                .response();

        // Verify the response status code is 204 (No Content) for successful deletion
        assertEquals(response.getStatusCode(), 204, "Response status code is not 204");

        // Print the response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }


}
