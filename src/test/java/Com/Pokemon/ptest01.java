package Com.Pokemon;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ptest01 {
	

	@Test
	public void resttest01() {
		
		Response response = RestAssured.given()
				.get("https://piconnect.flattrade.in/PiConnectTP")
				.then()
				.extract().response();
		//response.getBody().prettyPrint();
		String responseBody = response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);

	}

}
