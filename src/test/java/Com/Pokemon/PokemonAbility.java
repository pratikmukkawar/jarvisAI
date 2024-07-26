package Com.Pokemon;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PokemonAbility {
	@Test
	public void PokemonStatus() {
	Scanner sc = new Scanner (System.in);
	
	System.out.println("Enter Your PokemonAbility");
	
	String pokemonAble=sc.nextLine();
	
	
	//Url
			RestAssured.baseURI="https://pokeapi.co/api/v2";
			
			//Req object
			RequestSpecification httpreq=RestAssured.given();
			
			//header
			
			httpreq.header("Content-type","application/json");
			
			//Response Check
			
			Response response = httpreq.request(Method.GET,"/ability/"+pokemonAble);//"battle-armor,blaze, check online pokemon ability types"
			
			//print
			response.prettyPrint();
			String res=response.getBody().asString();
			System.out.println(res);
			
			int statuscode = response.getStatusCode();
			System.out.println(statuscode);

}}
