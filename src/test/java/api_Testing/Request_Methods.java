package api_Testing;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Request_Methods{

	public static String token = "";
	public static int id;


	@Test
	public String Signin() {
		Response_Methods httpRequest = new Response_Methods();

		// Initial Payload for Request
		String payload = "{\r\n"
				+ "        \"email\": \"admin@jalaacademy.com\",\r\n"
				+ "        \"password\": \"admin123\"\r\n"
				+ "}";
		String token = httpRequest.Post_RequestForToken(payload);
		System.out.println(token);
		return token;
	}
	
	
	@Test
	public void get() {
		Request_Methods token_Request = new Request_Methods();
		token = token_Request.Signin();
		Response_Methods httpRequest = new Response_Methods();
		int statusCode = httpRequest.get_Request(token, 24);
		System.out.println(statusCode);
	}
	
	

	public int postMethod() {
		Request_Methods token_Request = new Request_Methods();
		token = token_Request.Signin();
		
		Response_Methods httpRequest = new Response_Methods();
		
		String payload = 
			"{\r\n"
			+ "    \"first_name\": \"abcd2\",\r\n"
			+ "    \"last_name\": \"abcd2\",\r\n"
			+ "    \"email\": \"abcd2@test.com\",\r\n"
			+ "    \"mobile\": \"8822778899\",\r\n"
			+ "    \"dob\": \"1995-03-06\",\r\n"
			+ "    \"gender\": \"male\",\r\n"
			+ "    \"address\": \"Test address\",\r\n"
			+ "    \"country\": \"india\",\r\n"
			+ "    \"skills\": [ \"aws\", \"fullstack\" ]\r\n"
			+ "}";
		
		String response_Body = httpRequest.post_Request(token, payload);
		int id = JsonPath.from(response_Body).get("user.id");
		System.out.println(id);
		return id;

	}
	
	@Test
	
	public void post() {
		Request_Methods token_Request = new Request_Methods();
		token_Request.postMethod();
	}
	
	
	@Test
	public void put() {
		Request_Methods token_Request = new Request_Methods();
		token = token_Request.Signin();
		
		id = 411;
		Response_Methods httpRequest = new Response_Methods();
		String payload = 
				"{\r\n"
						+ "    \"first_name\": \"B\",\r\n"
						+ "    \"last_name\": \"a\",\r\n"
						+ "    \"email\": \"ba@test.com\",\r\n"
						+ "    \"mobile\": \"8845778899\",\r\n"
						+ "    \"dob\": \"1995-03-06\",\r\n"
						+ "    \"gender\": \"male\",\r\n"
						+ "    \"address\": \"Test address\",\r\n"
						+ "    \"country\": \"india\",\r\n"
						+ "    \"skills\": [ \"aws\", \"fullstack\" ]\r\n"
						+ "}";
		
		httpRequest.put_Request(id, token, payload);
		
	}
		
	@Test
	public void delete() {
		Request_Methods token_Request = new Request_Methods();
		token = token_Request.Signin();
		Response_Methods httpRequest = new Response_Methods();
		httpRequest.delete_Request(411, token);
	}
}


