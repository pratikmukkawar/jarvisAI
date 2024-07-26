package JarvisAPI.JarvisAPI;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Spree.Utils.Util_function;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONOBJMETHOD {
	
	String ID;
	@Test
	void jsonpath() throws IOException, ParseException {
		
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.get("https://reqres.in/api/users?page=2")
				.then()
				.extract()
				.response();
		response.getBody().prettyPrint();

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		// System.out.println("Response Body is => " + responseBody);
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is =>  " + statusCode);
		Assert.assertEquals(200, statusCode);

		Map<String, String> id_create = response.jsonPath().getJsonObject("data");
		ID = id_create.get("id");
	}

}
