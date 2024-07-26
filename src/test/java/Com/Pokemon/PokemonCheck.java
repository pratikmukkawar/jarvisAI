package Com.Pokemon;

import java.util.Scanner;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.PrettyPrinter;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PokemonCheck {
	String sc;
	@Test
	public void pokemoncheck() {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter Your Pokemon");
		
		String pokemonName=sc.nextLine();
		Integer pokemontype=sc.nextInt();
		
		
		//Url
		
				RestAssured.baseURI="https://pokeapi.co/api/v2";
				
				//Req object
				RequestSpecification httpreq=RestAssured.given();
				
				//header
				
				httpreq.header("Content-type","application/json");
				
				//Response Check
				
				Response response = httpreq.request(Method.GET,"/pokemon/"+pokemonName);
				Response rresponse = httpreq.request(Method.GET,"/pokemon/"+pokemontype);
				//print
				String res=response.getBody().asString();
				System.out.println(res);
				
				int statuscode = response.getStatusCode();
				System.out.println(statuscode);
				
				String rres=rresponse.getBody().asString();
				System.out.println(rres);
				
				int sstatuscode = rresponse.getStatusCode();
				System.out.println(sstatuscode);
				
	}

}
