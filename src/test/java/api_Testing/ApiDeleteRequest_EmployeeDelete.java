package api_Testing;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ApiDeleteRequest_EmployeeDelete{

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
	
	public int post(String token, String payload) {		
		Response_Methods httpRequest = new Response_Methods();
		String response_Body = httpRequest.post_Request(token, payload);
		int id = JsonPath.from(response_Body).get("user.id");
		return id;
	}
	
	public void put(int id, String token, String payload) {
		Response_Methods httpRequest = new Response_Methods();
		httpRequest.put_Request(id, token, payload);
	}
		
	public void delete(int id, String token) {
		Response_Methods httpRequest = new Response_Methods();
		httpRequest.delete_Request(id, token);
	}

	@Test
	public void response() {
		ApiDeleteRequest_EmployeeDelete rm = new ApiDeleteRequest_EmployeeDelete();
		
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
		
		String fake_Employee_Details = 
				"{\r\n"
				+ "    \"first_name\": \"abcd6\",\r\n"
				+ "    \"last_name\": \"abcd6\",\r\n"
				+ "    \"email\": \"abcd6@test.com\",\r\n"
				+ "    \"mobile\": \"8855664800\",\r\n"
				+ "    \"dob\": \"1995-03-06\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"address\": \"Test address\",\r\n"
				+ "    \"country\": \"india\",\r\n"
				+ "    \"skills\": [ \"aws\", \"fullstack\" ]\r\n"
				+ "}";
		
		//Request Post response for New Employee Creation
		int id = rm.post(token, fake_Employee_Details);
		System.out.println("User inserted successfully with User id: "+id);
		
		// Request GET response of Page no 24 After Employee Creation
		rm.get(token, 24);
		
		String Employee_Details = 
				"{\r\n"
						+ "    \"first_name\": \"Bhaskar\",\r\n"
						+ "    \"last_name\": \"Bharatha\",\r\n"
						+ "    \"email\": \"bhaskarbharatha@test.com\",\r\n"
						+ "    \"mobile\": \"8845778899\",\r\n"
						+ "    \"dob\": \"1995-03-06\",\r\n"
						+ "    \"gender\": \"male\",\r\n"
						+ "    \"address\": \"Test address\",\r\n"
						+ "    \"country\": \"india\",\r\n"
						+ "    \"skills\": [ \"aws\", \"fullstack\" ]\r\n"
						+ "}";
		
		rm.put(id, token, Employee_Details);
		rm.delete(id, token);
	}
}


