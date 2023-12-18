package Spree.Address.Contries;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.FileReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAddress {
	
	String outh_token;
	String ID;
	@BeforeTest
	void oAuthToken() {
		RestAssured.baseURI = "https://demo.spreecommerce.org";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("grant_type", "password");
		requestParams.put("username", "pratikm@spree.com");
		requestParams.put("password", "Test#123");
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.post("/spree_oauth/token");
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		// System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();

		// String responseBody = response.getBody().toString();
		// System.out.println("Response Body is => " + responseBody);
		JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		outh_token = jsonPathEvaluator.get("access_token").toString();
		System.out.println("oAuth Token is =>  " + outh_token);
		// First get the JsonPath object instance from the Response interface
		// Assert.assertEquals(responseBody.contains("Product was created with
		// UI.") /*Expected value*/, true /*Actual Value*/, "Response body
		// contains ");
	}
    
	@Test(priority=1)
	public void CreateAddress() throws IOException, ParseException {

		  //Create json object of JSONParser class to parse the JSON data
		  JSONParser jsonparser=new JSONParser();
		  //Create object for FileReader class, which help to load and read JSON file
		  FileReader reader = new FileReader(".\\JSON_file\\CreateAddress.json");
		  //Returning/assigning to Java Object
		  Object obj = jsonparser.parse(reader);
		  //Convert Java Object to JSON Object, JSONObject is typecast here
		  JSONObject prodjsonobj = (JSONObject)obj;
		
		//String bearerToken = "cFWLwgbsV-mTZtiYxzkR9YvQQTcE-NvSAhK44CmyVG";
		Response response = RestAssured.given()
				.auth()
				.oauth2(outh_token)
				.contentType(ContentType.JSON)
				.body(prodjsonobj)
				.post("https://demo.spreecommerce.org/api/v2/storefront/account/addresses")
				.then()
				.extract()
				.response();
		response.getBody().prettyPrint();
		

		// Now let us print the body of the message to see what response
		  // we have recieved from the server
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);
		  // Status Code Validation
		  int statusCode = response.getStatusCode();
		  System.out.println("Status code is =>  " + statusCode);
		  Assert.assertEquals(200, statusCode);	
 
		  // First get the JsonPath object instance from the Response interface
		 //Assert.assertEquals(responseBody.contains("Komal") /*Expected value*/, true /*Actual Value*/, "Response body contains Abhi");
		  // convert the body into lower case and then do a comparison to ignore casing.
		 //Assert.assertEquals(responseBody.contains("K") /*Expected value*/, true /*Actual Value*/, "Response body contains Dixit");

		 JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		  String fname=jsonPathEvaluator.get("data.attributes.firstname").toString();
		  System.out.println("First Name is =>  " + fname);
		  Assert.assertEquals(fname, "Sundar");
		  // VErify that Token Type is Bearer or not
		  String Lname=jsonPathEvaluator.get("data.attributes.lastname").toString();
		  //String ExpTokenType = "Bearer";
		  Assert.assertEquals(Lname, "Pichai");
	}
	@Test(priority=2)
	public void Update_Address() throws IOException, ParseException {

		  //Create json object of JSONParser class to parse the JSON data
		  JSONParser jsonparser=new JSONParser();
		  //Create object for FileReader class, which help to load and read JSON file
		  FileReader reader = new FileReader(".\\JSON_file\\updateaddress.json");
		  //Returning/assigning to Java Object
		  Object obj = jsonparser.parse(reader);
		  //Convert Java Object to JSON Object, JSONObject is typecast here
		  JSONObject prodjsonobj = (JSONObject)obj;
		
		  //String bearerToken = "PUx5Gt4DZ3ncE7CugwyULGLTy6BMLCXf4XztxZ_LVQ8";
		Response response = RestAssured.given()
				.auth()
				.oauth2(outh_token)
				.contentType(ContentType.JSON)
				.body(prodjsonobj)
				.patch("https://demo.spreecommerce.org/api/v2/storefront/account/addresses/"+ID)
				.then()
				.extract()
				.response();
		response.getBody().prettyPrint();
		

		// Now let us print the body of the message to see what response
		  // we have recieved from the server
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);
		  // Status Code Validation
		  int statusCode = response.getStatusCode();
		  System.out.println("Status code is =>  " + statusCode);
		  Assert.assertEquals(200, statusCode);	

		  Map<String, String> default_billing_address = response.jsonPath().getJsonObject("data.attributes");
	        String firstName=default_billing_address.get("firstname");
	        Assert.assertEquals(firstName, "Abhi");

	        String lastName=default_billing_address.get("lastname");
	        Assert.assertEquals(lastName, "Dixit");

	        String addressOne=default_billing_address.get("address1");
	        Assert.assertEquals(addressOne, "Jayanagar, Bangalore");

	        String addressTwo=default_billing_address.get("address2");
	        Assert.assertEquals(addressTwo, "4th T Block 19th Cross");
	}	 	
}