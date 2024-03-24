package StepsDefinition.ListUsersApi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import common.RequestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseWhenSendRequestSuccessfullySteps {
	String url, method;
	//int actualStatusCode;
	HttpResponse<String> response;
	String requestBody;
	
	@Given("I have valid URL and method")
	public void i_have_valid_url_and_method(List<Map<String, String>> givenTable) {
		//url="https://reqres.in/api/users?page=2";
		Map<String, String> row1= givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method").trim();
	}
	
	@Given("I have valid request body")
	public void i_have_valid_request_body() {
		 requestBody = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}";
		
	}

	@When("I send request")
	public void i_send_request() {
		
		RequestUtils requestUtils =  new RequestUtils();
		response = requestUtils.sendRequest(url, method, "");

		
//		HttpResponse<String> response =null;
//		  try {
//		  HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
//	  
//		  response =  HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
//		  actualStatusCode=response.statusCode();
//		 // String body = response.body();
//		  
//		  } catch (Exception e) {
//			  e.printStackTrace();
//			  System.out.println("Send get request fail");
//		  }

		
	}
	
	@When("I send request with request body")
	public void i_send_request_with_request_body() {
		RequestUtils requestUtils =  new RequestUtils();
		response = requestUtils.sendRequest(url, method, requestBody);
	}
	

	@Then("I get status code and response")
	public void i_get_status_code_and_response() {
		assertEquals(response.statusCode(),200);
	}

}
