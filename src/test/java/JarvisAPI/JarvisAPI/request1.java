package JarvisAPI.JarvisAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class request1 {
	int id;

	@Test(enabled = false)
	void getUser() {

		given()

				.when().get("https://reqres.in/api/users?page=2")
				.then()
				.statusCode(200)

				.log().all();

	}

	@Test(priority = 1)
	void createUser() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "Pratik");
		hm.put("job", "SDET");

		id = given().contentType("application/json").body(hm)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		/*
		 * .then() .statusCode(201) .log().all();
		 */
	}
    @Test(priority = 1)
	void UpdateUser() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "Pratik Jarvis");
		hm.put("job","SQA");
		
		given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		      .put("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200)
		.log().all();	
		
	}

}
