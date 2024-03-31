package StepsDefinition.ListUsersApi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.JsonUtils;
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
	public void i_have_valid_request_body(List<Map<String, String>> givenTable) {
//		 requestBody = "{\n"+ "    \"name\": \"morpheus\",\n"+ "    \"job\": \"leader\"\n"+ "}";
	
		Map<String, String> row1= givenTable.get(0);
		String requestBodyName = row1.get("RequestBodyName").trim();
		JsonUtils jsonUtils= new JsonUtils();
		requestBody = jsonUtils.readJsonFile(requestBodyName);
		
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
	

	@Then("I get {int}")
	public void i_get_status_code_and_response(int statusCode) {
		assertEquals(response.statusCode(),statusCode);
	}
	
	@Then("I get response body with {int}")
	public void i_get_response_body_with_page(int page) {
		String responBody= response.body();
		JsonUtils jsonUtils= new JsonUtils();
		int actualPageNumber=Integer.parseInt(jsonUtils.getValueByKey(responBody, "page")); 
		assertEquals(actualPageNumber,page);
		ArrayList<String> ids= jsonUtils.getValueByArrayKey(responBody, "data", "id");
		assertEquals(ids.get(0),"7");
		assertEquals(ids.get(1),"8");
		assertEquals(ids.get(2),"9");
		assertEquals(ids.get(3),"10");

	}

}
