package Spree.Address.Contries;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Spree.Utils.Util_function;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Addressnew {
	String ID;
	String email;
	String New_Token;

	/*
	 * @BeforeTest public void preCondition() { accessToken =
	 * Utill_Function.oAuth_Token(); }
	 */
	@Test(priority = 1)
	public void createAnAccount() throws IOException, ParseException {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);
		String random_email = "Pattanaik"+randomInt+"@spree.com";
		JSONObject newAccount = new JSONObject();
		newAccount.put("email", random_email);
		newAccount.put("first_name", "Abhi");
		newAccount.put("last_name", "Dixit");
		newAccount.put("selected_locale", "en");
		newAccount.put("bill_address_id", ID);
		newAccount.put("ship_address_id", ID);
		newAccount.put("password", "spree123");
		newAccount.put("password_confirmation", "spree123");
		JSONObject body1 = new JSONObject();
		body1.put("user", newAccount);
		Response response = RestAssured.given().contentType(ContentType.JSON)
//				.body(Utill_Function.readFile("CreateAnAccount"))
                .body(body1)
				.post("https://demo.spreecommerce.org/api/v2/storefront/account").then().extract().response();
		response.getBody().prettyPrint();

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is =>  " + statusCode);
		Assert.assertEquals(200, statusCode);
		JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		email = jsonPathEvaluator.get("data.attributes.email").toString();

//		  Map<String, String> id_create = response.jsonPath().getJsonObject("data");
//	       ID=id_create.get("id");
//	
	}

	@Test(priority = 2)
	public void NewToken() {
		RestAssured.baseURI = "https://demo.spreecommerce.org";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("grant_type", "password");
		requestParams.put("username", email);
		requestParams.put("password", "spree123");

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.request(Method.POST, "/spree_oauth/token");
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
		New_Token = jsonPathEvaluator.get("access_token").toString();
		System.out.println("oAuth Token is =>  " + New_Token);

		// VErify that Token Type is Bearer or not
		String ActtokenType = jsonPathEvaluator.get("token_type").toString();
		String ExpTokenType = "Bearer";
		Assert.assertEquals(ExpTokenType, ActtokenType);

	}

	@Test(priority = 3)
	public void RetrieveAnAccount() throws IOException, ParseException {

		// String bearerToken = "PUx5Gt4DZ3ncE7CugwyULGLTy6BMLCXf4XztxZ_LVQ8";
		Response response = RestAssured.given().auth().oauth2(New_Token).contentType(ContentType.JSON)
				.get("https://demo.spreecommerce.org/api/v2/storefront/account").then().extract().response();
		response.getBody().prettyPrint();

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is =>  " + statusCode);
		Assert.assertEquals(200, statusCode);

		JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		ID = jsonPathEvaluator.get("data.id").toString();
		System.out.println(" id is =>  " + ID);
	}

	@Test(priority = 4)
	public void UpdateAnAccount() throws IOException, ParseException {
		// String bearerToken = "PUx5Gt4DZ3ncE7CugwyULGLTy6BMLCXf4XztxZ_LVQ8";
		JSONObject newAccount = new JSONObject();
		newAccount.put("email", email);
		newAccount.put("first_name", "Abhi");
		newAccount.put("last_name", "Dixit");
		newAccount.put("selected_locale", "en");
		newAccount.put("bill_address_id", ID);
		newAccount.put("ship_address_id", ID);
		newAccount.put("password", "spree123");
		newAccount.put("password_confirmation", "spree123");
		JSONObject body = new JSONObject();
		body.put("user", newAccount);
		Response response = RestAssured.given().auth().oauth2(New_Token).contentType(ContentType.JSON).body(body)
				.patch("https://demo.spreecommerce.org/api/v2/storefront/account").then().extract().response();
		response.getBody().prettyPrint();

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is =>  " + statusCode);
		Assert.assertEquals(200, statusCode);
	}
}


