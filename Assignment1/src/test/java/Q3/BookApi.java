package Q3;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class BookApi {

	private static final String BASE_URI = "https://bookstore.toolsqa.com/BookStore/v1";


    @Test
    public void testGetBookDetails() {
    	
        RestAssured.baseURI = BASE_URI;

        // Send the request to get book details
        Response response = given()
                .when()
                .get("/Books")
                .then()
                .log().all()
                .extract()
                .response();

        // Verify the response status code
        assertEquals(response.getStatusCode(), 200, "Response status code is not 200");

        // Print the response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
    }

}
