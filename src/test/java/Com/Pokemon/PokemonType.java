package Com.Pokemon;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PokemonType {
	 String isbn;
	    String title;
	    String subtitle;
	    String author;
	    String published;
	    String publisher;
	    int pages;
	    String description;
	    String website;
	@Test
	public void poketipe() throws MalformedURLException {
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Enter Your Pokemon type id(. .)=");
			
			Integer pokemontypeid=sc.nextInt();
			
			
			//Url
					RestAssured.baseURI="https://pokeapi.co/api/v2";
					
					//Req object
					RequestSpecification httpreq=RestAssured.given();
					
					//arry list
					
					
					//header
					
					httpreq.header("Content-type","application/json");
					
					//Response Check
					
					Response response = httpreq.request(Method.GET,"/type/"+pokemontypeid);//"battle-armor,blaze, check online pokemon ability types"
					
					//print
					response.prettyPrint();
					String res=response.getBody().asString();
					System.out.println(res);
					
					int statuscode = response.getStatusCode();
					System.out.println(statuscode);
					
					
	}

}
