package Q4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookApiPost {
	
	private static final String BASE_URI = "https://bookstore.toolsqa.com/BookStore/v1";
	
	 @Test(priority = 1)
	    public void createBookData() {
	        RestAssured.baseURI = BASE_URI;

	        // Define the request body
	        String requestBody = "{\n" +
	                "  \"isbn\": \"9781234567897\",\n" +
	                "  \"title\": \"HarryPorter\",\n" +
	                "  \"subTitle\": \"The Boy Who Lived\",\n" +
	                "  \"author\": \"J.K. Rowling\",\n" +
	                "  \"publish_date\": \"2024-04-30\",\n" +
	                "  \"publisher\": \"Wizard Publications\",\n" +
	                "  \"pages\": 350,\n" +
	                "  \"description\": \"A thrilling tale of magic and adventure\",\n" +
	                "  \"website\": \"https://www.harrypotter.com\"\n" +
	                "}";

	        // Send the POST request to create a new book
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	                .when()
	                .post("/addBooks")
	                .then()
	                .extract()
	                .response();

	        // Verify the response status code is 201 (Created)
	        assertEquals(response.getStatusCode(), 201, "Response status code is not 201");

	        // Print the response body
	        System.out.println("Response Body:");
	        System.out.println(response.getBody().asString());
	    }
	

	 @Test(priority = 2)
	    public void testGetCreatedBook() {
	        RestAssured.baseURI = BASE_URI;

	        // Send the GET request to retrieve the created book
	        Response response = given()
	                .when()
	                .get("/Books/HarryPorter")
	                .then()
	                .extract()
	                .response();

	        assertEquals(response.getStatusCode(), 200, "Response status code is not 200");

	        // Verify that the book exists
	        assertTrue(response.getBody().asString().contains("HarryPorter"), "Book HarryPorter does not exist");

	        // Print the response body
	        System.out.println("Response Body:");
	        System.out.println(response.getBody().asString());
	    }

}
