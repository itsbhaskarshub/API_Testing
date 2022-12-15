package api_Testing;

import org.testng.annotations.Test;


public class ApiGetRequest_GetApi{

	public static String token;
	public static int id;
	
	public String Signin(String payload) {
		Response_Methods httpRequest = new Response_Methods();
		String token = httpRequest.Post_RequestForToken(payload);
		return token;
	}
	
	public void get(String token, int pageno) {
		Response_Methods httpRequest = new Response_Methods();
		int statusCode = httpRequest.get_Request(token, pageno);
		System.out.println(statusCode);
	}
	


	@Test
	public void response() {
		ApiGetRequest_GetApi rm = new ApiGetRequest_GetApi();
		
		// Initial Signing 
		
		String API_Credenitial = 
				"{\r\n"
				+ "        \"email\": \"admin@jalaacademy.com\",\r\n"
				+ "        \"password\": \"admin123\"\r\n"
				+ "}";
		String token = rm.Signin(API_Credenitial);
		System.out.println(token);
		
		// Request GET response of Page no 24
		rm.get(token, 24);
		
		
	}
}


