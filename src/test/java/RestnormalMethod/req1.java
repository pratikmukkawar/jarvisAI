package RestnormalMethod;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.specification.RequestSpecification;

public class req1 {
	
	@Test
	void getreq1() {
	// uri 
	RestAssured.baseURI="https://reqres.in/api/users";
	
	
	//req obj
	RequestSpecification httpreq = RestAssured.given();
	
	//Response
	
	 Response response= httpreq.request(Method.GET,"/2");
	 
	 //print
	 
	String res= response.getBody().asString();
	System.out.println(res);
	
	//validations
	int val1=response.getStatusCode();
	System.out.println(val1);
	Assert.assertEquals(val1,200);
	
	//Varification
	String statusline = response.getStatusLine();
	System.out.println(statusline);
	Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
	

}
}