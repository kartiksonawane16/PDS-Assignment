package Q;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class createUser {

	 private static final String BASE_URI = "https://reqres.in";
	 private static int userId;
	 
	 @Test(priority = 1)
	    public void createUserUsingPOJO() {
	        RestAssured.baseURI = BASE_URI;

	        // Create an instance of User with user details
	        User user = new User("Kartik", "Test Engineer");

	        // Send the POST request to create a new user
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .body(user)
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
	    public void getUser() {
	        RestAssured.baseURI = BASE_URI;

	        // Create an instance of User with user details
	        User user = new User("Kartik", "Test Engineer");

	        // Send the POST request to create a new user
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .body(user)
	                .when()
	                .get("/api/users")
	                .then()
	                .extract()
	                .response();

	        // Verify the response status code is 201 (Created)
	        assertEquals(response.getStatusCode(), 200, "Response status code is not 200");

	     // Print the response body
	        System.out.println("Response Body:");
	        System.out.println(response.getBody().asString());

	    }

	 @Test(priority = 3)
	 public void updateUser() {
	     RestAssured.baseURI = BASE_URI;

	     // Create an instance of User with updated details
	     User updatedUser = new User("Kartik", "Senior Test Engineer");

	     // Send the PUT request to update the user
	     Response response = given()
	             .contentType(ContentType.JSON)
	             .body(updatedUser)
	             .when()
	             .put("/api/users/{userId}", userId)
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
	 public void deleteUser() {
	     RestAssured.baseURI = BASE_URI;

	     // Create an instance of User with user details
	     User user = new User("Kartik", "Test Engineer");

	     // Send the POST request to create a new user
	     Response response = given()
	             .contentType(ContentType.JSON)
	             .body(user)
	             .when()
	             .delete("/api/users/{userId}", userId)
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
