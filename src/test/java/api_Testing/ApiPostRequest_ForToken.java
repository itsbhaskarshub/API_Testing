package api_Testing;

import org.testng.annotations.Test;


public class ApiPostRequest_ForToken{

	public static String token;
	public static int id;
	
	public String Signin(String payload) {
		Response_Methods httpRequest = new Response_Methods();
		String token = httpRequest.Post_RequestForToken(payload);
		return token;
	}
	

	@Test
	public void response() {
		ApiPostRequest_ForToken rm = new ApiPostRequest_ForToken();
		
		// Initial Signing 
		
		String API_Credenitial = 
				"{\r\n"
				+ "        \"email\": \"admin@jalaacademy.com\",\r\n"
				+ "        \"password\": \"admin123\"\r\n"
				+ "}";
		String token = rm.Signin(API_Credenitial);
		System.out.println(token);
		
		
	}
}


