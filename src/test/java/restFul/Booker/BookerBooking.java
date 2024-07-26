package restFul.Booker;

import java.util.ArrayList;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookerBooking {
	
	@Test
	public void Booking(){
		
		//Url
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
		
		//Req object
		RequestSpecification httpreq=RestAssured.given();
		
		//header
		
		httpreq.header("Content-type","application/json");
		
		//Response Check
		
		Response response = httpreq.request(Method.GET,"160");
		
		//print
		String res=response.getBody().asString();
		System.out.println(res);
		
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		
	
	
}}
	
	

