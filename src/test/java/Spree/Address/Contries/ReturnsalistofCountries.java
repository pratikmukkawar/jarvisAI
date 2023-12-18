package Spree.Address.Contries;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReturnsalistofCountries {
	@Test
	void getCountries() {
		
		// uri 
		RestAssured.baseURI="https://demo.spreecommerce.org";
		
		
		//req obj
		RequestSpecification httpreq = RestAssured.given();
		
		//Response
		
		 Response response= httpreq.request(Method.GET,"/api/v2/storefront/countries/default");
		 
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
