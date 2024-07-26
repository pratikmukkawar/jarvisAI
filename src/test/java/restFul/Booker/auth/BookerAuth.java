package restFul.Booker.auth;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookerAuth {
	@Test
	void AuthBooker() {
	 RestAssured.baseURI ="https://restful-booker.herokuapp.com";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("username", "admin");
	 requestParams.put("password", "password123");
	 
	 
 // Add a header stating the Request body is a JSON
	 request.header("Content-Type", "application/json"); 
	 request.body(requestParams.toJSONString());
	 Response response = request.request(Method.POST,"/auth");
	 response.prettyPrint();
	 int statusCode = response.getStatusCode();
	 //System.out.println(response.asString());
	 Assert.assertEquals(statusCode, 200); 
	 
	 // Now let us print the body of the message to see what response
	  // we have recieved from the server
	  String responseBody = response.getBody().asString();
	  
	 // String responseBody = response.getBody().toString();
	  //System.out.println("Response Body is =>  " + responseBody);
		
		 JsonPath jsonPathEvaluator = response.getBody().jsonPath(); String
		  Bookerouth_token=jsonPathEvaluator.get("token").toString();
		 System.out.println("oAuth Token is =>  " + Bookerouth_token);
		 
	  
	  // VErify that Token Type is Bearer or not
		/*
		 * String ActtokenType=jsonPathEvaluator.get("token_type").toString(); String
		 * ExpTokenType = "Bearer"; Assert.assertEquals(ExpTokenType, ActtokenType);
		 */

}}
