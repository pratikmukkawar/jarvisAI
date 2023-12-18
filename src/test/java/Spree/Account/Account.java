package Spree.Account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Account {

	@Test
	public static void createnewac() throws IOException, ParseException {
		/*
		 * String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // create random string
		 * builder StringBuilder sb = new StringBuilder(); // create an object of Random
		 * class Random random = new Random(); // specify length of random string int
		 * length = 7; for (int i = 0; i < length; i++) { // generate random index
		 * number int index = random.nextInt(alphabet.length()); // get character
		 * specified by index // from the string char randomChar =
		 * alphabet.charAt(index);
		 * 
		 * // append the character to string builder sb.append(randomChar); } String
		 * randomString = sb.toString(); System.out.println("Random String is: " +
		 * randomString + "@spree.com");
		 * 
		 * RestAssured.baseURI = "https://demo.spreecommerce.org"; RequestSpecification
		 * request = RestAssured.given(); //Payload JSONObject user = new JSONObject();
		 * user.put("email", randomString + "@spree.com"); user.put("first_name",
		 * "Pratik"); user.put("last_name", "Aquaman"); user.put("selected_locale",
		 * "en"); user.put("password", "Test#123"); user.put("password_confirmation",
		 * "Test#123");
		 * 
		 * 
		 * // Add a header stating the Request body is a JSON
		 * request.header("Content-Type", "application/vnd.api+json");
		 * request.body(user.toJSONString());
		 * 
		 * 
		 * 
		 * Response response =
		 * request.request(Method.POST,"/api/v2/storefront/account");
		 * response.prettyPrint();
		 */
		 //Create json object of JSONParser class to parse the JSON data
		  JSONParser jsonparser=new JSONParser();
		  //Create object for FileReader class, which help to load and read JSON file
		  FileReader reader = new FileReader(".\\JSON_file\\Accountdetails.json");
		  //Returning/assigning to Java Object
		  Object obj = jsonparser.parse(reader);
		  //Convert Java Object to JSON Object, JSONObject is typecast here
		  JSONObject prodjsonobj = (JSONObject)obj;
		  
		//String bearerToken = "cFWLwgbsV-mTZtiYxzkR9YvQQTcE-NvSAhK44CmyVG";
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(prodjsonobj)
				.post("https://demo.spreecommerce.org/api/v2/storefront/account")
				.then()
				.extract()
				.response();
		response.getBody().prettyPrint();
		String responseBody = response.getBody().asString();
		  System.out.println("Response Body is =>  " + responseBody);


	}
}
