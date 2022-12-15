package api_Testing;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class Response_Methods {
	
	
	@Test
	public String Post_RequestForToken(String payload) {
		RestAssured.baseURI = "http://trainingapi.jalaacademy.com";	 		//  Specify Base Url for Api Testing
		RequestSpecification request = RestAssured.given(); 		// Request for API Response
		request.header("Content-Type","application/json");
		Response response = request.body(payload).post("/api/signin");	 		// Post the response by payload
		response.prettyPrint();	 		// Http response Body Print
		int statusCode = response.statusCode(); 		// Http Status Code
		System.out.println("http Status Code:"+ statusCode);// Http Status Code
		Assert.assertEquals(200, statusCode);	
		String jsonString = response.getBody().asString();
		String signing_Token = JsonPath.from(jsonString).get("token"); 		//Http Bearer Token
		return signing_Token;
	}
	
	@Test
	public int get_Request(String token, int pageno) {
		RestAssured.baseURI = "http://trainingapi.jalaacademy.com";
		RequestSpecification request = RestAssured.given();
		// String token = "895|4WvSw8vkBj8l2slXU5OoUP11xbYScTg8e62uSYE0";
		request.header("Authorization","Bearer "+token)
			.header("Content-Type","application/json");
		Response response = request.body("").get("/api/users?search=&page="+ pageno);
		response.prettyPrint();
		int statusCode = response.statusCode(); 		// Http Status Code
		System.out.println("http Status Code:"+ statusCode);// Http Status Code
		Assert.assertEquals(200, statusCode);
		return statusCode;

	} 
	
	@Test
	public String post_Request(String token, String payload) {
		RestAssured.baseURI = "http://trainingapi.jalaacademy.com";
		RequestSpecification request = RestAssured.given();	
		request.header("Authorization","Bearer "+ token)
			.header("Content-Type","application/json");
		Response response = request.body(payload).post("/api/users");
		response.prettyPrint(); 
		int statusCode = response.statusCode(); 		// Http Status Code
		System.out.println("http Status Code:"+ statusCode);// Http Status Code

		Assert.assertEquals(201, statusCode);
		String jsonString = response.getBody().asString();
		return jsonString;
	}
	 
	@Test
	public String put_Request(int id, String token, String payload) {
		RestAssured.baseURI = "http://trainingapi.jalaacademy.com";
		RequestSpecification request  =  RestAssured.given();
		request.header("Authorization","Bearer "+ token)
			.header("Content-Type","application/json");
		Response response = request.body(payload).put("/api/users/"+id);
		response.prettyPrint();
		int statusCode = response.statusCode();
		System.out.println("http Status Code:"+ statusCode);// Http Status Code
		Assert.assertEquals(200, statusCode);
		String jsonString = response.getBody().asString();
		return jsonString; 
		
	}
	
	@Test
	public String delete_Request(int id, String token ) {
		RestAssured.baseURI = "http://trainingapi.jalaacademy.com";
		RequestSpecification request  =  RestAssured.given();
		request.header("Authorization","Bearer "+ token)
			.header("Content-Type","application/json");
		Response response = request.body("").delete("/api/users/"+id);
		response.prettyPrint();
		int statusCode = response.statusCode(); 
		System.out.println("http Status Code:"+ statusCode);// Http Status Code
		Assert.assertEquals(200, statusCode);
		String jsonString = response.getBody().asString();
		return jsonString; 
		
	}
}

