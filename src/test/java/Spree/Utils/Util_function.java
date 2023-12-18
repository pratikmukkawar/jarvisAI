package Spree.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Util_function {
	
	String outh_token;
	
	public static String oAuth_Token() {
		  
		 RestAssured.baseURI ="https://demo.spreecommerce.org";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("grant_type", "password");
		 requestParams.put("username", "nice@spree.com");
		 requestParams.put("password", "spree123");
	 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json"); 
		 request.body(requestParams.toJSONString());
		 Response response = request.post("/spree_oauth/token");
		 //response.prettyPrint();
		 int statusCode = response.getStatusCode();
		 //System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 
		 // Now let us print the body of the message to see what response
		  // we have recieved from the server
		  String responseBody = response.getBody().asString();
		  
		 // String responseBody = response.getBody().toString();
		  //System.out.println("Response Body is =>  " + responseBody);
		  JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		  String outh_token=jsonPathEvaluator.get("access_token").toString();
		  System.out.println("oAuth Token is =>  " + outh_token);
		  // First get the JsonPath object instance from the Response interface
		  //Assert.assertEquals(responseBody.contains("Product was created with UI.") /*Expected value*/, true /*Actual Value*/, "Response body contains ");
		  return outh_token;
		 }
	public static JSONObject readFile(String filename) throws IOException, ParseException
	{
		
		//Create json object of JSONParser class to parse the JSON data
		  JSONParser jsonparser=new JSONParser();
		  //Create object for FileReader class, which help to load and read JSON file
		  FileReader reader = new FileReader(".\\JSON_file\\"+filename);
		  //Returning/assigning to Java Object
		  Object obj = jsonparser.parse(reader);
		  //Convert Java Object to JSON Object, JSONObject is typecast here
		  JSONObject prodjsonobj = (JSONObject)obj;
		return prodjsonobj;
		
	}
public static void deleteAllAddresses(String accessToken) {
		
		//get list of all address id
		List<String> addressIds = new ArrayList<String>();
		Response response = RestAssured.given()
				.auth()
				.oauth2(accessToken)
				.get("https://demo.spreecommerce.org/api/v2/storefront/account/addresses")
				.then().extract().response();
		Assert.assertEquals(200, response.getStatusCode());
		JsonPath jsonPathEva = response.getBody().jsonPath();
		ArrayList<Map<String, String>> data = jsonPathEva.get("data");
		for (Map<String, String> address: data) {
			addressIds.add(address.get("id"));
		}
		
		//delete all address
		for (String id: addressIds) {
			response = RestAssured.given()
					.auth()
					.oauth2(accessToken)
					.delete("https://demo.spreecommerce.org/api/v2/storefront/account/addresses/" + id)
					.then().extract().response();
			Assert.assertEquals(204, response.getStatusCode());
		}
		response = RestAssured.given()
				.auth()
				.oauth2(accessToken)
				.get("https://demo.spreecommerce.org/api/v2/storefront/account/addresses")
				.then().extract().response();
		 JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		 int numAddresses = Integer.parseInt(jsonPathEvaluator.get("meta.count").toString()) ;
		 Assert.assertEquals(numAddresses, 0);
	}
}
